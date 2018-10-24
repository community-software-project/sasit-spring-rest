package oxygenfactory.com.sasit.module.oxygen.xAuthToken.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import oxygenfactory.com.sasit.base.adapter.SuperServiceAdapter;
import oxygenfactory.com.sasit.module.oxygen.xAuthToken.dao.AuthTokenDao;
import oxygenfactory.com.sasit.module.oxygen.xAuthToken.entity.AuthTokenInfo;
import oxygenfactory.com.sasit.module.oxygen.xAuthToken.service.AuthTokenService;

@Service("authTokenService")
@Transactional
public class AuthTokenServiceImpl extends SuperServiceAdapter<AuthTokenDao> implements AuthTokenService {
	
	@Autowired
	@Override
	public void setMapper(AuthTokenDao mapper) {
		this.mapper = mapper;
	}

	@Override
	public List<AuthTokenInfo> getAuthTokenInfo(Map<String, Object> params) {
		return mapper.getAuthTokenInfo(params);
	}

	@Override
	public void insertAuthTokenInfo(AuthTokenInfo authToken) {
		mapper.insertAuthTokenInfo(authToken);
	}

	@Override
	public AuthTokenInfo getAuthTokenByPhone(Map<String, Object> params) {
		return mapper.getAuthTokenByPhone(params);
	}

}
