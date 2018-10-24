package oxygenfactory.com.sasit.module.oxygen.expressProviders.entity;

import com.google.gson.annotations.SerializedName;

public class ExpressProviderContacts {
	@SerializedName("ID") private Integer id;//
	@SerializedName("NAME") private String name;//联系人姓名
	@SerializedName("PHONE_NUMBER") private String phoneNumber;//
	@SerializedName("AREA_CODE") private String areaCode;//
	@SerializedName("SERVICE_SHOP_CODE") private String serviceShopCode;//
	@SerializedName("TYPE") private String type;//
	@SerializedName("REMARK") private String remark;//备注
	@SerializedName("PROVIDER_ID") private Integer providerId;//
	
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Integer getProviderId() {
		return providerId;
	}
	public void setProviderId(Integer providerId) {
		this.providerId = providerId;
	}
	
	
}
