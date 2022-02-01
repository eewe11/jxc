package com.atguigu.jxc.service;

import com.atguigu.jxc.dao.UnitDao;
import com.atguigu.jxc.entity.Unit;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

// 商品单位管理
@Service
public class UnitServiceImpl implements UnitService {

    @Resource
    private UnitDao unitDao;

    // 获取商品单位信息列表
    @Override
    public List<Unit> findUnitList() {
        List<Unit> unitList = unitDao.selectUnitList();
        return unitList;
    }
}
