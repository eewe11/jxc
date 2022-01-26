package com.atguigu.jxc.service;

import com.atguigu.jxc.entity.Customer;

import java.util.List;

/**
 * 客户管理
 */
public interface CustomerService {

    // 客户列表分页查询(名称模糊查询)
    List<Customer> findCustomerList(Integer page, Integer rows, String customerName);

    // 客户添加或修改
    Integer saveCustomer(Customer customer);

    // 删除客户
    Integer removeCustomer(String ids);
}
