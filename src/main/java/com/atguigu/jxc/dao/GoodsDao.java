package com.atguigu.jxc.dao;

import com.atguigu.jxc.entity.Goods;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 商品管理
 */
public interface GoodsDao {

    // 首页默认显示商品列表
    List<Goods> selectListInventory(@Param("page") Integer page,
                                    @Param("rows") Integer rows,
                                    @Param("codeOrName") String codeOrName,
                                    @Param("goodsTypeId") Integer goodsTypeId);

    // 商品管理所有商品信息分页展示()
    List<Goods> selectListByGoodsNameOrGoodsType(Integer page, Integer rows, String goodsName, Integer goodsTypeId);

}
