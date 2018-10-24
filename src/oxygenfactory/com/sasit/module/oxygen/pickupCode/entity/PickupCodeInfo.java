package oxygenfactory.com.sasit.module.oxygen.pickupCode.entity;

import com.google.gson.annotations.SerializedName;

public class PickupCodeInfo {
	@SerializedName("ID") private Integer id;//主键
	@SerializedName("LOGISTICS") private String logistics;//物流单号
	@SerializedName("RECIPIENT_NAME") private String recipientName;//收件人姓名
	@SerializedName("PHONE_NUMBER") private String phoneNumber;//手机号码
	@SerializedName("LANDLINE_NUMBER") private String landlineNumber;//座机号码
	@SerializedName("EXPRESS_SERVICE_ID") private Integer expressServiceId;//快件服务商
	@SerializedName("EXPRESS_SERVICE_NAME") private String expressServiceName;//快件服务商名称
	@SerializedName("ADDRESS") private String address;//收货地址
	@SerializedName("REMARK") private String remark;//备注
	@SerializedName("BATCH_NUMBER") private String batchNumber;//批次号
	@SerializedName("OPERA_TIME") private String operaTime;//操作时间
	@SerializedName("AREA_CODE") private String areaCode;//区域
	@SerializedName("SERVICE_SHOP_CODE") private String serviceShopCode;//网点编号
	@SerializedName("SERVICE_SHOP_NAME") private String serviceShopName;//网点名称
	@SerializedName("OPERATOR") private String operator;//操作人
	@SerializedName("EXPRESS_lOCATION") private String expressLocation;//货位
	
}
