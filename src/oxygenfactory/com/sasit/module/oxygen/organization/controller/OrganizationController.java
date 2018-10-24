package oxygenfactory.com.sasit.module.oxygen.organization.controller;

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

import oxygenfactory.com.sasit.module.oxygen.organization.entity.OrganizationInfo;
import oxygenfactory.com.sasit.module.oxygen.organization.service.OrganizationService;

@RestController
public class OrganizationController {

	@Autowired(required = true)
	public OrganizationService organizationService;

	@RequestMapping(value = "/organizations", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
	public ResponseEntity<String> getOrganizationInfo(HttpServletRequest req, HttpServletResponse res) {
		Map<String, Object> params = new HashMap<String, Object>();
		List<OrganizationInfo> organizations = organizationService.getOrganizationInfo(params);
		Gson g = new Gson();
		String organizationsJs = g.toJson(organizations);
		return new ResponseEntity<String>(organizationsJs, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/organizations/popularCommunity", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
	public ResponseEntity<String> getPopularCommunity(HttpServletRequest req, HttpServletResponse res) {
		Map<String, Object> params = new HashMap<String, Object>();
		List<OrganizationInfo> organizations = organizationService.getPopularCommunity(params);
		Gson g = new Gson();
		String organizationsJs = g.toJson(organizations);
		return new ResponseEntity<String>(organizationsJs, HttpStatus.OK);
	}

}
