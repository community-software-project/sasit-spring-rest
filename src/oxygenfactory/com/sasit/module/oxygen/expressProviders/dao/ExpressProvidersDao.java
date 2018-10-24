package oxygenfactory.com.sasit.module.oxygen.expressProviders.dao;

import java.util.List;
import java.util.Map;

import oxygenfactory.com.sasit.base.annotation.MapperAnnotation;
import oxygenfactory.com.sasit.base.mapper.SuperMapper;
import oxygenfactory.com.sasit.module.oxygen.expressProviders.entity.ExpressProviderContacts;
import oxygenfactory.com.sasit.module.oxygen.expressProviders.entity.ExpressProvidersInfo;

@MapperAnnotation
public interface ExpressProvidersDao extends SuperMapper {
	public List<ExpressProviderContacts> getExpressProviderContacts(Map<String,Object> params);
	public List<ExpressProvidersInfo> getExpressProvidersInfo(Map<String,Object> params);
	public ExpressProviderContacts checkProvidersContacts(Map<String,Object> params);
}
