package oxygenfactory.com.sasit.module.oxygen.xAuthToken.dao;

import java.util.List;
import java.util.Map;

import oxygenfactory.com.sasit.base.annotation.MapperAnnotation;
import oxygenfactory.com.sasit.base.mapper.SuperMapper;
import oxygenfactory.com.sasit.module.oxygen.xAuthToken.entity.AuthTokenInfo;

@MapperAnnotation
public interface AuthTokenDao extends SuperMapper {
	public List<AuthTokenInfo> getAuthTokenInfo(Map<String, Object> params);
	public AuthTokenInfo getAuthTokenByPhone(Map<String, Object> params);
	public void insertAuthTokenInfo(AuthTokenInfo authToken);
	
}
