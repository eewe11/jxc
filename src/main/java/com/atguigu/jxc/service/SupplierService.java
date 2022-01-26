package com.atguigu.jxc.service;

import com.atguigu.jxc.entity.Supplier;

import java.util.Map;

/**
 * 供应商管理
 */
public interface SupplierService {

    // 分页查询供应商
    Map<String, Object> findSupplierList(Integer page, Integer rows, String supplierName);

    // 供应商添加或修改
    Integer saveSupplier(Supplier supplier);

    // 删除供应商(支持批量删除)
    Integer removeSupplier(String ids);
}
