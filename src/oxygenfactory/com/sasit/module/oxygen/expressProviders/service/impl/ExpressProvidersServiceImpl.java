package oxygenfactory.com.sasit.module.oxygen.expressProviders.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import oxygenfactory.com.sasit.base.adapter.SuperServiceAdapter;
import oxygenfactory.com.sasit.module.oxygen.expressProviders.dao.ExpressProvidersDao;
import oxygenfactory.com.sasit.module.oxygen.expressProviders.entity.ExpressProviderContacts;
import oxygenfactory.com.sasit.module.oxygen.expressProviders.entity.ExpressProvidersInfo;
import oxygenfactory.com.sasit.module.oxygen.expressProviders.service.ExpressProvidersService;

@Service("expressProvidersService")
@Transactional
public class ExpressProvidersServiceImpl extends SuperServiceAdapter<ExpressProvidersDao> implements ExpressProvidersService {
	
	@Autowired
	@Override
	public void setMapper(ExpressProvidersDao mapper) {
		this.mapper = mapper;
	}

	@Override
	public List<ExpressProviderContacts> getExpressProviderContacts(Map<String, Object> params) {
		return mapper.getExpressProviderContacts(params);
	}

	@Override
	public List<ExpressProvidersInfo> getExpressProvidersInfo(Map<String, Object> params) {
		return mapper.getExpressProvidersInfo(params);
	}

	@Override
	public ExpressProviderContacts checkProvidersContacts(Map<String, Object> params) {
		return mapper.checkProvidersContacts(params);
	}

}
