package oxygenfactory.com.sasit.module.oxygen.xAuthToken.controller;

import java.util.HashMap;
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

import oxygenfactory.com.sasit.module.oxygen.xAuthToken.service.AuthTokenService;

@RestController
public class AuthTokenController {

	@Autowired(required = true)
	public AuthTokenService authTokenService;

	@RequestMapping(value = "/authToken", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
	public ResponseEntity<String> getOrganizationInfo(HttpServletRequest req, HttpServletResponse res) {
		Map<String, Object> params = new HashMap<String, Object>();
		Gson g = new Gson();
		String organizationsJs = g.toJson(null);
		return new ResponseEntity<String>(organizationsJs, HttpStatus.OK);
	}
	

}
