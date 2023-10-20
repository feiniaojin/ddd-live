CREATE DATABASE db_ddd_live;

USE db_ddd_live;

CREATE TABLE `t_room` (
	`id` bigint NOT NULL AUTO_INCREMENT COMMENT '自增主键',
	`room_id` varchar(64) NULL COMMENT '房间号，业务主键',
	`room_name` varchar(64) NULL COMMENT '房间名称',
	`cover` varchar(256)  NULL COMMENT '房间封面',
	`deleted` tinyint NULL DEFAULT 0 COMMENT '逻辑删除标记[0-正常；1-已删除]',
	`created_by` VARCHAR(100) COMMENT '创建人',
	`created_time` DATETIME NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	`modified_by` VARCHAR(100) COMMENT '更新人',
	`modified_time` DATETIME NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
	`version` bigint DEFAULT 1 COMMENT '乐观锁',
	PRIMARY KEY (`id`),
	INDEX `idx_roomId`(`room_id`)
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE utf8mb4_bin COMMENT '直播间表';

CREATE TABLE `t_live` (
	`id` bigint NOT NULL AUTO_INCREMENT COMMENT '自增主键',
	`room_id` varchar(64) NULL COMMENT '房间号，业务主键',
	`stream_id` varchar(64) NULL COMMENT '推流id',
	`plan_start_time` DATETIME  NULL COMMENT '计划开播时间',
	`plan_end_time` DATETIME  NULL COMMENT '计划下播时间',
	`live_status` INT  NULL COMMENT '直播状态',
	`deleted` tinyint NULL DEFAULT 0 COMMENT '逻辑删除标记[0-正常；1-已删除]',
	`created_by` VARCHAR(100) COMMENT '创建人',
	`created_time` DATETIME NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	`modified_by` VARCHAR(100) COMMENT '更新人',
	`modified_time` DATETIME NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
	`version` bigint DEFAULT 1 COMMENT '乐观锁',
	PRIMARY KEY (`id`),
	INDEX `idx_streamId`(`stream_id`)
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE utf8mb4_bin COMMENT '直播表';

CREATE TABLE `t_streamer` (
	`id` bigint NOT NULL AUTO_INCREMENT COMMENT '自增主键',
	`streamer_id` varchar(64) NULL COMMENT '主播号，业务主键',
	`streamer_name` varchar(64) NULL COMMENT '主播名称',
	`streamer_` varchar(64) NULL COMMENT '主播名称',
	`deleted` tinyint NULL DEFAULT 0 COMMENT '逻辑删除标记[0-正常；1-已删除]',
	`created_by` VARCHAR(100) COMMENT '创建人',
	`created_time` DATETIME NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	`modified_by` VARCHAR(100) COMMENT '更新人',
	`modified_time` DATETIME NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
	`version` bigint DEFAULT 1 COMMENT '乐观锁',
	PRIMARY KEY (`id`),
	INDEX `idx_streamId`(`stream_id`)
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE utf8mb4_bin COMMENT '主播表';