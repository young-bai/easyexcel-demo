/*
 Navicat Premium Data Transfer

 Source Server         : 127.0.0.1
 Source Server Type    : MySQL
 Source Server Version : 50641
 Source Host           : localhost:3306
 Source Schema         : test

 Target Server Type    : MySQL
 Target Server Version : 50641
 File Encoding         : 65001

 Date: 29/07/2020 17:48:01
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for mall_order
-- ----------------------------
DROP TABLE IF EXISTS `mall_order`;
CREATE TABLE `mall_order`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `oid` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '订单号',
  `channelOid` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '渠道订单号',
  `coopOId` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '合作方商城订单号',
  `producttype` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品类型 包括：0实物商品、1充值商品 2虚拟卡 3充值视频订单',
  `ordersource` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '订单来源',
  `mid` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商户ID',
  `proid` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '产品id',
  `specid` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '产品规格id',
  `status` varchar(14) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '订单状态：1待付款、2待发货、3待收货 4已完成、5已关闭 6充值失败 7商品出库中 8转售处理中',
  `productprice` decimal(18, 2) NULL DEFAULT NULL COMMENT '产品单价',
  `orderprice` decimal(18, 2) NULL DEFAULT NULL COMMENT '订单金额',
  `couponid` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '优惠券id',
  `coupondenomination` decimal(10, 2) NULL DEFAULT NULL COMMENT '优惠券优惠金额',
  `ctime` datetime(0) NULL DEFAULT NULL COMMENT '订单创建时间(格式:yyyy-MM-dd hh:mm:ss)',
  `utime` datetime(0) NULL DEFAULT NULL COMMENT '订单更新时间(格式:yyyy-MM-dd hh:mm:ss)',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11450116 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '订单表' ROW_FORMAT = COMPACT;

SET FOREIGN_KEY_CHECKS = 1;
