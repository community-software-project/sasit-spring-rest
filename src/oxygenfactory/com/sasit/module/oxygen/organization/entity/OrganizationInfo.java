package oxygenfactory.com.sasit.module.oxygen.organization.entity;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class OrganizationInfo {
	@SerializedName("AREA") private AreaInfo area;
	@SerializedName("SHOP_LIST") private List<ShopInfo> ShopList;
	
	public AreaInfo getArea() {
		return area;
	}
	public void setArea(AreaInfo area) {
		this.area = area;
	}
	public List<ShopInfo> getShopList() {
		return ShopList;
	}
	public void setShopList(List<ShopInfo> shopList) {
		ShopList = shopList;
	}
	
}
