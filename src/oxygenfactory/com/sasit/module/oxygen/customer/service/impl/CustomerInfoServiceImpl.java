package oxygenfactory.com.sasit.module.oxygen.customer.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

import oxygenfactory.com.sasit.base.adapter.SuperServiceAdapter;
import oxygenfactory.com.sasit.module.oxygen.customer.dao.CustomerDao;
import oxygenfactory.com.sasit.module.oxygen.customer.entity.CustomerInfo;
import oxygenfactory.com.sasit.module.oxygen.customer.service.CustomerInfoService;

@Service("customerService")
@Transactional
public class CustomerInfoServiceImpl extends SuperServiceAdapter<CustomerDao> implements CustomerInfoService{
	
	@Autowired
	@Override
	public void setMapper(CustomerDao mapper) {
		this.mapper = mapper;
	}

	@Override
	public CustomerInfo findByPhoneNumber(Map<String,Object> params) {
		return mapper.findByPhoneNumber(params);
	}

	@Override
	public CustomerInfo findByName(String name) {
		return null;
	}

	@Override
	public void addCustomer(CustomerInfo customer) {
		mapper.addCustomer(customer);
	}

	@Override
	public void updateCustomer(CustomerInfo customer) {
		// TODO Auto-generated method stub
	}

	@Override
	public List<CustomerInfo> findAllCustomers(Map<String,Object> params,PageBounds pageBounds) {
		return mapper.findAllCustomers(params, pageBounds);
	}

	@Override
	public int isCustomerExist(String phoneNumber) {
		return mapper.isCustomerExist(phoneNumber);
	}

	@Override
	public int checkLoginFrequency(String phoneNumber) {
		return mapper.checkLoginFrequency(phoneNumber);
	}

	@Override
	public void initializePassword(Map<String, Object> params) {
		mapper.initializePassword(params);
	}

	@Override
	public String getOldPassword(Map<String, Object> params) {
		return mapper.getOldPassword(params);
	}

	@Override
	public void updateCustomerShopInfo(CustomerInfo customer) {
		mapper.updateCustomerShopInfo(customer);
	}

	@Override
	public List<Map<String,Object>> isProviderContacts(Map<String, Object> params) {
		return mapper.isProviderContacts(params);
	}

	@Override
	public List<Map<String, Object>> isStoresEmployee(Map<String, Object> params) {
		return mapper.isStoresEmployee(params);
	}

	@Override
	public List<CustomerInfo> getCustomersByPhoneTail(Map<String, Object> params) {
		return mapper.getCustomersByPhoneTail(params);
	}

	@Override
	public void modifyCustomerName(CustomerInfo customer) {
		mapper.modifyCustomerName(customer);
	}

	@Override
	public Map<String, Object> checkShopCode(Map<String, Object> params) {
		return mapper.checkShopCode(params);
	}

}
