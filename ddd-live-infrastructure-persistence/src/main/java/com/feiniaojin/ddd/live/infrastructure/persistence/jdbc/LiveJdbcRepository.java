package com.feiniaojin.ddd.live.infrastructure.persistence.jdbc;

import com.feiniaojin.ddd.live.infrastructure.persistence.data.Live;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * 表名称：t_live自动生成的Repository
 * 表注释：直播表
 * NOTICE:本文件由代码生成器code-generator生成
 * github：https://github.com/feiniaojin/code-generator
 */
@Repository
public interface LiveJdbcRepository extends CrudRepository<Live, Long> {

    @Query("select * from t_live where live_id=:liveId limit 1")
    Live queryOneByBizId(String liveId);

}
