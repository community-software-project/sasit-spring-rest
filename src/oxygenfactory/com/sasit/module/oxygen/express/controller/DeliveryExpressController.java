package oxygenfactory.com.sasit.module.oxygen.express.controller;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import oxygenfactory.com.sasit.module.oxygen.express.entity.DeliveryExpressInfo;
import oxygenfactory.com.sasit.module.oxygen.express.entity.ExpressInfo;
import oxygenfactory.com.sasit.module.oxygen.express.service.DeliveryExpressService;

@RestController
public class DeliveryExpressController {
	private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private static final SimpleDateFormat batchFormat = new SimpleDateFormat("yyyyMMdd");
	@Autowired(required = true)
	public DeliveryExpressService deliveryexpressService;

	@RequestMapping(value = "/deliveryExpress/{barCode}", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
	public ResponseEntity<String> getExpressCommunity(@PathVariable("barCode") String barCode) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("barCode", barCode);
		List<ExpressInfo> expressInfo = deliveryexpressService.getExpressListByBarCode(params);
		Gson g = new Gson();
		String expressJs = g.toJson(expressInfo);
		return new ResponseEntity<String>(expressJs, HttpStatus.OK);
	}

	@RequestMapping(value = "/deliveryExpress/{phoneNumber}/phoneNumber", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
	public ResponseEntity<String> getExpressCommunityByPhoneNumber(@PathVariable("phoneNumber") String phoneNumber) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("phoneNumber", phoneNumber);
		params.put("shortPhoneNumber", subPhoneNumber(phoneNumber));
		List<ExpressInfo> expressInfo = deliveryexpressService.getExpressListByPhoneNumber(params);
		Gson g = new Gson();
		String expressJs = g.toJson(expressInfo);
		return new ResponseEntity<String>(expressJs, HttpStatus.OK);
	}

	@ResponseBody
	@RequestMapping(value = "/deliveryExpress/outOperation", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public ResponseEntity<String> outExpressOperation(@RequestBody DeliveryExpressInfo deliveryExpressInfo) {
		String[] isList = deliveryExpressInfo.getIdList();
		try 
		{
			for (String id : isList) {
				Map<String, Object> params = new HashMap<String, Object>();
				params.put("id", id);
				deliveryexpressService.outExpressOperation(params);
			}
			deliveryExpressInfo.setMsg("出库成功");
		} catch (Exception e) {
			deliveryExpressInfo.setMsg(e.getMessage());
		}
		Gson gson = new Gson();
		return new ResponseEntity<String>(gson.toJson(deliveryExpressInfo), HttpStatus.OK);
	}

	private String subPhoneNumber(String phoneNumber) {
		if (phoneNumber != null && phoneNumber.length() > 4) {
			return phoneNumber.substring(phoneNumber.length() - 5);
		} else {
			return phoneNumber;
		}
	}
}
