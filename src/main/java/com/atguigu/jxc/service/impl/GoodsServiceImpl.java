package com.atguigu.jxc.service.impl;

import com.atguigu.jxc.dao.GoodsDao;
import com.atguigu.jxc.entity.Goods;
import com.atguigu.jxc.service.GoodsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 商品管理
@Service
public class GoodsServiceImpl implements GoodsService {

    @Resource
    private GoodsDao goodsDao;

    // 默认首页商品信息列表
    @Override
    public Map<String, Object> findListInventory(Integer page, Integer rows, String codeOrName, Integer goodsTypeId) {
        List<Goods> goods = goodsDao.selectListInventory(page - 1, rows, codeOrName, goodsTypeId);
        Map<String, Object> map = new HashMap<>();
        map.put("total", goods.size());
        map.put("rows", goods);
        return map;
    }

    // 商品管理信息分页展示
    @Override
    public List<Goods> showGoodsList(Integer page, Integer rows, String goodsName, Integer goodsTypeId) {
        return goodsDao.selectListByGoodsNameOrGoodsType(page - 1, rows, goodsName, goodsTypeId);
    }

}
