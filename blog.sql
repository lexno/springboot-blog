/*
 Navicat Premium Data Transfer

 Source Server         : 本地MySQL
 Source Server Type    : MySQL
 Source Server Version : 80012
 Source Host           : localhost:3306
 Source Schema         : blog

 Target Server Type    : MySQL
 Target Server Version : 80012
 File Encoding         : 65001

 Date: 06/09/2018 17:09:19
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_log`;
CREATE TABLE `sys_log`  (
  `id` bigint(40) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `ip` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '操作地址的IP',
  `gmt_create` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '操作开始时间',
  `gmt_modified` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '操作内容',
  `operate_url` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '操作的访问地址',
  `operate_by` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '操作的浏览器',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '日志表' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for sys_view
-- ----------------------------
DROP TABLE IF EXISTS `sys_view`;
CREATE TABLE `sys_view`  (
  `id` bigint(40) NOT NULL AUTO_INCREMENT,
  `ip` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '访问IP',
  `gmt_create` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '访问开始时间',
  `gmt_modified` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '网站访问量表' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for tbl_article_content
-- ----------------------------
DROP TABLE IF EXISTS `tbl_article_content`;
CREATE TABLE `tbl_article_content`  (
  `id` bigint(40) NOT NULL AUTO_INCREMENT,
  `content` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `article_id` bigint(40) NOT NULL COMMENT '对应文章ID',
  `gmt_create` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '文章内容表' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for tbl_article_info
-- ----------------------------
DROP TABLE IF EXISTS `tbl_article_info`;
CREATE TABLE `tbl_article_info`  (
  `id` bigint(40) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `category_id` bigint(40) NOT NULL COMMENT '分类id',
  `title` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '文章标题',
  `picture_url` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '图片url',
  `summary` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '文章简介，默认100个汉字以内',
  `is_top` tinyint(1) NOT NULL DEFAULT 0 COMMENT '文章是否置顶，0为否，1为是',
  `traffic` int(10) NOT NULL DEFAULT 0 COMMENT '文章访问量',
  `gmt_create` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改日期',
  `is_delete` tinyint(1) NOT NULL DEFAULT 0 COMMENT '是否删除，默认为0为未删除，1为已删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '文章信息表' ROW_FORMAT = Compact;


-- ----------------------------
-- Table structure for tbl_category_info
-- ----------------------------
DROP TABLE IF EXISTS `tbl_category_info`;
CREATE TABLE `tbl_category_info`  (
  `id` bigint(40) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '分类名称',
  `gmt_create` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '分类创建时间',
  `gmt_modified` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '分类修改时间',
  `is_delete` tinyint(1) NOT NULL DEFAULT 0 COMMENT '是否删除，默认为0为未删除，1为已删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '分类信息表' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for tbl_comment
-- ----------------------------
DROP TABLE IF EXISTS `tbl_comment`;
CREATE TABLE `tbl_comment`  (
  `id` bigint(40) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `article_id` bigint(40) NOT NULL COMMENT '文章ID',
  `content` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '留言/评论内容',
  `email` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '邮箱，用于回复消息',
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '用户自己定义的名称',
  `ip` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '留言/评论IP',
  `is_delete` tinyint(1) NOT NULL DEFAULT 0 COMMENT '是否删除，默认为0为未删除，1为已删除',
  `gmt_create` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '评论时间',
  `gmt_modified` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改评论时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '评论表' ROW_FORMAT = Compact;

SET FOREIGN_KEY_CHECKS = 1;
