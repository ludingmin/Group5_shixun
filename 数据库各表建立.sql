/*
 Navicat Premium Data Transfer

 Source Server         : shitou
 Source Server Type    : MySQL
 Source Server Version : 80026
 Source Host           : 127.0.0.1:3306
 Source Schema         : shixun

 Target Server Type    : MySQL
 Target Server Version : 80026
 File Encoding         : 65001

 Date: 27/12/2023 20:24:20
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_action_rule
-- ----------------------------
DROP TABLE IF EXISTS `t_action_rule`;
CREATE TABLE `t_action_rule`  (
  `f_aid` int NOT NULL COMMENT ' 行为规则id',
  `f_lcode` int NOT NULL COMMENT '标签编号，链接标签表的外键',
  `f_atime` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '行为时间',
  `f_atype` int NOT NULL COMMENT '行为类型，1 web浏览页面/ 2点击商品/3 下单单数/ 4取消单数',
  `f_value_value` int NOT NULL COMMENT '行为值，（次数值）',
  `f_ajudge` int NOT NULL COMMENT '行为判断符，0 等于/ 1 大于/2 大于等于/-1小于/-2小于等于',
  `f_atype_atype` int NOT NULL COMMENT '行为值种类',
  PRIMARY KEY (`f_aid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_group
-- ----------------------------
DROP TABLE IF EXISTS `t_group`;
CREATE TABLE `t_group`  (
  `f_gid` int NOT NULL COMMENT ' 组群编号，标识主键',
  `f_pnum` int NOT NULL COMMENT '组群人数，组群人数',
  `f_gcreate_method` char(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '创建方式',
  `f_gcreate_preson` int NOT NULL COMMENT '创建人',
  `f_gcreate_time` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`f_gid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '用户分组表\r\n功能描述： 记录用户分组\r\n数据入口： 分组创建页面\r\n数据出口： 分组查看详情页面' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_lable
-- ----------------------------
DROP TABLE IF EXISTS `t_lable`;
CREATE TABLE `t_lable`  (
  `f_lid` int NOT NULL COMMENT '标签编号，标识主键',
  `f_lname` char(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '标签名称',
  `f_ltype` int NOT NULL COMMENT '标签类型',
  `f_show_lname` char(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '标签显示名称',
  `f_lvalue` char(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '标签值',
  `f_remark` char(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '标签备注',
  PRIMARY KEY (`f_lid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '用户标签表\r\n功能描述： 记录用户设定的规则\r\n数据入口： 标签添加页面\r\n数据出口： 标签修改页面 标签详情页面' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_log
-- ----------------------------
DROP TABLE IF EXISTS `t_log`;
CREATE TABLE `t_log`  (
  `f_log_id` int NOT NULL AUTO_INCREMENT COMMENT '编号',
  `F_Uname` int NOT NULL COMMENT '操作用户',
  `f_Atype_` int NOT NULL COMMENT '操作类型，1 登录账号/2 点击商品//3 下单单数/ 4取消单数',
  `f_ip` char(17) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '操作IP地址',
  `f_atime` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '操作时间',
  `f_desc` char(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '操作描述',
  PRIMARY KEY (`f_log_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '用户行为日志管理\r\n功能描述： 记录用户的数据\r\n数据入口： 用户登录页面 	\r\n数据出口： ' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_manager
-- ----------------------------
DROP TABLE IF EXISTS `t_manager`;
CREATE TABLE `t_manager`  (
  `f_number` int UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '编号，主键字段',
  `f_usercode` char(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户账号',
  `f_password` char(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户密码',
  `f_role` char(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户角色，外键字段用户权限表（t_popedom）的角色表（f_role）字段',
  `f_realname` char(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户昵称',
  `f_name` char(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '真实姓名',
  `f_sex` char(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户性别',
  `f_age` int NULL DEFAULT NULL COMMENT '用户年龄',
  `f_qq` char(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT 'QQ号码',
  `f_phone` char(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '手机号码',
  `f_email` char(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '电子邮件',
  `f_state` int NOT NULL DEFAULT 1 COMMENT '用户状态，-1为销毁/1\r\n为登录/0为未登录',
  `f_createtime` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `f_updatetime` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `f_memo` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '简介',
  PRIMARY KEY (`f_number`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '管理用户表\r\n功能描述：存储用户的姓名、用户帐号、用户密码、性别、年龄、手机号码、电话号码、电子邮件等字段的存储。通过添加用户功能可以将数据存储到表中；通过修改/删除可以对数据库内的资料进行添加删除的修改操作。\r\n数据入口：添加用户页面、修改/删除用户页面。\r\n数据出口：修改/删除用户页面。' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_manger_role
-- ----------------------------
DROP TABLE IF EXISTS `t_manger_role`;
CREATE TABLE `t_manger_role`  (
  `f_role` char(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '角色名称，管理/超级管理员',
  `f_number` int NOT NULL COMMENT '用户数',
  `f_privilege` int NOT NULL DEFAULT 0 COMMENT '操作权限，增/删/查/改',
  `f_type` int NOT NULL DEFAULT 1,
  PRIMARY KEY (`f_role`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '角色管理表\r\n功能描述：存储用户的权限。\r\n数据入口：添加用户权限页面。\r\n数据出口：修改/删除用户页面。' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_order
-- ----------------------------
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order`  (
  `f_oid` int NOT NULL COMMENT '订单id，商品交易总额',
  `f_oprice` float NOT NULL COMMENT '订单金额',
  `f_ostate` int NOT NULL COMMENT '下单状态，（0未收货/1确认收货/2完成订单/-1取消订单/-2退货）',
  `f_oaction` int NOT NULL COMMENT '下单行为，（1加入购物车/注册/点击广告/直接转化/点击推荐商品）',
  `f_otime` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '下单时间',
  `f_ofinish_time` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '订单完成时间',
  PRIMARY KEY (`f_oid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '商品订单表\r\n功能描述： 存储商品销售订单情况的表	\r\n数据入口： 数据库管理员插入，下订单页面\r\n数据出口： 查看商品动销，归因分析' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_property_rule
-- ----------------------------
DROP TABLE IF EXISTS `t_property_rule`;
CREATE TABLE `t_property_rule`  (
  `f_pid` int NOT NULL COMMENT ' 属性规则id',
  `f_lcode` int NOT NULL COMMENT '标签编号，链接标签表的外键',
  `f_property` int NOT NULL COMMENT '属性，1注册时间/2	上次登录时间/3最近下单时间',
  `f_ptype` int NOT NULL COMMENT '属性的类型，1绝对时间/2相对时间',
  `f_judge` int NOT NULL COMMENT '属性判断符',
  `f_pvalue` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`f_pid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `f_number` int UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '编号，主键字段',
  `f_usercode` char(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户账号',
  `f_password` char(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户密码',
  `f_nickname` char(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户昵称',
  `f_name` char(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '真实姓名',
  `f_sex` char(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户性别',
  `f_age` int NULL DEFAULT NULL COMMENT '用户年龄',
  `f_origin` char(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '籍贯',
  `f_liveaddress` char(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '联系地址',
  `f_state` int NOT NULL DEFAULT 1 COMMENT '用户状态，-1为销毁/1\r\n为登录/0为未登录',
  `f_createtime` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `f_updatetime` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `f_last_login_time` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '上次登录时间',
  `f_member_tiers` int NOT NULL DEFAULT 1 COMMENT '会员等级',
  `f_memo` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '简介',
  PRIMARY KEY (`f_number`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '普通用户管理表\r\n功能描述：存储用户的姓名、用户帐号、用户密码、性别、年龄、手机号码、电话号码、电子邮件等字段的存储。通过添加用户功能可以将数据存储到表中；通过修改/删除可以对数据库内的资料进行添加删除的修改操作。\r\n数据入口：添加用户页面、修改/删除用户页面。\r\n数据出口：修改/删除用户页面。' ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
