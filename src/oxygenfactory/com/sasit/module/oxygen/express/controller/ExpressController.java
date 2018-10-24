package oxygenfactory.com.sasit.module.oxygen.express.controller;

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

import com.google.gson.Gson;

import oxygenfactory.com.sasit.module.oxygen.express.entity.ExpressInfo;
import oxygenfactory.com.sasit.module.oxygen.express.service.ExpressService;

@RestController
public class ExpressController {
	private final String LOCATION_CODE_TYPE_ = "seq_locationCodeByExpressType_";
	private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private static final SimpleDateFormat batchFormat = new SimpleDateFormat("yyyyMMdd");
	@Autowired(required = true)
	public ExpressService expressService;

	@RequestMapping(value = "/express", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
	public ResponseEntity<String> getExpressInfo(HttpServletRequest req, HttpServletResponse res) {
		Map<String, Object> params = new HashMap<String, Object>();
		List<ExpressInfo> expressInfo = expressService.getExpressInfo(params);
		Gson g = new Gson();
		String expressInfoJs = g.toJson(expressInfo);
		return new ResponseEntity<String>(expressInfoJs, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/express/{phoneNumber}", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
	public ResponseEntity<String> getExpressCommunity(@PathVariable("phoneNumber") String phoneNumber) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("phoneNumber", phoneNumber);
		List<ExpressInfo> expressInfo = expressService.getExpressInfo(params);
		Gson g = new Gson();
		String expressJs = g.toJson(expressInfo);
		return new ResponseEntity<String>(expressJs, HttpStatus.OK);
	}
	
	@ResponseBody
	@RequestMapping(value = "/express", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public ResponseEntity<String> addExpress(@RequestBody ExpressInfo expressInfo) {
		Integer providerId = expressInfo.getExpressServiceId();
		expressInfo.setBatchNumber("M"+providerId+batchFormat.format(new Date()));
		expressInfo.setOperaTime(sdf.format(new Date()));
		expressInfo.setRemark(expressInfo.getOperator()+" APP端入库");
		expressService.addExpress(expressInfo);
		Gson gson = new Gson();
		return new ResponseEntity<String>(gson.toJson(expressInfo), HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/express/{type}/{serviceShopCode}", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
	public ResponseEntity<String> getExpressLocation(@PathVariable("type") String type, @PathVariable("serviceShopCode") String serviceShopCode) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("serviceShopCode", serviceShopCode);
		params.put("type", LOCATION_CODE_TYPE_+type);
		String expressLocation = expressService.getExpressLocation(params);
		Gson g = new Gson();
		String expressLocationJs = g.toJson(type+expressLocation);
		return new ResponseEntity<String>(expressLocationJs, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/express/{operator}/{serviceShopCode}/selfHandleExpressDelivery", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
	public ResponseEntity<String> getExpressListByProvider(@PathVariable("operator") String operator, @PathVariable("serviceShopCode") String serviceShopCode) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("operator", operator);
		params.put("serviceShopCode", serviceShopCode);
		List<ExpressInfo> eList = expressService.selfHandleExpressDelivery(params);
		Gson g = new Gson();
		String expressJs = g.toJson(eList);
		return new ResponseEntity<String>(expressJs, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/express/{phoneNumber}/expressCount", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
	public ResponseEntity<String> customersExpressCount(@PathVariable("phoneNumber") String phoneNumber) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("phoneNumber", phoneNumber);
		Integer count = expressService.customersExpressCount(params);
		Gson g = new Gson();
		String countJs = g.toJson(count);
		return new ResponseEntity<String>(countJs, HttpStatus.OK);
	}

}
