package com.young.easyexcel.model;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import java.util.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author young
 * @since 2020-07-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class RechargeCostOrder implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 代理编码
     */
    @TableField("agencycode")
    private String agencycode;

    /**
     * 商户码
     */
    @TableField("usercode")
    private String usercode;

    /**
     * 商户id
     */
    @TableField("merid")
    private String merid;

    /**
     * 乐盟订单号
     */
    @TableField("orderid")
    private String orderid;

    /**
     * 采购订单号
     */
    @TableField("submitid")
    private String submitid;

    /**
     * 商户订单号
     */
    @TableField("merorderid")
    private String merorderid;

    /**
     * 手机号
     */
    @TableField("mobile")
    private String mobile;

    /**
     * 充值类型
     */
    @TableField("rechargetype")
    private String rechargetype;

    /**
     * 面额 
     */
    @TableField("denomination")
    private String denomination;

    /**
     * 订单状态
     */
    @TableField("status")
    private String status;

    /**
     * 订单结果
     */
    @TableField("result")
    private String result;

    /**
     * 支付状态
     */
    @TableField("accresult")
    private String accresult;

    /**
     * 运营商
     */
    @TableField("isp")
    private String isp;

    /**
     * 归属地
     */
    @TableField("province")
    private String province;

    /**
     * 订单时间
     */
    @TableField("createdate")
    private Date createdate;

    /**
     * 订单结束时间
     */
    @TableField("overdate")
    private Date overdate;

    @TableField("price")
    private BigDecimal price;

    @TableField("requestdate")
    private LocalDateTime requestdate;

    /**
     * 商户回调地址
     */
    @TableField("callbackuri")
    private String callbackuri;

    /**
     * 是否被锁定
     */
    @TableField("islock")
    private String islock;

    /**
     * 流量充值选项 0 全国 1省内 为空 任意
     */
    @TableField("flowoption")
    private String flowoption;

    @TableField("realusercode")
    private String realusercode;

    /**
     * 备注
     */
    @TableField("remark")
    private String remark;

    @TableField("modifydate")
    private Date modifydate;

    @TableField("modifier")
    private String modifier;

    @TableField("channel_type")
    private String channelType;


}
