package oxygenfactory.com.sasit.module.oxygen.organization.entity;

import com.google.gson.annotations.SerializedName;

public class AreaInfo {
	@SerializedName("ID") private Integer id;//
	@SerializedName("NAME") private String name;//
	@SerializedName("CODE") private String code;//
	@SerializedName("TYPE") private String type;//是否启用
	@SerializedName("REMARK") private String remark;//
	
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
	
}
