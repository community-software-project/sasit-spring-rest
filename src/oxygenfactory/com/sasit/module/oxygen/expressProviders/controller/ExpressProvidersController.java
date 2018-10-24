package oxygenfactory.com.sasit.module.oxygen.expressProviders.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import oxygenfactory.com.sasit.module.oxygen.expressProviders.entity.ExpressProvidersInfo;
import oxygenfactory.com.sasit.module.oxygen.expressProviders.service.ExpressProvidersService;

@RestController
public class ExpressProvidersController {

	@Autowired(required = true)
	public ExpressProvidersService expressProvidersService;

	@RequestMapping(value = "/expressProviders", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
	public ResponseEntity<String> getExpressProvidersInfo(HttpServletRequest req, HttpServletResponse res) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("type", "1");
		List<ExpressProvidersInfo> expressProviders = expressProvidersService.getExpressProvidersInfo(params);
		Gson g = new Gson();
		String expressProvidersJs = g.toJson(expressProviders);
		return new ResponseEntity<String>(expressProvidersJs, HttpStatus.OK);
	}

}
