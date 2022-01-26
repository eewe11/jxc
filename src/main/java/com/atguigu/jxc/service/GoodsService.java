package com.atguigu.jxc.service;

import java.util.Map;

public interface GoodsService {

    // 首页默认：当前库存查询
    // 查询当前库存（可根据商品类别、商品编码或名称搜索）
    Map<String, Object> findListInventory(Integer page, Integer rows, String codeOrName, Integer goodsTypeId);
}
