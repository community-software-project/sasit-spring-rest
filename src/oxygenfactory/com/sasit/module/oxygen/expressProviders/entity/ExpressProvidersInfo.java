package oxygenfactory.com.sasit.module.oxygen.expressProviders.entity;

import com.google.gson.annotations.SerializedName;

public class ExpressProvidersInfo {
	@SerializedName("ID") private Integer id;//
	@SerializedName("NAME") private String name;//名称
	@SerializedName("CODE") private String code;//编码
	@SerializedName("REMARK") private String remark;//备注
	@SerializedName("LOGO") private String logo;//
	@SerializedName("TYPE") private String type;//
	@SerializedName("ORDER_BY") private Integer orderBy;//
	@SerializedName("CONTACTS") private String contacts;//
	@SerializedName("PHONE_NUMBER") private String phoneNumber;//
	@SerializedName("AREA_CODE") private String areaCode;//
	@SerializedName("SERVICE_SHOP_CODE") private String serviceShopCode;//
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
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Integer getOrderBy() {
		return orderBy;
	}
	public void setOrderBy(Integer orderBy) {
		this.orderBy = orderBy;
	}
	public String getContacts() {
		return contacts;
	}
	public void setContacts(String contacts) {
		this.contacts = contacts;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getAreaCode() {
		return areaCode;
	}
	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}
	public String getServiceShopCode() {
		return serviceShopCode;
	}
	public void setServiceShopCode(String serviceShopCode) {
		this.serviceShopCode = serviceShopCode;
	}
	
	
}
