package com.young.easyexcel.mapper;

import com.young.easyexcel.model.MallOrder;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p>
 * 订单表 Mapper 接口
 * </p>
 *
 * @author young
 * @since 2020-07-27
 */
public interface MallOrderMapper extends BaseMapper<MallOrder> {
	/**
	 * @param orders
	 */
	void insertOrders(@Param("orders") List<MallOrder> orders);
}
