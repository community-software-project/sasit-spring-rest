package oxygenfactory.com.sasit.module.oxygen.customer.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.google.gson.Gson;

import it.sauronsoftware.base64.Base64;
import net.sf.json.JSONObject;
import oxygenfactory.com.sasit.module.oxygen.customer.entity.CustomerInfo;
import oxygenfactory.com.sasit.module.oxygen.customer.service.CustomerInfoService;
import oxygenfactory.com.sasit.module.tools.Encryption;
import oxygenfactory.com.sasit.module.tools.MD5Utils;

//@CrossOrigin(origins = "127.0.0.1:8088", maxAge = 3600)
@RestController
public class CustomerController {

	private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	@Autowired(required = true)
	public CustomerInfoService customerService;

	/**
	 * 查询用户列表
	 * @param req
	 * @param res
	 * @return
	 */
	@RequestMapping(value = "/customers", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
	public ResponseEntity<String> listAllCustomers(HttpServletRequest req, HttpServletResponse res) {
		Map<String, Object> params = new HashMap<String, Object>();
		PageBounds pageBounds = new PageBounds();
		List<CustomerInfo> customers = customerService.findAllCustomers(params, pageBounds);
		Gson g = new Gson();
		String customersJs = g.toJson(customers);
		return new ResponseEntity<String>(customersJs, HttpStatus.OK);
	}

	/**
	 * 查询用户信息
	 * @param phoneNumber
	 * @return
	 */
	@RequestMapping(value = "/customers/{phoneNumber}", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
	public ResponseEntity<String> getCustomer(@PathVariable("phoneNumber") String phoneNumber) {
		System.out.println("Fetching User with id " + phoneNumber);
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("phoneNumber", phoneNumber);
		CustomerInfo customer = customerService.findByPhoneNumber(param);
		Gson g = new Gson();
		if (customer == null) {
			System.out.println("User with phone " + phoneNumber + " not found");
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}
		String customersJs = g.toJson(customer);
		return new ResponseEntity<String>(customersJs, HttpStatus.OK);
	}

	/**
	 * 检查用户是否存在
	 * @param phoneNumber
	 * @return
	 */
	@RequestMapping(value = "/customers/{phoneNumber}/isExist", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
	public ResponseEntity<String> isCustomerExist(@PathVariable("phoneNumber") String phoneNumber) {
		Integer count = customerService.isCustomerExist(phoneNumber);
		JSONObject js = new JSONObject();
		js.put("COUNT", count);
		if (count == 0) {
			js.put("IS_CUSTOMER_EXIST", false);
		} else {
			Integer loginFrequency = customerService.checkLoginFrequency(phoneNumber);
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("phoneNumber", phoneNumber);
			CustomerInfo customerInfo = customerService.findByPhoneNumber(param);
			Gson gson = new Gson();
			String cStr = gson.toJson(customerInfo);
			js.put("IS_CUSTOMER_EXIST", true);
			js.put("CUSTOMER_INFO", cStr);
			js.put("LOGIN_FREQUENCY", loginFrequency);
		}
		return new ResponseEntity<String>(js.toString(), HttpStatus.OK);
	}
	
	/**
	 * 检查用户是否存在&验证密码
	 * @param phoneNumber
	 * @param encryptionCode
	 * @return
	 */
	@RequestMapping(value = "/customers/{phoneNumber}/{encryptionCode}/isExistByPermission", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
	public ResponseEntity<String> isCustomerExist(@PathVariable("phoneNumber") String phoneNumber, @PathVariable("encryptionCode") String encryptionCode) {
		String encryptionPass = reduction(encryptionCode);
		String md5Encryption =  MD5Utils.encodeMd5(encryptionPass, phoneNumber);
		Integer count = customerService.isCustomerExist(phoneNumber);
		JSONObject js = new JSONObject();
		js.put("COUNT", count);
		if (count == 0) {
			js.put("IS_CUSTOMER_EXIST", false);
		} else {
			Map<String,Object> params= new HashMap<String,Object>();
			params.put("phoneNumber", phoneNumber);
			String oldPd = customerService.getOldPassword(params);
			if(oldPd != null && oldPd.equalsIgnoreCase(md5Encryption)) {
				js.put("PERMISSION", true);
			} else {
				js.put("PERMISSION", false);
			}
			Integer loginFrequency = customerService.checkLoginFrequency(phoneNumber);
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("phoneNumber", phoneNumber);
			CustomerInfo customerInfo = customerService.findByPhoneNumber(param);
			Gson gson = new Gson();
			String cStr = gson.toJson(customerInfo);
			js.put("IS_CUSTOMER_EXIST", true);
			js.put("CUSTOMER_INFO", cStr);
			js.put("LOGIN_FREQUENCY", loginFrequency);
		}
		return new ResponseEntity<String>(js.toString(), HttpStatus.OK);
	}

	/**
	 * 更新客户网点信息
	 * @param customer
	 * @param phoneNumber
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/customers/{phoneNumber}", method = RequestMethod.PUT, produces = "application/json;charset=utf-8")
	public ResponseEntity<String> updateCustomers(@RequestBody CustomerInfo customer, @PathVariable("phoneNumber") String phoneNumber) {
		customer.setPhoneNumber(phoneNumber);
		 customerService.updateCustomerShopInfo(customer);
		Gson gson = new Gson();
		return new ResponseEntity<String>(gson.toJson(customer), HttpStatus.CREATED);
	}

	/**
	 * 新增客户
	 * @param customer
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/customers", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public ResponseEntity<String> addCustomer(@RequestBody CustomerInfo customer) {
		String phoneNumber = customer.getPhoneNumber();
		String realBase64Password = reduction(customer.getPassword());
		String md5Password = MD5Utils.encodeMd5(realBase64Password, phoneNumber);
		customer.setCreateDate(sdf.format(new Date()));
		customer.setPassword(md5Password);
		customer.setName(phoneNumber);
		customer.setLoginName(phoneNumber);
		 customerService.addCustomer(customer);
		Gson gson = new Gson();
		return new ResponseEntity<String>(gson.toJson(customer), HttpStatus.CREATED);
	}

//	@ResponseBody
//	@RequestMapping(value = "/customers/{phoneNumber}", method = RequestMethod.DELETE, produces = "application/json;charset=utf-8")
//	public ResponseEntity<String> getCustomersByPhoneNumber(@RequestBody CustomerInfo customer, @PathVariable("phoneNumber") String phoneNumber) {
//		Gson gson = new Gson();
//		return new ResponseEntity<String>(gson.toJson(phoneNumber), HttpStatus.OK);
//	}
	
	/**
	 * 重置密码
	 * @param customer
	 * @param phoneNumber
	 * @param old
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/customers/{phoneNumber}/initialize/{old}", method = RequestMethod.PUT, produces = "application/json;charset=utf-8")
	public ResponseEntity<String> initializePassword(@RequestBody CustomerInfo customer, 
			@PathVariable("phoneNumber") String phoneNumber, 
			@PathVariable("old") String old) {
		String oldPass = reduction(old);
		String md5OldPass =  MD5Utils.encodeMd5(oldPass, phoneNumber);
		String pdcode = reduction(customer.getPassword());
		String md5Password = MD5Utils.encodeMd5(pdcode, phoneNumber);
		Map<String,Object> params= new HashMap<String,Object>();
		params.put("phoneNumber", phoneNumber);
		params.put("password", md5Password);
		JSONObject json = new JSONObject();
		json.put("TAG", true);
		json.put("MSG", "修改成功");
		try 
		{
			String oldPd = customerService.getOldPassword(params);
			if(oldPd.equalsIgnoreCase(md5OldPass)) {
				customerService.initializePassword(params);
			} else {
				json.put("TAG", false);
				json.put("MSG", "密码错误");
			}
		} catch (Exception e) {
			json.put("TAG", false);
			json.put("MSG", e.getMessage());
		}
		return new ResponseEntity<String>(json.toString(), HttpStatus.CREATED);
	}
	
	/**
	 * 初始化密码
	 * @param customer
	 * @param phoneNumber
	 * @param old
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/customers/{phoneNumber}/initialize", method = RequestMethod.PUT, produces = "application/json;charset=utf-8")
	public ResponseEntity<String> initialize(@RequestBody CustomerInfo customer, @PathVariable("phoneNumber") String phoneNumber) {
		String pdcode = reduction(customer.getPassword());
		String md5Password = MD5Utils.encodeMd5(pdcode, phoneNumber);
		Map<String,Object> params= new HashMap<String,Object>();
		params.put("phoneNumber", phoneNumber);
		params.put("password", md5Password);
		JSONObject json = new JSONObject();
		json.put("TAG", true);
		json.put("MSG", "设置成功");
		try 
		{
			customerService.initializePassword(params);
		} catch (Exception e) {
			json.put("TAG", false);
			json.put("MSG", e.getMessage());
		}
		return new ResponseEntity<String>(json.toString(), HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/customers/{phoneNumber}/{shopCode}/isProviderContacts", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
	public ResponseEntity<String> isProviderContacts(@PathVariable("phoneNumber") String phoneNumber, @PathVariable("shopCode") String shopCode) {
		Map<String,Object> params= new HashMap<String,Object>();
		params.put("phoneNumber", phoneNumber);
		params.put("serviceShopCode", shopCode);
		List<Map<String,Object>> obj = customerService.isProviderContacts(params);
		JSONObject js = new JSONObject();
		Gson gson = new Gson();
		if(obj == null || obj.size() == 0) {
			js.put("TAG", false);
		} else {
			js.put("TAG", true);
			String res = gson.toJson(obj);
			js.put("CONTACTS", res);
		}
		return new ResponseEntity<String>(js.toString(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/customers/{phoneNumber}/checkShopCode", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
	public ResponseEntity<String> checkShopCode(@PathVariable("phoneNumber") String phoneNumber) {
		Map<String,Object> params= new HashMap<String,Object>();
		params.put("phoneNumber", phoneNumber);
		Map<String,Object> obj = customerService.checkShopCode(params);
		JSONObject js = new JSONObject();
		if(obj != null) {
			String serviceShopCode = obj.get("SERVICE_SHOP_CODE") ==null?"":obj.get("SERVICE_SHOP_CODE").toString();
			String areaCode = obj.get("AREA_CODE")==null?"":obj.get("AREA_CODE").toString();
			js.put("SERVICE_SHOP_CODE", serviceShopCode);
			js.put("AREA_CODE", areaCode);
		} 
		return new ResponseEntity<String>(js.toString(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/customers/{phoneNumber}/{shopCode}/isStoresEmployee", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
	public ResponseEntity<String> isStoresEmployee(@PathVariable("phoneNumber") String phoneNumber, @PathVariable("shopCode") String shopCode) {
		Map<String,Object> params= new HashMap<String,Object>();
		params.put("phoneNumber", phoneNumber);
		params.put("serviceShopCode", shopCode);
		List<Map<String,Object>> obj = customerService.isStoresEmployee(params);
		JSONObject js = new JSONObject();
		Gson gson = new Gson();
		if(obj == null || obj.size() == 0) {
			js.put("TAG", false);
		} else {
			js.put("TAG", true);
			String res = gson.toJson(obj);
			js.put("EMPLOYEE", res);
		}
		return new ResponseEntity<String>(js.toString(), HttpStatus.OK);
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/customers/{tailNumber}/{shopCode}/tail", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
	public ResponseEntity<String> getCustomersByPhoneTail(@PathVariable("tailNumber") String tailNumber, @PathVariable("shopCode") String shopCode) {
		Map<String,Object> params= new HashMap<String,Object>();
		params.put("tailNumber", tailNumber);
		params.put("shopCode", shopCode);
		List<CustomerInfo> customer = customerService.getCustomersByPhoneTail(params);
		Gson gson = new Gson();
		String customersJs = gson.toJson(customer);
		return new ResponseEntity<String>(customersJs, HttpStatus.OK);
	}
	
	@ResponseBody
	@RequestMapping(value = "/customers/{phoneNumber}/modifyCustomerName", method = RequestMethod.PUT, produces = "application/json;charset=utf-8")
	public ResponseEntity<String> modifyCustomerName(@RequestBody CustomerInfo customer, @PathVariable("phoneNumber") String phoneNumber) {
		customer.setPhoneNumber(phoneNumber);
		customerService.modifyCustomerName(customer);
		Gson gson = new Gson();
		return new ResponseEntity<String>(gson.toJson(customer), HttpStatus.CREATED);
	}
	
	private static String reduction(String code) {
		String realBase64Code = Encryption.reduction(code, 3);
		String realCode = Base64.decode(realBase64Code);
		return realCode;
	}
	
}
