package com.atguigu.jxc.dao;

import com.atguigu.jxc.entity.Supplier;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 供应商管理
 */
public interface SupplierDao {

    // 分页查询供应商
    List<Supplier> selectSupplierList(@Param("page") Integer page,
                                      @Param("rows") Integer rows,
                                      @Param("supplierName") String supplierName);

    // 根据 supplier_id 查询供应商信息
    Supplier selectSupplierById(Integer supplierId);

    // 新增供应商
    Integer insertSupplier(Supplier supplier);

    // 修改供应商信息
    Integer updateSupplier(Supplier supplier);

    // 删除供应商
    Integer deleteSupplier(@Param("ids") List<Integer> ids);
}
