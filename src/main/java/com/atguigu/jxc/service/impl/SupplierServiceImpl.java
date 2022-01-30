package com.atguigu.jxc.service.impl;

import com.atguigu.jxc.dao.SupplierDao;
import com.atguigu.jxc.entity.Supplier;
import com.atguigu.jxc.service.SupplierService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 供应商管理
 */
@Service
public class SupplierServiceImpl implements SupplierService {

    @Resource
    private SupplierDao supplierDao;

    // 供应商列表分页展示
    @Override
    public Map<String, Object> findSupplierList(Integer page, Integer rows, String supplierName) {
        List<Supplier> suppliers = supplierDao.selectSupplierList(page - 1, rows, supplierName);
        Map<String, Object> map = new HashMap<>();
        map.put("total", suppliers.size());
        map.put("rows", suppliers);
        return map;
    }

    // 供应商添加或修改
    @Override
    public void saveSupplier(String supplierId, Supplier supplier) {
        // 已存在的供应商
        Supplier oldSupplier = supplierDao.selectSupplierById(supplierId);
        if (oldSupplier != null) {
            supplierDao.updateSupplier(supplier);
        } else {
            supplierDao.insertSupplier(supplier);
        }
    }

    // 删除供应商(支持批量)
    @Override
    public Integer removeSupplier(String ids) {
        List<Integer> arrayList = new ArrayList<>();
        if (!StringUtils.isEmpty(ids)) {
            String[] idList = ids.split(",");
            for (String s : idList) {
                int i = Integer.parseInt(s);
                arrayList.add(i);
            }
            return supplierDao.deleteSupplier(arrayList);
        }
        return null;
    }
}
