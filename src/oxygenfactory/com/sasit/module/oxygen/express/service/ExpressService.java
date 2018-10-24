package oxygenfactory.com.sasit.module.oxygen.express.service;

import java.util.List;
import java.util.Map;

import oxygenfactory.com.sasit.base.service.SuperService;
import oxygenfactory.com.sasit.module.oxygen.express.dao.ExpressDao;
import oxygenfactory.com.sasit.module.oxygen.express.entity.ExpressInfo;

public interface ExpressService extends SuperService<ExpressDao> {
	public List< ExpressInfo> getExpressInfo(Map<String, Object> params);
	public String getExpressLocation(Map<String, Object> params);
	public void addExpress(ExpressInfo expressInfo);
	public List<ExpressInfo> selfHandleExpressDelivery(Map<String,Object> params);
	public Integer customersExpressCount(Map<String,Object> params);
}
