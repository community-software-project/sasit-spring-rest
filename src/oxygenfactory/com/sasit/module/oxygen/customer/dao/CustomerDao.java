package oxygenfactory.com.sasit.module.oxygen.customer.dao;

import java.util.List;
import java.util.Map;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import oxygenfactory.com.sasit.base.annotation.MapperAnnotation;
import oxygenfactory.com.sasit.base.mapper.SuperMapper;
import oxygenfactory.com.sasit.module.oxygen.customer.entity.CustomerInfo;

@MapperAnnotation
public interface CustomerDao extends SuperMapper{
	public List<CustomerInfo> findAllCustomers(Map<String,Object> params,PageBounds pageBounds);
	public CustomerInfo findByPhoneNumber(Map<String,Object> params);
	public int isCustomerExist(String phoneNumber);
	public int checkLoginFrequency(String phoneNumber);
	public void addCustomer(CustomerInfo customer);
	public void initializePassword(Map<String,Object> params);
	public String getOldPassword(Map<String,Object> params);
	public void updateCustomerShopInfo(CustomerInfo customer);
	public void modifyCustomerName(CustomerInfo customer);
	public List<Map<String,Object>> isProviderContacts(Map<String,Object> params);
	public List<Map<String,Object>> isStoresEmployee(Map<String,Object> params);
	public List<CustomerInfo> getCustomersByPhoneTail(Map<String,Object> params);
	public Map<String,Object> checkShopCode(Map<String,Object> params);
}
