/*
 Navicat Premium Data Transfer

 Source Server         : 10.7.46.104(fw)
 Source Server Type    : MySQL
 Source Server Version : 50640
 Source Host           : 10.7.46.104:3306
 Source Schema         : security-demo

 Target Server Type    : MySQL
 Target Server Version : 50640
 File Encoding         : 65001

 Date: 06/12/2019 11:45:07
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for fw_userconnection
-- ----------------------------
DROP TABLE IF EXISTS `fw_userconnection`;
CREATE TABLE `fw_userconnection`  (
  `userId` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `providerId` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `providerUserId` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `rank` int(11) NOT NULL,
  `displayName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `profileUrl` varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `imageUrl` varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `accessToken` varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `secret` varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `refreshToken` varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `expireTime` bigint(20) NULL DEFAULT NULL,
  PRIMARY KEY (`userId`, `providerId`, `providerUserId`) USING BTREE,
  UNIQUE INDEX `UserConnectionRank`(`userId`, `providerId`, `rank`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for persistent_logins
-- ----------------------------
DROP TABLE IF EXISTS `persistent_logins`;
CREATE TABLE `persistent_logins`  (
  `username` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `series` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `token` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `last_used` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`series`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for sys_oauth_client
-- ----------------------------
DROP TABLE IF EXISTS `sys_oauth_client`;
CREATE TABLE `sys_oauth_client`  (
  `client_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `resource_ids` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `client_secret` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `scope` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `authorized_grant_types` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `web_server_redirect_uri` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `authorities` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `access_token_validity` int(11) NULL DEFAULT NULL,
  `refresh_token_validity` int(11) NULL DEFAULT NULL,
  `additional_information` varchar(4096) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `autoapprove` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`client_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '客户端信息表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_oauth_client
-- ----------------------------
INSERT INTO `sys_oauth_client` VALUES ('app', NULL, 'app', 'server', 'password,refresh_token', NULL, NULL, NULL, NULL, NULL, 'true');
INSERT INTO `sys_oauth_client` VALUES ('daemon', NULL, 'daemon', 'server', 'password,refresh_token', NULL, NULL, NULL, NULL, NULL, 'true');
INSERT INTO `sys_oauth_client` VALUES ('fw', NULL, 'fw', 'server', 'password,refresh_token,authorization_code,client_credentials', '', NULL, NULL, NULL, NULL, 'true');
INSERT INTO `sys_oauth_client` VALUES ('gen', NULL, 'gen', 'server', 'password,refresh_token', NULL, NULL, NULL, NULL, NULL, 'true');
INSERT INTO `sys_oauth_client` VALUES ('test', NULL, 'test', 'server', 'password,refresh_token', NULL, NULL, NULL, NULL, NULL, 'true');

-- ----------------------------
-- Table structure for sys_power
-- ----------------------------
DROP TABLE IF EXISTS `sys_power`;
CREATE TABLE `sys_power`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `create_time` datetime(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) COMMENT '创建时间',
  `update_time` datetime(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3) COMMENT '更新时间',
  `create_user` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '创建人编码',
  `update_user` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '修改人编码',
  `delete_flag` tinyint(4) NOT NULL DEFAULT 0 COMMENT '删除标记(1 删除 0未删除)',
  `disable_flag` tinyint(4) NOT NULL DEFAULT 0 COMMENT '启用标记(1 禁用 0启用)',
  `power_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '权限编码',
  `power_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '权限名称',
  `power_alias` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '权限别名',
  `p_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '上级权限',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 55 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '权限管理' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_power
-- ----------------------------
INSERT INTO `sys_power` VALUES (1, '2019-10-17 17:11:14.807', '2019-10-20 11:33:16.200', '', '', 0, 0, '1', 'ADMIN', '超级管理员', '0');
INSERT INTO `sys_power` VALUES (2, '2019-10-17 17:11:14.807', '2019-10-20 11:33:17.656', '', '', 0, 0, '2', 'USER_ALL', '用户管理', '0');
INSERT INTO `sys_power` VALUES (3, '2019-10-17 17:11:14.807', '2019-10-20 11:33:18.767', '', '', 0, 0, '3', 'USER_SELECT', '用户查询', '2');
INSERT INTO `sys_power` VALUES (4, '2019-10-17 17:11:14.807', '2019-10-20 11:33:19.634', '', '', 0, 0, '4', 'USER_CREATE', '用户创建', '2');
INSERT INTO `sys_power` VALUES (5, '2019-10-17 17:11:14.807', '2019-10-20 11:33:20.669', '', '', 0, 0, '5', 'USER_EDIT', '用户编辑', '2');
INSERT INTO `sys_power` VALUES (6, '2019-10-17 17:11:14.807', '2019-10-20 11:33:21.400', '', '', 0, 0, '6', 'USER_DELETE', '用户删除', '2');
INSERT INTO `sys_power` VALUES (7, '2019-10-17 17:11:14.807', '2019-10-20 11:33:28.853', '', '', 0, 0, '7', 'ROLES_ALL', '角色管理', '0');
INSERT INTO `sys_power` VALUES (8, '2019-10-17 17:11:14.807', '2019-10-20 11:33:30.701', '', '', 0, 0, '8', 'ROLES_SELECT', '角色查询', '7');
INSERT INTO `sys_power` VALUES (10, '2019-10-17 17:11:14.807', '2019-10-20 11:34:06.741', '', '', 0, 0, '10', 'ROLES_CREATE', '角色创建', '7');
INSERT INTO `sys_power` VALUES (11, '2019-10-17 17:11:14.807', '2019-10-20 11:34:06.801', '', '', 0, 0, '11', 'ROLES_EDIT', '角色编辑', '7');
INSERT INTO `sys_power` VALUES (12, '2019-10-17 17:11:14.807', '2019-10-20 11:34:06.870', '', '', 0, 0, '12', 'ROLES_DELETE', '角色删除', '7');
INSERT INTO `sys_power` VALUES (13, '2019-10-17 17:11:14.807', '2019-10-20 11:34:06.940', '', '', 0, 0, '13', 'PERMISSION_ALL', '权限管理', '0');
INSERT INTO `sys_power` VALUES (14, '2019-10-17 17:11:14.807', '2019-10-20 11:34:06.998', '', '', 0, 0, '14', 'PERMISSION_SELECT', '权限查询', '13');
INSERT INTO `sys_power` VALUES (15, '2019-10-17 17:11:14.807', '2019-10-20 11:34:07.071', '', '', 0, 0, '15', 'PERMISSION_CREATE', '权限创建', '13');
INSERT INTO `sys_power` VALUES (16, '2019-10-17 17:11:14.807', '2019-10-20 11:34:07.153', '', '', 0, 0, '16', 'PERMISSION_EDIT', '权限编辑', '13');
INSERT INTO `sys_power` VALUES (17, '2019-10-17 17:11:14.807', '2019-10-20 11:34:07.213', '', '', 0, 0, '17', 'PERMISSION_DELETE', '权限删除', '13');
INSERT INTO `sys_power` VALUES (18, '2019-10-17 17:11:14.807', '2019-10-20 11:34:07.273', '', '', 0, 0, '18', 'REDIS_ALL', '缓存管理', '0');
INSERT INTO `sys_power` VALUES (20, '2019-10-17 17:11:14.807', '2019-10-20 11:34:07.346', '', '', 0, 0, '20', 'REDIS_SELECT', '缓存查询', '18');
INSERT INTO `sys_power` VALUES (22, '2019-10-17 17:11:14.807', '2019-10-20 11:34:07.411', '', '', 0, 0, '22', 'REDIS_DELETE', '缓存删除', '18');
INSERT INTO `sys_power` VALUES (23, '2019-10-17 17:11:14.807', '2019-10-20 11:34:07.482', '', '', 0, 0, '23', 'PICTURE_ALL', '图床管理', '0');
INSERT INTO `sys_power` VALUES (24, '2019-10-17 17:11:14.807', '2019-10-20 11:34:07.547', '', '', 0, 0, '24', 'PICTURE_SELECT', '查询图片', '23');
INSERT INTO `sys_power` VALUES (25, '2019-10-17 17:11:14.807', '2019-10-20 11:34:07.726', '', '', 0, 0, '25', 'PICTURE_UPLOAD', '上传图片', '23');
INSERT INTO `sys_power` VALUES (26, '2019-10-17 17:11:14.807', '2019-10-20 11:34:07.891', '', '', 0, 0, '26', 'PICTURE_DELETE', '删除图片', '23');
INSERT INTO `sys_power` VALUES (29, '2019-10-17 17:11:14.807', '2019-10-20 11:34:07.998', '', '', 0, 0, '29', 'MENU_ALL', '菜单管理', '0');
INSERT INTO `sys_power` VALUES (30, '2019-10-17 17:11:14.807', '2019-10-20 11:34:08.072', '', '', 0, 0, '30', 'MENU_SELECT', '菜单查询', '29');
INSERT INTO `sys_power` VALUES (31, '2019-10-17 17:11:14.807', '2019-10-20 11:34:08.134', '', '', 0, 0, '31', 'MENU_CREATE', '菜单创建', '29');
INSERT INTO `sys_power` VALUES (32, '2019-10-17 17:11:14.807', '2019-10-20 11:34:08.206', '', '', 0, 0, '32', 'MENU_EDIT', '菜单编辑', '29');
INSERT INTO `sys_power` VALUES (33, '2019-10-17 17:11:14.807', '2019-10-20 11:34:08.283', '', '', 0, 0, '33', 'MENU_DELETE', '菜单删除', '29');
INSERT INTO `sys_power` VALUES (35, '2019-10-17 17:11:14.807', '2019-10-20 11:34:08.352', '', '', 0, 0, '35', 'JOB_ALL', '定时任务管理', '0');
INSERT INTO `sys_power` VALUES (36, '2019-10-17 17:11:14.807', '2019-10-20 11:34:08.430', '', '', 0, 0, '36', 'JOB_SELECT', '任务查询', '35');
INSERT INTO `sys_power` VALUES (37, '2019-10-17 17:11:14.807', '2019-10-20 11:34:08.501', '', '', 0, 0, '37', 'JOB_CREATE', '任务创建', '35');
INSERT INTO `sys_power` VALUES (38, '2019-10-17 17:11:14.807', '2019-10-20 11:34:08.560', '', '', 0, 0, '38', 'JOB_EDIT', '任务编辑', '35');
INSERT INTO `sys_power` VALUES (39, '2019-10-17 17:11:14.807', '2019-10-20 11:34:08.635', '', '', 0, 0, '39', 'JOB_DELETE', '任务删除', '35');
INSERT INTO `sys_power` VALUES (40, '2019-10-17 17:11:14.807', '2019-10-20 11:34:08.708', '', '', 0, 0, '40', 'DEPT_ALL', '部门管理', '0');
INSERT INTO `sys_power` VALUES (41, '2019-10-17 17:11:14.807', '2019-10-20 11:34:08.769', '', '', 0, 0, '41', 'DEPT_SELECT', '部门查询', '40');
INSERT INTO `sys_power` VALUES (42, '2019-10-17 17:11:14.807', '2019-10-20 11:34:08.844', '', '', 0, 0, '42', 'DEPT_CREATE', '部门创建', '40');
INSERT INTO `sys_power` VALUES (43, '2019-10-17 17:11:14.807', '2019-10-20 11:34:08.927', '', '', 0, 0, '43', 'DEPT_EDIT', '部门编辑', '40');
INSERT INTO `sys_power` VALUES (44, '2019-10-17 17:11:14.807', '2019-10-20 11:34:08.987', '', '', 0, 0, '44', 'DEPT_DELETE', '部门删除', '40');
INSERT INTO `sys_power` VALUES (45, '2019-10-17 17:11:14.807', '2019-10-20 11:34:09.071', '', '', 0, 0, '45', 'USERJOB_ALL', '岗位管理', '0');
INSERT INTO `sys_power` VALUES (46, '2019-10-17 17:11:14.807', '2019-10-20 11:34:09.171', '', '', 0, 0, '46', 'USERJOB_SELECT', '岗位查询', '45');
INSERT INTO `sys_power` VALUES (47, '2019-10-17 17:11:14.807', '2019-10-20 11:34:09.257', '', '', 0, 0, '47', 'USERJOB_CREATE', '岗位创建', '45');
INSERT INTO `sys_power` VALUES (48, '2019-10-17 17:11:14.807', '2019-10-20 11:34:09.338', '', '', 0, 0, '48', 'USERJOB_EDIT', '岗位编辑', '45');
INSERT INTO `sys_power` VALUES (49, '2019-10-17 17:11:14.807', '2019-10-20 11:34:09.401', '', '', 0, 0, '49', 'USERJOB_DELETE', '岗位删除', '45');
INSERT INTO `sys_power` VALUES (50, '2019-10-17 17:11:14.807', '2019-10-20 11:34:09.468', '', '', 0, 0, '50', 'DICT_ALL', '字典管理', '0');
INSERT INTO `sys_power` VALUES (51, '2019-10-17 17:11:14.807', '2019-10-20 11:34:09.701', '', '', 0, 0, '51', 'DICT_SELECT', '字典查询', '50');
INSERT INTO `sys_power` VALUES (52, '2019-10-17 17:11:14.807', '2019-10-20 11:34:09.808', '', '', 0, 0, '52', 'DICT_CREATE', '字典创建', '50');
INSERT INTO `sys_power` VALUES (53, '2019-10-17 17:11:14.807', '2019-10-20 11:34:09.904', '', '', 0, 0, '53', 'DICT_EDIT', '字典编辑', '50');
INSERT INTO `sys_power` VALUES (54, '2019-10-17 17:11:14.807', '2019-10-20 11:34:09.975', '', '', 0, 0, '54', 'DICT_DELETE', '字典删除', '50');

-- ----------------------------
-- Table structure for sys_roles_powers
-- ----------------------------
DROP TABLE IF EXISTS `sys_roles_powers`;
CREATE TABLE `sys_roles_powers`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `create_time` datetime(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) COMMENT '创建时间',
  `update_time` datetime(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3) COMMENT '更新时间',
  `role_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色编码',
  `power_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '权限编码',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 20 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色权限关联表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_roles_powers
-- ----------------------------
INSERT INTO `sys_roles_powers` VALUES (1, '2019-10-17 17:36:49.941', '2019-10-17 17:36:49.941', '1', '1');
INSERT INTO `sys_roles_powers` VALUES (2, '2019-10-17 17:36:49.941', '2019-10-17 17:36:49.941', '2', '3');
INSERT INTO `sys_roles_powers` VALUES (3, '2019-10-17 17:36:49.941', '2019-10-17 17:36:49.941', '2', '8');
INSERT INTO `sys_roles_powers` VALUES (4, '2019-10-17 17:36:49.941', '2019-10-17 17:36:49.941', '2', '14');
INSERT INTO `sys_roles_powers` VALUES (5, '2019-10-17 17:36:49.941', '2019-10-17 17:36:49.941', '2', '20');
INSERT INTO `sys_roles_powers` VALUES (6, '2019-10-17 17:36:49.941', '2019-10-17 17:36:49.941', '2', '23');
INSERT INTO `sys_roles_powers` VALUES (7, '2019-10-17 17:36:49.941', '2019-10-17 17:36:49.941', '2', '24');
INSERT INTO `sys_roles_powers` VALUES (8, '2019-10-17 17:36:49.941', '2019-10-17 17:36:49.941', '2', '25');
INSERT INTO `sys_roles_powers` VALUES (9, '2019-10-17 17:36:49.941', '2019-10-17 17:36:49.941', '2', '26');
INSERT INTO `sys_roles_powers` VALUES (10, '2019-10-17 17:36:49.941', '2019-10-17 17:36:49.941', '2', '30');
INSERT INTO `sys_roles_powers` VALUES (11, '2019-10-17 17:36:49.941', '2019-10-17 17:36:49.941', '2', '36');
INSERT INTO `sys_roles_powers` VALUES (12, '2019-10-17 17:36:49.941', '2019-10-17 17:36:49.941', '2', '41');
INSERT INTO `sys_roles_powers` VALUES (13, '2019-10-17 17:36:49.941', '2019-10-17 17:36:49.941', '2', '46');
INSERT INTO `sys_roles_powers` VALUES (14, '2019-10-17 17:36:49.941', '2019-10-17 17:36:49.941', '2', '51');
INSERT INTO `sys_roles_powers` VALUES (15, '2019-10-17 17:36:49.941', '2019-10-17 17:36:49.941', '4', '3');
INSERT INTO `sys_roles_powers` VALUES (16, '2019-10-17 17:36:49.941', '2019-10-17 17:36:49.941', '4', '4');
INSERT INTO `sys_roles_powers` VALUES (17, '2019-10-17 17:36:49.941', '2019-10-17 17:36:49.941', '4', '5');
INSERT INTO `sys_roles_powers` VALUES (19, '2019-10-30 13:48:34.914', '2019-10-30 13:48:34.914', 'string', 'string');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `create_time` datetime(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) COMMENT '创建时间',
  `update_time` datetime(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3) COMMENT '更新时间',
  `create_user` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '创建人编码',
  `update_user` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '修改人编码',
  `delete_flag` tinyint(4) NOT NULL DEFAULT 0 COMMENT '删除标记(1 删除 0未删除)',
  `pos_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '职位编码',
  `disable_flag` tinyint(4) NOT NULL DEFAULT 0 COMMENT '启用标记(1 禁用 0启用)',
  `avatar` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '头像地址',
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `password` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `user_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `real_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '真实姓名',
  `dept_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '部门编码',
  `user_phone` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `idx_email`(`email`) USING BTREE COMMENT '邮箱索引',
  UNIQUE INDEX `idx_user_name`(`user_name`) USING BTREE COMMENT '用户名索引',
  INDEX `idx_dept_code`(`dept_code`) USING BTREE COMMENT '部门编码索引',
  INDEX `idx_position_code`(`pos_code`) USING BTREE COMMENT '职位编码索引'
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '系统用户表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (1, '2019-10-17 17:44:07.492', '2019-12-01 21:21:32.688', '', '', 0, '1', 0, 'https://i.loli.net/2019/04/04/5ca5b971e1548.jpeg', 'admin@eladmin.net', '$2a$10$JySArxXjzgyK5sn4cgA6guuFY7Bqcnin1GnVZVB1NBtLPCu1TNRP2', 'admin', NULL, '1', '18888888888');
INSERT INTO `sys_user` VALUES (3, '2019-10-17 17:44:07.492', '2019-12-01 21:21:32.750', '', '', 0, '2', 0, 'https://aurora-1255840532.cos.ap-chengdu.myqcloud.com/8918a306ea314404835a9196585c4b75.jpeg', 'test@eladmin.net', '$2a$10$JySArxXjzgyK5sn4cgA6guuFY7Bqcnin1GnVZVB1NBtLPCu1TNRP2', 'test', NULL, '2', '17777777777');
INSERT INTO `sys_user` VALUES (5, '2019-10-17 17:44:07.492', '2019-12-02 17:02:11.989', '', '', 0, '3', 0, 'https://aurora-1255840532.cos.ap-chengdu.myqcloud.com/8918a306ea314404835a9196585c4b75.jpeg', 'hr@eladmin.net', '$2a$10$JySArxXjzgyK5sn4cgA6guuFY7Bqcnin1GnVZVB1NBtLPCu1TNRP2', 'test1', NULL, '3', '15555555555');
INSERT INTO `sys_user` VALUES (9, '2019-10-17 17:44:07.492', '2019-12-01 21:21:32.888', '', '', 0, '4', 0, 'https://i.loli.net/2019/04/04/5ca5b971e1548.jpeg', 'admin@eladmin11.net', '$2a$10$JySArxXjzgyK5sn4cgA6guuFY7Bqcnin1GnVZVB1NBtLPCu1TNRP2', 'admin000', NULL, '6', '18888888888');

-- ----------------------------
-- Table structure for sys_users_roles
-- ----------------------------
DROP TABLE IF EXISTS `sys_users_roles`;
CREATE TABLE `sys_users_roles`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `create_time` datetime(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) COMMENT '创建时间',
  `update_time` datetime(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3) COMMENT '更新时间',
  `user_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '用户名',
  `role_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '角色编码',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户角色关联表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_users_roles
-- ----------------------------
INSERT INTO `sys_users_roles` VALUES (1, '2019-10-17 17:48:31.141', '2019-10-20 13:02:50.042', 'admin', '1');
INSERT INTO `sys_users_roles` VALUES (2, '2019-10-17 17:48:31.141', '2019-10-20 13:02:52.319', 'admin', '2');
INSERT INTO `sys_users_roles` VALUES (3, '2019-10-17 17:48:31.141', '2019-10-22 11:30:11.537', 'test', '3');

SET FOREIGN_KEY_CHECKS = 1;
