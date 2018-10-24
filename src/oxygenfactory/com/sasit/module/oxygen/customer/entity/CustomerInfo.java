package oxygenfactory.com.sasit.module.oxygen.customer.entity;

import com.google.gson.annotations.SerializedName;

public class CustomerInfo {
	@SerializedName("ID") private Integer id;//ID
	@SerializedName("NAME") private String name;//姓名
	@SerializedName("PHONE_NUMBER") private String phoneNumber;//手机号码
	@SerializedName("lANDLINE_NUMBER") private String landlineNumber;//座机
	@SerializedName("WEIXIN_ID") private String weixinId;//微信号
	@SerializedName("IDENTITY_CARD") private String identityCard;//身份证号码
	@SerializedName("GENDER") private String gender;//性别
	@SerializedName("ADDRESS") private String address;//地址
	@SerializedName("AREA_CODE") private String areaCode;//区域编号
	@SerializedName("AREA_NAME") private String areaName;//区域编号
	@SerializedName("EMAIL") private String email;//E-MAIL
	@SerializedName("QQ") private Integer qq;//QQ
	@SerializedName("INITIALS_CODE") private String initialsCode;//首字母
	@SerializedName("SPELLING_CODE") private String spellingCode;//全拼
	@SerializedName("SERVICE_SHOP_CODE") private String serviceShopCode;//网点编号
	@SerializedName("SERVICE_SHOP_NAME") private String serviceShopName;//网点名称
	@SerializedName("AGE") private Integer age;//年龄
	@SerializedName("AGE_SECTION") private String ageSection;//年龄段
	@SerializedName("WHETHER_HAVE_CAR") private String whetherHaveCar;//是否有车
	@SerializedName("IS_INTEREST") private String isInterest;//是否会员
	@SerializedName("PASSWORD") private String password;
	@SerializedName("LOGIN_NAME") private String loginName;
	@SerializedName("VERSION") private Integer version;
	@SerializedName("LOGIN_FREQUENCY") private Integer loginFrequency;
	@SerializedName("CREATE_DATE") private String createDate;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getLandlineNumber() {
		return landlineNumber;
	}
	public void setLandlineNumber(String landlineNumber) {
		this.landlineNumber = landlineNumber;
	}
	public String getWeixinId() {
		return weixinId;
	}
	public void setWeixinId(String weixinId) {
		this.weixinId = weixinId;
	}
	public String getIdentityCard() {
		return identityCard;
	}
	public void setIdentityCard(String identityCard) {
		this.identityCard = identityCard;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAreaCode() {
		return areaCode;
	}
	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getQq() {
		return qq;
	}
	public void setQq(Integer qq) {
		this.qq = qq;
	}
	public String getInitialsCode() {
		return initialsCode;
	}
	public void setInitialsCode(String initialsCode) {
		this.initialsCode = initialsCode;
	}
	public String getSpellingCode() {
		return spellingCode;
	}
	public void setSpellingCode(String spellingCode) {
		this.spellingCode = spellingCode;
	}
	public String getServiceShopCode() {
		return serviceShopCode;
	}
	public void setServiceShopCode(String serviceShopCode) {
		this.serviceShopCode = serviceShopCode;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getAgeSection() {
		return ageSection;
	}
	public void setAgeSection(String ageSection) {
		this.ageSection = ageSection;
	}
	public String getWhetherHaveCar() {
		return whetherHaveCar;
	}
	public void setWhetherHaveCar(String whetherHaveCar) {
		this.whetherHaveCar = whetherHaveCar;
	}
	public String getIsInterest() {
		return isInterest;
	}
	public void setIsInterest(String isInterest) {
		this.isInterest = isInterest;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public Integer getVersion() {
		return version;
	}
	public void setVersion(Integer version) {
		this.version = version;
	}
	public String getAreaName() {
		return areaName;
	}
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	public String getServiceShopName() {
		return serviceShopName;
	}
	public void setServiceShopName(String serviceShopName) {
		this.serviceShopName = serviceShopName;
	}
	public Integer getLoginFrequency() {
		return loginFrequency;
	}
	public void setLoginFrequency(Integer loginFrequency) {
		this.loginFrequency = loginFrequency;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	
}
