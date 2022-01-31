package com.atguigu.jxc.controller;

import com.atguigu.jxc.domain.ServiceVO;
import com.atguigu.jxc.domain.SuccessCode;
import com.atguigu.jxc.entity.Customer;
import com.atguigu.jxc.service.CustomerService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 客户管理
@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Resource
    private CustomerService customerService;

    // 客户分页查询
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
    public ServiceVO save(Customer customer, HttpServletRequest request) {
        String customerId = request.getParameter("customerId");
        customerService.saveCustomer(customerId, customer);
        return new ServiceVO(SuccessCode.SUCCESS_CODE, SuccessCode.SUCCESS_MESS);
    }

    @PostMapping("/delete")
    public ServiceVO delete(String ids) {
        customerService.removeCustomer(ids);
        return new ServiceVO(SuccessCode.SUCCESS_CODE, SuccessCode.SUCCESS_MESS);
    }
}
