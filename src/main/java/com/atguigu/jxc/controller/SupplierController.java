package com.atguigu.jxc.controller;

import com.atguigu.jxc.domain.ServiceVO;
import com.atguigu.jxc.domain.SuccessCode;
import com.atguigu.jxc.entity.Supplier;
import com.atguigu.jxc.service.SupplierService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 供应商控制器
 */
@RestController
@RequestMapping("/supplier")
public class SupplierController {

    @Resource
    private SupplierService supplierService;

    // 分页查询供应商
    @PostMapping("/list")
    public Map<String, Object> supplierList(Integer page,
                                            Integer rows,
                                            String supplierName) {
        return supplierService.findSupplierList(page, rows, supplierName);
    }

    // 供应商添加或修改
    @PostMapping("/save")
    public ServiceVO save(Supplier supplier, HttpServletRequest request) {
        String supplierId = request.getParameter("supplierId");
        supplierService.saveSupplier(supplierId, supplier);
        return new ServiceVO(SuccessCode.SUCCESS_CODE, SuccessCode.SUCCESS_MESS);
    }

    // 删除供应商
    @PostMapping("/delete")
    public ServiceVO deleteSupplier(String ids) {
        supplierService.removeSupplier(ids);
        return new ServiceVO(SuccessCode.SUCCESS_CODE, SuccessCode.SUCCESS_MESS);
    }
}
