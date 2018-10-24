package oxygenfactory.com.sasit.module.oxygen.express.entity;

import com.google.gson.annotations.SerializedName;

public class RecordSendExpressInfo {
	@SerializedName("ID") private Integer id;//主键
	@SerializedName("LOGISTICS") private String logistics;//物流单号
	@SerializedName("CODE") private String code;//快件标识
	@SerializedName("RECIPIENT_NAME") private String recipientName;//收件人姓名
	@SerializedName("PHONE_NUMBER") private String phoneNumber;//收件人手机号码
	@SerializedName("LANDLINE_NUMBER") private String landlineNumber;//收件人座机号码
	@SerializedName("SENDER_NAME") private String senderName;//寄件人姓名
	@SerializedName("ID_NUMBER") private String idNumber;// 
	@SerializedName("SENDER_NUMBER") private String senderNumber;//寄件人手机号码
	@SerializedName("SENDER_LANDLINE_NUMBER") private String senderLandlineNumber;//寄件人座机号码
	@SerializedName("EXPRESS_SERVICE_ID") private Integer expressServiceId;//快递服务商ID
	@SerializedName("EXPRESS_SERVICE_NAME") private String expressServiceName;//快递服务商名称
	@SerializedName("ADDRESS") private String address;//发货地址
	@SerializedName("DESTINATION") private String destination;//目的地
	@SerializedName("OPERA_TIME") private String operaTime;//
	@SerializedName("AREA_CODE") private String areaCode;//
	@SerializedName("SERVICE_SHOP_CODE") private String serviceShopCode;//
	@SerializedName("SERVICE_SHOP_NAME") private String serviceShopName;//
	@SerializedName("OPERATOR") private String operator;//
	@SerializedName("EXPRESS_lOCATION") private String expressLocation;//
	@SerializedName("WEIGHT") private String weight;//重量
	@SerializedName("DIMENSIONS") private String dimensions;//体积
	@SerializedName("REMARK") private String remark;//备注
	@SerializedName("RES") private String res;//
	@SerializedName("TYPE") private String type;//
	@SerializedName("PRICE") private Integer price;//分为单位
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLogistics() {
		return logistics;
	}
	public void setLogistics(String logistics) {
		this.logistics = logistics;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getRecipientName() {
		return recipientName;
	}
	public void setRecipientName(String recipientName) {
		this.recipientName = recipientName;
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
	public String getSenderName() {
		return senderName;
	}
	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}
	public String getIdNumber() {
		return idNumber;
	}
	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}
	public String getSenderNumber() {
		return senderNumber;
	}
	public void setSenderNumber(String senderNumber) {
		this.senderNumber = senderNumber;
	}
	public String getSenderLandlineNumber() {
		return senderLandlineNumber;
	}
	public void setSenderLandlineNumber(String senderLandlineNumber) {
		this.senderLandlineNumber = senderLandlineNumber;
	}
	public Integer getExpressServiceId() {
		return expressServiceId;
	}
	public void setExpressServiceId(Integer expressServiceId) {
		this.expressServiceId = expressServiceId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getOperaTime() {
		return operaTime;
	}
	public void setOperaTime(String operaTime) {
		this.operaTime = operaTime;
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
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public String getExpressLocation() {
		return expressLocation;
	}
	public void setExpressLocation(String expressLocation) {
		this.expressLocation = expressLocation;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public String getDimensions() {
		return dimensions;
	}
	public void setDimensions(String dimensions) {
		this.dimensions = dimensions;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getRes() {
		return res;
	}
	public void setRes(String res) {
		this.res = res;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	
	
}
