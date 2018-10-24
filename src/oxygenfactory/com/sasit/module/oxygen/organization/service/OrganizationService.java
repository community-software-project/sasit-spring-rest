package oxygenfactory.com.sasit.module.oxygen.organization.service;

import java.util.List;
import java.util.Map;

import oxygenfactory.com.sasit.base.service.SuperService;
import oxygenfactory.com.sasit.module.oxygen.organization.dao.OrganizationDao;
import oxygenfactory.com.sasit.module.oxygen.organization.entity.OrganizationInfo;

public interface OrganizationService extends SuperService<OrganizationDao> {
	public List<OrganizationInfo> getOrganizationInfo(Map<String, Object> params);
	public List<OrganizationInfo> getPopularCommunity(Map<String, Object> params);

}
