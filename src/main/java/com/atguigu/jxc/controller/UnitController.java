package com.atguigu.jxc.controller;


import com.atguigu.jxc.entity.Unit;
import com.atguigu.jxc.service.UnitService;
import com.google.gson.Gson;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 商品单位管理
@RestController
@RequestMapping("/unit")
public class UnitController {

    @Resource
    private UnitService unitService;

    // 查询所有商品单位
    @PostMapping("/list")
    public Map<String, Object> getGoodsUnit() {
        Map<String, Object> map = new HashMap<>();
        List<Unit> unitList = unitService.findUnitList();
        String unitListJson = new Gson().toJson(unitList);
        map.put("rows", unitListJson);
        return map;
    }
}
