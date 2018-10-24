package oxygenfactory.com.sasit.module.oxygen.express.dao;

import java.util.List;
import java.util.Map;

import oxygenfactory.com.sasit.base.annotation.MapperAnnotation;
import oxygenfactory.com.sasit.base.mapper.SuperMapper;
import oxygenfactory.com.sasit.module.oxygen.express.entity.RecordSendExpressInfo;

@MapperAnnotation
public interface RecordSendExpressDao extends SuperMapper {
	public void recordSendExpressInfo(RecordSendExpressInfo recordSendExpress);
	public List<RecordSendExpressInfo> currentMonthSendExpressList(Map<String, Object> params);
}
