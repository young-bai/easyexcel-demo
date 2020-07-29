package com.young.easyexcel.service.impl;

import com.young.easyexcel.model.MallOrder;
import com.young.easyexcel.mapper.MallOrderMapper;
import com.young.easyexcel.service.IMallOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 订单表 服务实现类
 * </p>
 *
 * @author young
 * @since 2020-07-27
 */
@Service
@Slf4j
public class MallOrderServiceImpl extends ServiceImpl<MallOrderMapper, MallOrder> implements IMallOrderService {
	@Autowired
	MallOrderMapper orderMapper;
	@Override public void insertOrders(List<MallOrder> orders) {
		orderMapper.insertOrders(orders);
	}
}
