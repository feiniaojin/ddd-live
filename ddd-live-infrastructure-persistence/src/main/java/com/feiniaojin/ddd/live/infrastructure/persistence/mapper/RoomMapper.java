package com.feiniaojin.ddd.live.infrastructure.persistence.mapper;

import com.feiniaojin.ddd.live.infrastructure.persistence.data.Room;
import org.apache.ibatis.annotations.Param;

import javax.annotation.Generated;

/**
 * 表名称：t_room自动生成的Mapper
 * 表注释：直播间表
 * NOTICE:本文件由代码生成器code-generator生成
 * github：https://github.com/feiniaojin/code-generator
 */
@Generated("generator")
public interface RoomMapper {
    int insert(Room record);
    Room findOneById(@Param("id")Long id);
}