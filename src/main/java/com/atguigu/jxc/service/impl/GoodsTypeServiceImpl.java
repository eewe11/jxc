package com.atguigu.jxc.service.impl;

import com.atguigu.jxc.dao.GoodsTypeDao;
import com.atguigu.jxc.entity.GoodsType;
import com.atguigu.jxc.service.GoodsTypeService;
import com.google.gson.Gson;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * 商品管理
 */
@Service
public class GoodsTypeServiceImpl implements GoodsTypeService {

    @Resource
    private GoodsTypeDao goodsTypeDao;
    private static final int ROOT_PID = -1;

    // 商品分类树展示(多级菜单)
    @Override
    public String getGoodsTypeList() {
        List<Map<String, Object>> mapList = typeListOne();
        return new Gson().toJson(mapList);
    }

    // 根目录
    private List<Map<String, Object>> typeListOne() {
        List<GoodsType> goodsTypeList = goodsTypeDao.selectGoodsTypeByPId(ROOT_PID);
        List<Map<String, Object>> mapList = new ArrayList<>();
        GoodsType goodsType = goodsTypeList.get(0);
        Map<String, Object> map = getMap(goodsType);
        mapList.add(map);
        return mapList;
    }

    // 递归求出子菜单
    private List<Map<String, Object>> typeListTwo(Integer parentId) {
        List<GoodsType> goodsTypeList = goodsTypeDao.selectGoodsTypeByPId(parentId);
        List<Map<String, Object>> mapList = new ArrayList<>();
        for (GoodsType goodsType : goodsTypeList) {
            Map<String, Object> map = getMap(goodsType);
            mapList.add(map);
        }
        return mapList;
    }

    // 抽取 typeListOne, typeListTwo 相同部分
    private Map<String, Object> getMap(GoodsType goodsType) {
        List<Map<String, Object>> mapList = new ArrayList<>();
        // 封装前端所需要的数据
        Map<String, Object> map = new LinkedHashMap<>();
        Map<String, Object> stateMap = new HashMap<>();  // 封装 {"state": 1}
        map.put("id", goodsType.getGoodsTypeId());
        map.put("text", goodsType.getGoodsTypeName());
        if (goodsType.getGoodsTypeState() == 0) {  // state=0 没有子菜单(children)
            map.put("state", "open");
            map.put("iconCls", "goods-type");
            stateMap.put("state", goodsType.getGoodsTypeState());
            map.put("attributes", stateMap);
        } else {
            map.put("state", "open");
            map.put("iconCls", "goods-type");
            stateMap.put("state", goodsType.getGoodsTypeState());
            map.put("attributes", stateMap);
            map.put("children", typeListTwo(goodsType.getGoodsTypeId()));
        }
        return map;
    }
}
