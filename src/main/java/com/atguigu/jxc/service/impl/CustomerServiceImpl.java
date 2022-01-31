package com.atguigu.jxc.service.impl;

import com.atguigu.jxc.dao.CustomerDao;
import com.atguigu.jxc.entity.Customer;
import com.atguigu.jxc.service.CustomerService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 客户管理
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    @Resource
    private CustomerDao customerDao;

    // 客户分页查询(支持模糊搜索)
    @Override
    public List<Customer> findCustomerList(Integer page, Integer rows, String customerName) {
        return customerDao.selectCustomerList(page - 1, rows, customerName);
    }

    // 客户添加或者修改
    @Override
    public void saveCustomer(String customId, Customer customer) {
        Customer oldCustomer = customerDao.selectCustomerById(customId);
        if (oldCustomer!=null) {
            customerDao.updateCustomer(customer);
        }else {
            customerDao.insertCustomer(customer);
        }
    }

    // 删除客户
    @Override
    public void removeCustomer(String ids) {
        List<Integer> numList = new ArrayList<>();
        if (!StringUtils.isEmpty(ids)) {
            String[] numStr = ids.split(",");
            for (String num : numStr) {
                int i = Integer.parseInt(num);
                numList.add(i);
            }
            customerDao.deleteCustomer(numList);
        } else {
            throw new RuntimeException();
        }
    }
}
