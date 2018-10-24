package oxygenfactory.com.sasit.module.oxygen.organization.entity;

import com.google.gson.annotations.SerializedName;

public class ShopInfo {
	@SerializedName("ID") private Integer id;//
	@SerializedName("SHOP_CODE") private String shopCode;//
	@SerializedName("NAME") private String name;//
	@SerializedName("TYPE") private String type;//是否启用
	@SerializedName("AREA_CODE") private String areaCode;//
	@SerializedName("SHOP_ADDRESS") private String shopAddress;//
	@SerializedName("SHOP_CONTACTS") private String shopContacts;//
	@SerializedName("REMARK") private String remark;//
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getShopCode() {
		return shopCode;
	}
	public void setShopCode(String shopCode) {
		this.shopCode = shopCode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getAreaCode() {
		return areaCode;
	}
	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}
	public String getShopAddress() {
		return shopAddress;
	}
	public void setShopAddress(String shopAddress) {
		this.shopAddress = shopAddress;
	}
	public String getShopContacts() {
		return shopContacts;
	}
	public void setShopContacts(String shopContacts) {
		this.shopContacts = shopContacts;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}
