package com.atguigu.jxc.dao;

import com.atguigu.jxc.entity.GoodsType;

import java.util.List;

public interface GoodsTypeMapper {

    // 获取所有菜单
    List<GoodsType> selectGoodsTypeTree();

    // 获取子菜单(二级.三级...)
    List<GoodsType> selectChildrenTree(Integer pId);
}
