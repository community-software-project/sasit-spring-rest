package oxygenfactory.com.sasit.module.oxygen.express.service;

import java.util.List;
import java.util.Map;
import oxygenfactory.com.sasit.base.service.SuperService;
import oxygenfactory.com.sasit.module.oxygen.express.dao.RecordSendExpressDao;
import oxygenfactory.com.sasit.module.oxygen.express.entity.RecordSendExpressInfo;

public interface RecordSendExpressService extends SuperService<RecordSendExpressDao> {
	public void recordSendExpressInfo(RecordSendExpressInfo recordSendExpress);
	public List<RecordSendExpressInfo> currentMonthSendExpressList(Map<String, Object> params);
}
