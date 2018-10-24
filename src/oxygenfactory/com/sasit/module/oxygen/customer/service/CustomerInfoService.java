package oxygenfactory.com.sasit.module.oxygen.customer.service;

import java.util.List;
import java.util.Map;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

import oxygenfactory.com.sasit.base.service.SuperService;
import oxygenfactory.com.sasit.module.oxygen.customer.dao.CustomerDao;
import oxygenfactory.com.sasit.module.oxygen.customer.entity.CustomerInfo;

public interface CustomerInfoService extends SuperService<CustomerDao> {
	public CustomerInfo findByPhoneNumber(Map<String,Object> params);
	public CustomerInfo findByName(String name);
	public void addCustomer(CustomerInfo customer);
	public void updateCustomer(CustomerInfo customer);
	public List<CustomerInfo> findAllCustomers(Map<String,Object> params,PageBounds pageBounds); 
	public int isCustomerExist(String phoneNumber);
	public int checkLoginFrequency(String phoneNumber);
	public void initializePassword(Map<String,Object> params);
	public String getOldPassword(Map<String,Object> params);
	public void updateCustomerShopInfo(CustomerInfo customer);
	public void modifyCustomerName(CustomerInfo customer);
	public List<Map<String,Object>> isProviderContacts(Map<String,Object> params);
	public List<Map<String,Object>> isStoresEmployee(Map<String,Object> params);
	public List<CustomerInfo> getCustomersByPhoneTail(Map<String,Object> params);
	public Map<String,Object> checkShopCode(Map<String,Object> params);
	
}
