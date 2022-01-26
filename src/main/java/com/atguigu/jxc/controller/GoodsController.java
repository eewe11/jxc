package com.atguigu.jxc.controller;

import com.atguigu.jxc.service.GoodsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
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
}
