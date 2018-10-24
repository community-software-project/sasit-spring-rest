package oxygenfactory.com.sasit.module.oxygen.organization.dao;

import java.util.List;
import java.util.Map;

import oxygenfactory.com.sasit.base.annotation.MapperAnnotation;
import oxygenfactory.com.sasit.base.mapper.SuperMapper;
import oxygenfactory.com.sasit.module.oxygen.organization.entity.AreaInfo;
import oxygenfactory.com.sasit.module.oxygen.organization.entity.OrganizationInfo;
import oxygenfactory.com.sasit.module.oxygen.organization.entity.ShopInfo;

@MapperAnnotation
public interface OrganizationDao extends SuperMapper {
	public List<OrganizationInfo> findOrganizations(Map<String,Object> params);
	public List<AreaInfo> getAreaInfo(Map<String,Object> params);
	public List<ShopInfo> getShopInfo(Map<String,Object> params);
	
}
