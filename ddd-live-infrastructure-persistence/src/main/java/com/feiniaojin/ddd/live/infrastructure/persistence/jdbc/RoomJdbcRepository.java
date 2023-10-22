package com.feiniaojin.ddd.live.infrastructure.persistence.jdbc;

import com.feiniaojin.ddd.live.infrastructure.persistence.data.Room;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * 表名称：t_room自动生成的Repository
 * 表注释：直播间表
 * NOTICE:本文件由代码生成器code-generator生成
 * github：https://github.com/feiniaojin/code-generator
 */
@Repository
public interface RoomJdbcRepository extends CrudRepository<Room, Long> {
    @Query("select * from t_room where room_id=:roomId limit 1")
    Room queryOneByBizId(String roomId);
}
