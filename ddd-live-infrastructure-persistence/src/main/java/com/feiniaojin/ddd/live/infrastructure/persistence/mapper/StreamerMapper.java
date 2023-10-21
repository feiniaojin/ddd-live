package com.feiniaojin.ddd.live.infrastructure.persistence.mapper;

import com.feiniaojin.ddd.live.infrastructure.persistence.data.Streamer;
import org.apache.ibatis.annotations.Param;

import javax.annotation.Generated;
import java.util.List;
import java.util.Map;

/**
 * 表名称：t_streamer自动生成的Mapper
 * 表注释：主播表
 * NOTICE:本文件由代码生成器code-generator生成
 * github：https://github.com/feiniaojin/code-generator
 */
@Generated("generator")
public interface StreamerMapper {
    int insert(Streamer record);
    Streamer findOneById(@Param("id")Long id);

    int countForPageList(Map<String, Object> paramMap);

    List<Streamer> pageList(Map<String, Object> paramMap);
}