package oxygenfactory.com.sasit.module.oxygen.express.dao;

import java.util.List;
import java.util.Map;

import oxygenfactory.com.sasit.base.annotation.MapperAnnotation;
import oxygenfactory.com.sasit.base.mapper.SuperMapper;
import oxygenfactory.com.sasit.module.oxygen.express.entity.ExpressInfo;

@MapperAnnotation
public interface ExpressDao extends SuperMapper {
	public List<ExpressInfo> findExpress(Map<String,Object> params);
	public String getExpressLocation(Map<String, Object> params);
	public void addExpress(ExpressInfo expressInfo);
	public List<ExpressInfo> selfHandleExpressDelivery(Map<String,Object> params);
	public Integer customersExpressCount(Map<String,Object> params);
	
}
