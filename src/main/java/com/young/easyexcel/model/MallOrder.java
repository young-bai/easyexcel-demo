package com.young.easyexcel.model;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.HeadRowHeight;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Controller;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * <p>
 * 订单表
 * </p>
 *
 * @author young
 * @since 2020-07-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@TableName("mall_order")
@ColumnWidth(16)
@HeadRowHeight(16)
public class MallOrder implements Serializable {

	private static final long       serialVersionUID = 1L;
	@TableId(value = "id", type = IdType.AUTO)
	@ExcelIgnore
	private              Integer    id;
	/**
	 * 订单号
	 */
	@TableField("oid")
	@ExcelProperty("订单号")
	private              String     oid;
	/**
	 * 渠道订单号
	 */
	@TableField("channelOid")
	@ExcelProperty("渠道订单号")
	private              String     channelOid;
	/**
	 * 合作方商城订单号
	 */
	@TableField("coopOId")
	@ExcelProperty("合作方商城订单号")
	private              String     coopOId;
	/**
	 * 商品类型 包括：0实物商品、1充值商品 2虚拟卡 3充值视频订单
	 */
	@TableField("producttype")
	@ExcelProperty("商品类型")
	private              String     producttype;
	/**
	 * 订单来源
	 */
	@TableField("ordersource")
	@ExcelProperty("订单来源")
	private              String     ordersource;
	/**
	 * 商户ID
	 */
	@TableField("mid")
	@ExcelProperty("商户ID")
	private              String     mid;
	/**
	 * 产品id
	 */
	@TableField("proid")
	@ExcelProperty("产品id")
	private              String     proid;
	/**
	 * 产品规格id
	 */
	@TableField("specid")
	@ExcelProperty("产品规格")
	private              String     specid;
	/**
	 * 订单状态：1待付款、2待发货、3待收货 4已完成、5已关闭 6充值失败 7商品出库中 8转售处理中
	 */
	@TableField("status")
	@ExcelProperty("订单状态")
	private              String     status;
	/**
	 * 产品单价
	 */
	@TableField("productprice")
	@ExcelProperty("产品单价")
	private              BigDecimal productprice;
	/**
	 * 订单金额
	 */
	@TableField("orderprice")
	@ExcelProperty("订单金额")
	private              BigDecimal orderprice;
	/**
	 * 优惠券id
	 */
	@TableField("couponid")
	@ExcelProperty("优惠券id")
	private              String     couponid;
	/**
	 * 优惠券优惠金额
	 */
	@TableField("coupondenomination")
	@ExcelProperty("优惠券优惠金额")
	private              BigDecimal coupondenomination;
	/**
	 * 订单创建时间(格式:yyyy-MM-dd hh:mm:ss)
	 */
	@TableField("ctime")
	@ExcelProperty(value = "订单创建时间")
	@DateTimeFormat("yyyy-MM-dd hh:mm:ss")
	private              Date       ctime;
	/**
	 * 订单更新时间(格式:yyyy-MM-dd hh:mm:ss)
	 */
	@TableField("utime")
	@ExcelProperty(value = "订单更新时间")
	@DateTimeFormat("yyyy-MM-dd hh:mm:ss")
	private              Date       utime;
}
