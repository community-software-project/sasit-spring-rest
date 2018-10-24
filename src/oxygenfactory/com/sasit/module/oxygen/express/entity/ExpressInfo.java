package oxygenfactory.com.sasit.module.oxygen.express.entity;

import com.google.gson.annotations.SerializedName;

public class ExpressInfo {
	@SerializedName("ID") private Integer id;//主键
	@SerializedName("LOGISTICS") private String logistics;//物流单号
	@SerializedName("CODE") private String code;//快件标识
	@SerializedName("RECIPIENT_NAME") private String recipientName;//收件人姓名
	@SerializedName("PHONE_NUMBER") private String phoneNumber;//手机号码
	@SerializedName("LANDLINE_NUMBER") private String landlineNumber;//座机号码
	@SerializedName("EXPRESS_SERVICE_ID") private Integer expressServiceId;//快件服务商
	@SerializedName("EXPRESS_SERVICE_NAME") private String expressServiceName;//快件服务商名称
	@SerializedName("ADDRESS") private String address;//收货地址
	@SerializedName("REMARK") private String remark;//备注
	@SerializedName("BATCH_NUMBER") private String batchNumber;//批次号
	@SerializedName("OUT_BATCH_NUMBER") private String outBatchNumber;//出库批次号
	@SerializedName("OPERA_TIME") private String operaTime;//操作时间
	@SerializedName("OUT_OPERA_TIME") private String outOperaTime;//出库操作时间
	@SerializedName("AREA_CODE") private String areaCode;//区域
	@SerializedName("SERVICE_SHOP_CODE") private String serviceShopCode;//网点编号
	@SerializedName("SERVICE_SHOP_NAME") private String serviceShopName;//网点名称
	@SerializedName("OPERATOR") private String operator;//操作人
	@SerializedName("EXPRESS_lOCATION") private String expressLocation;//货位
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
	public Integer getExpressServiceId() {
		return expressServiceId;
	}
	public void setExpressServiceId(Integer expressServiceId) {
		this.expressServiceId = expressServiceId;
	}
	public String getExpressServiceName() {
		return expressServiceName;
	}
	public void setExpressServiceName(String expressServiceName) {
		this.expressServiceName = expressServiceName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getBatchNumber() {
		return batchNumber;
	}
	public void setBatchNumber(String batchNumber) {
		this.batchNumber = batchNumber;
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
	public String getServiceShopName() {
		return serviceShopName;
	}
	public void setServiceShopName(String serviceShopName) {
		this.serviceShopName = serviceShopName;
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
	public String getOutOperaTime() {
		return outOperaTime;
	}
	public void setOutOperaTime(String outOperaTime) {
		this.outOperaTime = outOperaTime;
	}
	public String getOutBatchNumber() {
		return outBatchNumber;
	}
	public void setOutBatchNumber(String outBatchNumber) {
		this.outBatchNumber = outBatchNumber;
	}

}
