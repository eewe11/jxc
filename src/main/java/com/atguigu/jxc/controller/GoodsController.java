package com.atguigu.jxc.controller;

import com.atguigu.jxc.entity.Goods;
import com.atguigu.jxc.service.GoodsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/goods")
public class GoodsController {

    @Resource
    private GoodsService goodsService;

    // 首页默认: 当前库存查询
    @PostMapping("/listInventory")
    public Map<String, Object> listInventory(Integer page,
                                             Integer rows,
                                             String codeOrName,
                                             Integer goodsTypeId) {
        return goodsService.findListInventory(page, rows, codeOrName, goodsTypeId);
    }

    // 查询所有商品信息（可以根据分类、名称查询）
    @PostMapping("list")
    public Map<String, Object> list(Integer page, Integer rows, String goodsName, Integer goodsTypeId){
        Map<String, Object> map = new HashMap<>();
        List<Goods> goodsList = goodsService.showGoodsList(page, rows, goodsName, goodsTypeId);
        map.put("total", goodsList.size());
        map.put("rows", goodsList);
        return map;
    }
}
