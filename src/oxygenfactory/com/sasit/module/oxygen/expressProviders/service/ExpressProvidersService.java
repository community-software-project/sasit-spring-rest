package oxygenfactory.com.sasit.module.oxygen.expressProviders.service;

import java.util.List;
import java.util.Map;

import oxygenfactory.com.sasit.base.service.SuperService;
import oxygenfactory.com.sasit.module.oxygen.expressProviders.dao.ExpressProvidersDao;
import oxygenfactory.com.sasit.module.oxygen.expressProviders.entity.ExpressProviderContacts;
import oxygenfactory.com.sasit.module.oxygen.expressProviders.entity.ExpressProvidersInfo;

public interface ExpressProvidersService extends SuperService<ExpressProvidersDao> {
	public List<ExpressProviderContacts> getExpressProviderContacts(Map<String,Object> params);
	public List<ExpressProvidersInfo> getExpressProvidersInfo(Map<String,Object> params);
	public ExpressProviderContacts checkProvidersContacts(Map<String,Object> params);
}
