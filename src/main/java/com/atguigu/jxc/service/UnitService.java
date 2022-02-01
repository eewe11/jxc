package com.atguigu.jxc.service;

import com.atguigu.jxc.entity.Unit;

import java.util.List;

// 商品单位管理
public interface UnitService {

    // 查询所有商品单位
   List<Unit > findUnitList();
}
