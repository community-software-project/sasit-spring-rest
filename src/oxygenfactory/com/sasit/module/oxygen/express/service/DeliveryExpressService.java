package oxygenfactory.com.sasit.module.oxygen.express.service;

import java.util.List;
import java.util.Map;

import oxygenfactory.com.sasit.base.service.SuperService;
import oxygenfactory.com.sasit.module.oxygen.express.dao.DeliveryExpressDao;
import oxygenfactory.com.sasit.module.oxygen.express.entity.ExpressInfo;

public interface DeliveryExpressService extends SuperService<DeliveryExpressDao> {
	public List< ExpressInfo> getExpressListByBarCode(Map<String, Object> params);
	public List< ExpressInfo> getExpressListByPhoneNumber(Map<String, Object> params);
	public ExpressInfo getExpressById(Map<String, Object> params);
	public void outExpressOperation(Map<String, Object> params);
}
