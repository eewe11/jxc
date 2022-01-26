package com.atguigu.jxc.dao;

import com.atguigu.jxc.entity.Customer;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 客户管理
 */
public interface CustomerDao {

    // 客户列表分页(名称模糊查询)
    List<Customer> selectCustomerList(@Param("page") Integer page,
                                      @Param("rows") Integer rows,
                                      @Param("customerName") String customerName);

    // 根据 customer_id 查询客户
    Customer selectCustomerById(Integer customer_id);

    // 客户添加
    Integer insertCustomer(Customer customer);

    // 客户修改
    Integer updateCustomer(Customer customer);

    // 客户删除
    Integer deleteCustomer(@Param("ids") List<Integer> ids);
}
