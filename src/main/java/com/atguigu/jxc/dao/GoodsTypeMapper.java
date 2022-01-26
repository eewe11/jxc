package com.atguigu.jxc.dao;

import com.atguigu.jxc.entity.GoodsType;

import java.util.List;

public interface GoodsTypeMapper {

    // 返回根目录
    List<GoodsType> selectGoodsTypeTree();

    // 根据父级菜单获取子菜单(二级.三级...)
    List<GoodsType> selectChildrenTree(Integer pId);
}
