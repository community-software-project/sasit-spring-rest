package oxygenfactory.com.sasit.module.oxygen.express.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
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

import oxygenfactory.com.sasit.module.oxygen.express.entity.ExpressInfo;
import oxygenfactory.com.sasit.module.oxygen.express.entity.RecordSendExpressInfo;
import oxygenfactory.com.sasit.module.oxygen.express.service.RecordSendExpressService;
import oxygenfactory.com.sasit.module.tools.DateTools;

@RestController
public class RecordSendExpressController {
	private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	@Autowired(required = true)
	public RecordSendExpressService recordSendExpressService;

	@ResponseBody
	@RequestMapping(value = "/recordSendExpress/recordSendExpressInfo", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public ResponseEntity<String> recordSendExpressInfo(@RequestBody RecordSendExpressInfo recordSendExpress) {
		recordSendExpress.setOperaTime(sdf.format(new Date()));
		recordSendExpress.setType("1");
		Gson gson = new Gson();
		String res;
		try 
		{
			recordSendExpressService.recordSendExpressInfo(recordSendExpress);
			res = gson.toJson(recordSendExpress);
		} catch (Exception e) {
			e.printStackTrace();
			res = gson.toJson(e);
		}
		return new ResponseEntity<String>(res, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/recordSendExpress/{shopCode}/{providerId}/currentMonthData", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
	public ResponseEntity<String> currentMonthData(@PathVariable("shopCode") String shopCode, @PathVariable("providerId") String providerId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("shopCode", shopCode);
		params.put("providerId", providerId);
		params.put("startDate", DateTools.getBeginDayOfMonth());
		params.put("endDate", DateTools.getEndDayOfMonth());
		List<RecordSendExpressInfo> sendExpress = recordSendExpressService.currentMonthSendExpressList(params);
		Gson g = new Gson();
		String expressJs = g.toJson(sendExpress);
		return new ResponseEntity<String>(expressJs, HttpStatus.OK);
	}

}
