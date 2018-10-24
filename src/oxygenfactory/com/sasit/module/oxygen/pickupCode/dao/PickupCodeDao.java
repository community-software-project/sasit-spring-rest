package oxygenfactory.com.sasit.module.oxygen.pickupCode.dao;

import java.util.Map;

import oxygenfactory.com.sasit.base.annotation.MapperAnnotation;
import oxygenfactory.com.sasit.base.mapper.SuperMapper;

@MapperAnnotation
public interface PickupCodeDao extends SuperMapper {
	public String generateExpressPickupCode(Map<String,Object> params);
	public void saveExpressPickupCode(Map<String,Object> params);
}
