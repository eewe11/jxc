package com.atguigu.jxc.service.impl;

import com.atguigu.jxc.dao.GoodsTypeDao;
import com.atguigu.jxc.entity.GoodsType;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.*;

@Slf4j
@SpringBootTest
class GoodsTypeServiceImplTest {

    @Resource
    private GoodsTypeDao goodsTypeDao;

    @Test
    void getGoodsTypeList() {
        List<GoodsType> goodsTypeList = goodsTypeDao.selectGoodsTypeByPId(-1);
        GoodsType goodsType = goodsTypeList.get(0);

        Map<String, Object> map = new LinkedHashMap<>();
        Map<String, Object> stateMap = new HashMap<>();

        map.put("id", goodsType.getGoodsTypeId());
        map.put("text", goodsType.getGoodsTypeName());
        if (goodsType.getGoodsTypeState() == 0) {  // state=0 说明此类别没有子菜单(children)
            map.put("state", "open");  // state=0 状态就是open,因为没有子菜单可以展示了
            map.put("iconCls", "goods-type");
            stateMap.put("state", goodsType.getGoodsTypeState());
            map.put("attributes", stateMap);
        } else {
            map.put("state", "closed");
            map.put("iconCls", "goods-type");
            stateMap.put("state", goodsType.getGoodsTypeState());
            map.put("attributes", stateMap);
            map.put("children", typeListOne(goodsType.getGoodsTypeId()));
        }
        log.info("最终的三层菜单结果是: {}", "[" + new Gson().toJson(map) + "]");
    }

    private List<Map<String, Object>> typeListOne(Integer parentId) {
        List<GoodsType> goodsTypeList = goodsTypeDao.selectGoodsTypeByPId(parentId);
        List<Map<String, Object>> mapList = new ArrayList<>();
        for (GoodsType goodsType : goodsTypeList) {
            Map<String, Object> map = new LinkedHashMap<>();
            Map<String, Object> stateMap = new HashMap<>();

            map.put("id", goodsType.getGoodsTypeId());
            map.put("text", goodsType.getGoodsTypeName());
            if (goodsType.getGoodsTypeState() == 0) {  // state=0 说明此类别没有子菜单(children)
                map.put("state", "open");  // state=0 状态就是open,因为没有子菜单可以展示了
                map.put("iconCls", "goods-type");
                stateMap.put("state", goodsType.getGoodsTypeState());
                map.put("attributes", stateMap);
            } else {
                map.put("state", "closed");
                map.put("iconCls", "goods-type");
                stateMap.put("state", goodsType.getGoodsTypeState());
                map.put("attributes", stateMap);
                map.put("children", typeListTwo(goodsType.getGoodsTypeId()));
            }
            mapList.add(map);
        }
        return mapList;
    }

    private List<Map<String, Object>> typeListTwo(Integer parentId) {
        List<GoodsType> goodsTypeList = goodsTypeDao.selectGoodsTypeByPId(parentId);
        List<Map<String, Object>> mapList = new ArrayList<>();
        for (GoodsType goodsType : goodsTypeList) {
            Map<String, Object> map = new LinkedHashMap<>();
            Map<String, Object> stateMap = new HashMap<>();

            map.put("id", goodsType.getGoodsTypeId());
            map.put("text", goodsType.getGoodsTypeName());
            if (goodsType.getGoodsTypeState() == 0) {  // state=0 说明此类别没有子菜单(children)
                map.put("state", "open");  // state=0 状态就是open,因为没有子菜单可以展示了
                map.put("iconCls", "goods-type");
                stateMap.put("state", goodsType.getGoodsTypeState());
                map.put("attributes", stateMap);
            } else {
                map.put("state", "closed");
                map.put("iconCls", "goods-type");
                stateMap.put("state", goodsType.getGoodsTypeState());
                map.put("attributes", stateMap);
                map.put("children", typeListTwo(goodsType.getGoodsTypeId()));
            }
            mapList.add(map);
        }
        return mapList;
    }
}