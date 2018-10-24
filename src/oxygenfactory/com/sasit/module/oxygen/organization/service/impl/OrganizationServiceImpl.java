package oxygenfactory.com.sasit.module.oxygen.organization.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import oxygenfactory.com.sasit.base.adapter.SuperServiceAdapter;
import oxygenfactory.com.sasit.module.oxygen.organization.dao.OrganizationDao;
import oxygenfactory.com.sasit.module.oxygen.organization.entity.AreaInfo;
import oxygenfactory.com.sasit.module.oxygen.organization.entity.OrganizationInfo;
import oxygenfactory.com.sasit.module.oxygen.organization.entity.ShopInfo;
import oxygenfactory.com.sasit.module.oxygen.organization.service.OrganizationService;

@Service("organizationService")
@Transactional
public class OrganizationServiceImpl extends SuperServiceAdapter<OrganizationDao> implements OrganizationService {
	
	@Autowired
	@Override
	public void setMapper(OrganizationDao mapper) {
		this.mapper = mapper;
	}

	@Override
	public List<OrganizationInfo> getOrganizationInfo(Map<String, Object> params) {
		Map<String, Object> params1 = null;
		Map<String, Object> params2 = new HashMap<String, Object>();
		List<AreaInfo> areaList = mapper.getAreaInfo(params1);
		List<OrganizationInfo> orgInfoList = null;
		if(areaList != null && areaList.size() !=0) {
			orgInfoList = new ArrayList<OrganizationInfo>();
			for (AreaInfo area : areaList) {
				params2.put("areaCode", area.getCode());
				List<ShopInfo> shopList = mapper.getShopInfo(params2);
				OrganizationInfo orgInfo = new OrganizationInfo();
				orgInfo.setArea(area);
				orgInfo.setShopList(shopList);
				orgInfoList.add(orgInfo);
			}
		}
		return orgInfoList;
	}

	@Override
	public List<OrganizationInfo> getPopularCommunity(Map<String, Object> params) {
		Map<String, Object> params1 = null;
		Map<String, Object> params2 = new HashMap<String, Object>();
		List<AreaInfo> areaList = mapper.getAreaInfo(params1);
		List<OrganizationInfo> orgInfoList = null;
		if(areaList != null && areaList.size() !=0) {
			orgInfoList = new ArrayList<OrganizationInfo>();
			for (AreaInfo area : areaList) {
				params2.put("areaCode", area.getCode());
				List<ShopInfo> shopList = mapper.getShopInfo(params2);
				OrganizationInfo orgInfo = new OrganizationInfo();
				orgInfo.setArea(area);
				orgInfo.setShopList(shopList);
				orgInfoList.add(orgInfo);
			}
		}
		return orgInfoList;
	}

}
