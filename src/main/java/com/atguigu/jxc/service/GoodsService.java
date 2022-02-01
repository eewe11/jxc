package com.atguigu.jxc.service;

import com.atguigu.jxc.entity.Goods;

import java.util.List;
import java.util.Map;

// 商品管理
public interface GoodsService {

    // 首页默认：当前库存查询
    // 查询当前库存（可根据商品类别、商品编码或名称搜索）
    Map<String, Object> findListInventory(Integer page, Integer rows, String codeOrName, Integer goodsTypeId);

    // 分页展示所有产品信息
    List<Goods> showGoodsList(Integer page, Integer rows, String goodsName, Integer goodsTypeId);

}
