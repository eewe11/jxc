package com.atguigu.jxc.entity;

import lombok.Data;

import java.util.List;

/**
 * 商品类别
 */
@Data
public class GoodsTypeVO {

    private Integer goodsTypeId;
    private String goodsTypeName;
    private Integer pId;
    private Integer goodsTypeState;

    private List<GoodsTypeVO> children;
}
