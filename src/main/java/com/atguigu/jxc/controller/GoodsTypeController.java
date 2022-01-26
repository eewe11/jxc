package com.atguigu.jxc.controller;

import com.atguigu.jxc.entity.GoodsType;
import com.atguigu.jxc.service.GoodsTypeService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 商品管理控制器
 */
@RestController
@RequestMapping("/goodsType")
public class GoodsTypeController {

    @Resource
    private GoodsTypeService goodsTypeService;

    @PostMapping("/loadGoodsType")
    public String showGoodsType() {
        List<GoodsType> goodsTypeList = goodsTypeService.getGoodsTypeList();
        System.out.println(goodsTypeList);
        return String.valueOf(goodsTypeList);
    }
}
