package com.atguigu.jxc.dao;

import com.atguigu.jxc.entity.GoodsType;

import java.util.List;

public interface GoodsTypeDao {

    List<GoodsType>  selectGoodsTypeByPId(Integer pId);

}
