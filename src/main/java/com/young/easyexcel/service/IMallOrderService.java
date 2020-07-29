package com.young.easyexcel.service;

import com.young.easyexcel.model.MallOrder;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 订单表 服务类
 * </p>
 *
 * @author young
 * @since 2020-07-27
 */
public interface IMallOrderService extends IService<MallOrder> {

	void insertOrders(List<MallOrder> orders);
}
