package oxygenfactory.com.sasit.module.oxygen.pickupCode.service;

import java.util.Map;

import oxygenfactory.com.sasit.base.service.SuperService;
import oxygenfactory.com.sasit.module.oxygen.pickupCode.dao.PickupCodeDao;

public interface PickupCodeService extends SuperService<PickupCodeDao> {
	public String generateExpressPickupCode(Map<String,Object> params);
	public void saveExpressPickupCode(Map<String,Object> params);
}
