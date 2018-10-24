package oxygenfactory.com.sasit.module.oxygen.express.service.impl;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.apache.commons.lang.StringUtils;
import oxygenfactory.com.sasit.base.adapter.SuperServiceAdapter;
import oxygenfactory.com.sasit.module.oxygen.express.dao.ExpressDao;
import oxygenfactory.com.sasit.module.oxygen.express.entity.ExpressInfo;
import oxygenfactory.com.sasit.module.oxygen.express.service.ExpressService;

@Service("expressService")
@Transactional
public class ExpressServiceImpl extends SuperServiceAdapter<ExpressDao> implements ExpressService {
	
	@Autowired
	@Override
	public void setMapper(ExpressDao mapper) {
		this.mapper = mapper;
	}

	@Override
	public List<ExpressInfo> getExpressInfo(Map<String, Object> params) {
		return mapper.findExpress(params);
	}

	@Override
	public synchronized String getExpressLocation(Map<String, Object> params) {
		String value = mapper.getExpressLocation(params);
		String location = StringUtils.leftPad(value, 3, "0");
		return location;
	}

	@Override
	public void addExpress(ExpressInfo expressInfo) {
		mapper.addExpress(expressInfo);
	}

	@Override
	public List<ExpressInfo> selfHandleExpressDelivery(Map<String, Object> params) {
		return mapper.selfHandleExpressDelivery(params);
	}

	@Override
	public Integer customersExpressCount(Map<String, Object> params) {
		return mapper.customersExpressCount(params);
	}
	
}
