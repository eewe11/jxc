package com.atguigu.jxc.service.impl;

import com.atguigu.jxc.dao.GoodsTypeMapper;
import com.atguigu.jxc.entity.GoodsType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runner.Runner;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@RunWith(Runner.class)
@SpringBootTest
public class GoodsTypeServiceImplTest {
    @Resource
    private GoodsTypeMapper mapper;

    @Test
    public void getGoodsTypeList() {
        List<GoodsType> goodsTypeList = mapper.selectGoodsTypeTree();
        System.out.println(goodsTypeList);
    }

    @Test
    public void testGetGoodsTypeList() {
    }
}