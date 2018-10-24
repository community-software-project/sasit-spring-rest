package oxygenfactory.com.sasit.module.oxygen.pickupCode.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import oxygenfactory.com.sasit.module.oxygen.pickupCode.service.PickupCodeService;
import oxygenfactory.com.sasit.module.tools.TenpayUtil;

@RestController
public class PickupCodeController {
	private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	@Autowired(required = true)
	public PickupCodeService pickupCodeService;

	@RequestMapping(value = "/pickupCode/{areaCode}/{serviceShopCode}/{selectList}/initBarCode", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
	public ResponseEntity<String> initBarCode(@PathVariable("areaCode") String areaCode,
			@PathVariable("serviceShopCode") String serviceShopCode, @PathVariable("selectList") String selectList) {
		System.out.println(selectList);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String dsp = sdf.format(new Date());
		String pickupCode = getBarCode(areaCode, serviceShopCode, dsp);
		saveExpressPickupCode(areaCode, serviceShopCode, pickupCode, selectList);
		Gson g = new Gson();
		String pickupCodeJs = g.toJson(pickupCode);
		return new ResponseEntity<String>(pickupCodeJs, HttpStatus.OK);
	}

	private void saveExpressPickupCode(String areaCode, String shopCode, String barCode, String selectList) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Date currDate = new Date();
		String dsp = sdf.format(currDate);
		String[] expressStrIds = selectList.split(",");
		for (String id : expressStrIds) {
			Integer expressId = Integer.valueOf(id);
			Map<String, Object> barcodeExpressMap = new HashMap<String, Object>();
			barcodeExpressMap.put("expressId", expressId);
			barcodeExpressMap.put("areaCode", areaCode);
			barcodeExpressMap.put("serviceShopCode", shopCode);
			barcodeExpressMap.put("barCode", barCode);
			barcodeExpressMap.put("timestampSpe", dsp);
			barcodeExpressMap.put("operaTime", currDate);
			barcodeExpressMap.put("operator", null);
			barcodeExpressMap.put("orderCode", null);
			pickupCodeService.saveExpressPickupCode(barcodeExpressMap);
		}
	}

	private String getBarCode(String areaCode, String serviceShopCode, String timestampSpe) {
		String currTime = TenpayUtil.getCurrTime();
		String barCode = currTime + areaCode + random(10000) + serviceShopCode;
		return barCode;
	}

	public String random(Integer a) {
		int s = (int) (Math.random() * a);
		return s + "";
	}

}
