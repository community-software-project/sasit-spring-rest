package oxygenfactory.com.sasit.module.oxygen.express.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import oxygenfactory.com.sasit.base.adapter.SuperServiceAdapter;
import oxygenfactory.com.sasit.module.oxygen.express.dao.RecordSendExpressDao;
import oxygenfactory.com.sasit.module.oxygen.express.entity.RecordSendExpressInfo;
import oxygenfactory.com.sasit.module.oxygen.express.service.RecordSendExpressService;

@Service("recordSendExpressService")
@Transactional
public class RecordSendExpressServiceImpl extends SuperServiceAdapter<RecordSendExpressDao> implements RecordSendExpressService {
	
	@Autowired
	@Override
	public void setMapper(RecordSendExpressDao mapper) {
		this.mapper = mapper;
	}

	@Override
	public void recordSendExpressInfo(RecordSendExpressInfo recordSendExpress) {
		mapper.recordSendExpressInfo(recordSendExpress);
	}

	@Override
	public List<RecordSendExpressInfo> currentMonthSendExpressList(Map<String, Object> params) {
		return mapper.currentMonthSendExpressList(params);
	}

}
