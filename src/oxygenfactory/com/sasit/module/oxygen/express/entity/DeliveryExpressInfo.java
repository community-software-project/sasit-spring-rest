package oxygenfactory.com.sasit.module.oxygen.express.entity;

import com.google.gson.annotations.SerializedName;

public class DeliveryExpressInfo {
	@SerializedName("ID_LIST") private String[] idList;
	@SerializedName("MSG") private String msg;

	public String[] getIdList() {
		return idList;
	}

	public void setIdList(String[] idList) {
		this.idList = idList;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
}
