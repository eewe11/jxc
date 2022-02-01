package com.atguigu.jxc.dao;

import com.atguigu.jxc.entity.Unit;

import java.util.List;

// 商品单位管理
public interface UnitDao {

    // 查询所有商品单位
    List<Unit> selectUnitList();
}
