package com.atguigu.jxc.controller;

import com.atguigu.jxc.domain.ServiceVO;
import com.atguigu.jxc.entity.Customer;
import com.atguigu.jxc.service.CustomerService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Resource
    private CustomerService customerService;

    @PostMapping("/list")
    public Map<String, Object> list(Integer page,
                                    Integer rows,
                                    String customerName) {
        List<Customer> customerList = customerService.findCustomerList(page, rows, customerName);
        Map<String, Object> map = new HashMap<>();
        map.put("total", customerList.size());
        map.put("rows", customerList);
        return map;
    }

    @PostMapping("/save")
    public ServiceVO save(Customer customer) {
        Integer integer = customerService.saveCustomer(customer);
        if (integer > 0) {
            return new ServiceVO(100, "请求成功", null);
        }
        return new ServiceVO(101, "请求失败, 请联系管理员", null);
    }

    @PostMapping("/delete")
    public ServiceVO delete(String ids) {
        Integer integer = customerService.removeCustomer(ids);
        if (integer > 0) {
            return new ServiceVO(100, "请求成功", null);
        }
        return new ServiceVO(101, "请求失败, 请联系管理员", null);
    }
}
