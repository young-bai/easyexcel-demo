package com.young.easyexcel.model;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.HeadRowHeight;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author lmhd-emp
 * @date 2020/7/29 11:25
 * @description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Model implements Serializable {

	@ExcelProperty("系统订单号")
	private String     oid;
	@ExcelProperty("省份")
	private String     province;
	@ExcelProperty("城市")
	private String     city;
	@ExcelProperty("商户ID")
	private String     merId;
	@ExcelProperty("商户订单号")
	private String     merOid;
	@ExcelProperty("充值账号")
	private String     account;
	@ExcelProperty("创建时间")
	@DateTimeFormat("yyyy/MM/dd hh:mm:ss")
	private Date       createTime;
	@DateTimeFormat("yyyy/MM/dd hh:mm:ss")
	@ExcelProperty("充值时间")
	private Date       rechargeTime;
	@ExcelProperty("充值金额")
	private BigDecimal amount;
	@ExcelProperty("扣款金额")
	private BigDecimal deduAmount;
	@ExcelProperty("折扣")
	private BigDecimal discount;
	@ExcelProperty("运营商流水")
	private String operatorTurnover;
	@ExcelProperty("结果")
	private String     result;
}
