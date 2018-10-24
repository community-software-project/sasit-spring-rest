package oxygenfactory.com.sasit.module.oxygen.xAuthToken.entity;

import com.google.gson.annotations.SerializedName;

public class AuthTokenInfo {
	@SerializedName("ID") private Integer id;
	@SerializedName("PHONE_NUMBER") private String phoneNumber;
	@SerializedName("LOGIN_NAME") private String loginName;
	@SerializedName("X_AUTH_TOKEN") private String xAuthToken;
	@SerializedName("TOKEN_TYPE") private String tokenType;
	@SerializedName("LIMIT_TIME") private Integer limitTime;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getxAuthToken() {
		return xAuthToken;
	}
	public void setxAuthToken(String xAuthToken) {
		this.xAuthToken = xAuthToken;
	}
	public String getTokenType() {
		return tokenType;
	}
	public void setTokenType(String tokenType) {
		this.tokenType = tokenType;
	}
	public Integer getLimitTime() {
		return limitTime;
	}
	public void setLimitTime(Integer limitTime) {
		this.limitTime = limitTime;
	}
	
}
