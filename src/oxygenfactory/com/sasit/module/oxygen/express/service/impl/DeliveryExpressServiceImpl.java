package oxygenfactory.com.sasit.module.oxygen.express.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import oxygenfactory.com.sasit.base.adapter.SuperServiceAdapter;
import oxygenfactory.com.sasit.module.oxygen.express.dao.DeliveryExpressDao;
import oxygenfactory.com.sasit.module.oxygen.express.entity.ExpressInfo;
import oxygenfactory.com.sasit.module.oxygen.express.service.DeliveryExpressService;

@Service("deliveryExpressService")
@Transactional
public class DeliveryExpressServiceImpl extends SuperServiceAdapter<DeliveryExpressDao> implements DeliveryExpressService {
	
	private static final SimpleDateFormat outBatchFormat = new SimpleDateFormat("yyyyMMddHHmm");
	
	@Autowired
	@Override
	public void setMapper(DeliveryExpressDao mapper) {
		this.mapper = mapper;
	}

	@Override
	public List<ExpressInfo> getExpressListByBarCode(Map<String, Object> params) {
		return mapper.getExpressListByBarCode(params);
	}

	@Override
	public List<ExpressInfo> getExpressListByPhoneNumber(Map<String, Object> params) {
		return mapper.getExpressListByPhoneNumber(params);
	}

	@Override
	public ExpressInfo getExpressById(Map<String, Object> params) {
		return mapper.getExpressById(params);
	}

	@Override
	@Transactional
	public void outExpressOperation(Map<String, Object> params) {
		ExpressInfo e = mapper.getExpressById(params);
		e.setExpressLocation(null);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		e.setOutBatchNumber("OUT"+outBatchFormat.format(new Date()));
		e.setOutOperaTime(sdf.format(new Date()));
		mapper.letExpressInLogTable(e);
		mapper.outExpressOperation(params);
	}

}
