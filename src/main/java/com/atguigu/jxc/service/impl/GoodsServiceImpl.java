package com.atguigu.jxc.service.impl;

import com.atguigu.jxc.dao.GoodsDao;
import com.atguigu.jxc.entity.Goods;
import com.atguigu.jxc.service.GoodsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Resource
    private GoodsDao goodsDao;

    @Override
    public Map<String, Object> findListInventory(Integer page, Integer rows, String codeOrName, Integer goodsTypeId) {
        List<Goods> goods = goodsDao.selectListInventory(page - 1, rows, codeOrName, goodsTypeId);
        Map<String, Object> map = new HashMap<>();
        map.put("total", goods.size());
        map.put("rows", goods);
        return map;
    }
}
