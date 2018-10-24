package oxygenfactory.com.sasit.module.oxygen.express.dao;

import java.util.List;
import java.util.Map;

import oxygenfactory.com.sasit.base.annotation.MapperAnnotation;
import oxygenfactory.com.sasit.base.mapper.SuperMapper;
import oxygenfactory.com.sasit.module.oxygen.express.entity.ExpressInfo;

@MapperAnnotation
public interface DeliveryExpressDao extends SuperMapper {
	public List<ExpressInfo> getExpressListByBarCode(Map<String,Object> params);
	public List< ExpressInfo> getExpressListByPhoneNumber(Map<String, Object> params);
	public void outExpressOperation(Map<String, Object> params);
	public void letExpressInLogTable(ExpressInfo expressInfo);
	public ExpressInfo getExpressById(Map<String, Object> params);
}
