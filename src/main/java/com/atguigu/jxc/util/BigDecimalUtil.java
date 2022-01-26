package com.atguigu.jxc.util;

import java.math.BigDecimal;

/**
 * @description 数学工具类
 */
public class BigDecimalUtil {

    /**
     * 保留两位小数
     * @param math 需要处理的数据
     * @return 保留两位小数的浮点型数据
     */
    public static float keepTwoDecimalPlaces(float math){

        BigDecimal decimal = new BigDecimal(math);

        return decimal.setScale(2, BigDecimal.ROUND_HALF_EVEN).floatValue();

    }

    /**
     * 保留两位小数
     * @param math 需要处理的数据
     * @return 保留两位小数的浮点型数据
     */
    public static float keepTwoDecimalPlaces(Double math){

        BigDecimal decimal = new BigDecimal(math);

        return decimal.setScale(2, BigDecimal.ROUND_HALF_EVEN).floatValue();

    }

}

