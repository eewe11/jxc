package com.atguigu.jxc.service.impl;

import com.atguigu.jxc.dao.GoodsTypeMapper;
import com.atguigu.jxc.entity.GoodsType;
import com.atguigu.jxc.service.GoodsTypeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class GoodsTypeServiceImpl implements GoodsTypeService {

    @Resource
    private GoodsTypeMapper goodsTypeMapper;

    @Override
    public List<GoodsType> getGoodsTypeList() {
        return goodsTypeMapper.selectGoodsTypeTree();
    }
}
