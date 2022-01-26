package com.atguigu.jxc.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 商品管理控制器
 */
@RestController
@RequestMapping("/goodsType")
public class GoodsTypeController {

    @PostMapping("/loadGoodsType")
    public String showGoodsType() {
        return "";
    }
}
