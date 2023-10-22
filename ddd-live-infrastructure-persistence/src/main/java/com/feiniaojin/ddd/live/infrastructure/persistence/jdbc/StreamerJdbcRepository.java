package com.feiniaojin.ddd.live.infrastructure.persistence.jdbc;

import com.feiniaojin.ddd.live.infrastructure.persistence.data.Streamer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * 表名称：t_streamer自动生成的Repository
 * 表注释：主播表
 * NOTICE:本文件由代码生成器code-generator生成
 * github：https://github.com/feiniaojin/code-generator
 */
@Repository
public interface StreamerJdbcRepository extends CrudRepository<Streamer, Long> {
}
