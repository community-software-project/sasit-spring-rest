package oxygenfactory.com.sasit.module.oxygen.xAuthToken.service;

import java.util.List;
import java.util.Map;

import oxygenfactory.com.sasit.base.service.SuperService;
import oxygenfactory.com.sasit.module.oxygen.xAuthToken.dao.AuthTokenDao;
import oxygenfactory.com.sasit.module.oxygen.xAuthToken.entity.AuthTokenInfo;

public interface AuthTokenService extends SuperService<AuthTokenDao> {
	public List<AuthTokenInfo> getAuthTokenInfo(Map<String, Object> params);
	public AuthTokenInfo getAuthTokenByPhone(Map<String, Object> params);
	public void insertAuthTokenInfo(AuthTokenInfo authToken);
}
