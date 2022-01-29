package com.atguigu.jxc.controller;

import com.atguigu.jxc.service.GoodsTypeService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

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
        return goodsTypeService.getGoodsTypeList();
    }
}
