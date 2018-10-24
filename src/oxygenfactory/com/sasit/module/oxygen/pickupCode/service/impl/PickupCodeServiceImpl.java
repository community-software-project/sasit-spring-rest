package oxygenfactory.com.sasit.module.oxygen.pickupCode.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import oxygenfactory.com.sasit.base.adapter.SuperServiceAdapter;
import oxygenfactory.com.sasit.module.oxygen.pickupCode.dao.PickupCodeDao;
import oxygenfactory.com.sasit.module.oxygen.pickupCode.service.PickupCodeService;

@Service("pickupCodeService")
@Transactional
public class PickupCodeServiceImpl extends SuperServiceAdapter<PickupCodeDao> implements PickupCodeService {
	
	@Autowired
	@Override
	public void setMapper(PickupCodeDao mapper) {
		this.mapper = mapper;
	}

	@Override
	public String generateExpressPickupCode(Map<String, Object> params) {
		return null;
	}

	@Override
	public void saveExpressPickupCode(Map<String, Object> params) {
		mapper.saveExpressPickupCode(params);
	}

	
	
}
