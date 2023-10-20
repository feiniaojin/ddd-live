package com.feiniaojin.ddd.live.infrastructure.persistence.data;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Version;
import org.springframework.data.relational.core.mapping.Table;

import javax.annotation.Generated;
import java.io.Serializable;
import java.util.Date;

/**
 * 表名称：t_streamer
 * 表注释：主播表
 * NOTICE:本文件由代码生成器code-generator生成，不要在本文件手工追加任何内容，因为随时可能重新生成替换
 * github：https://github.com/feiniaojin/code-generator
 */
@Data
@Table("t_streamer")
@Generated("generator")
public class Streamer implements Serializable {
    /**
     * 自增主键
     */
    @Id
    private Long id;
    /**
     * 主播号，业务主键
     */
    private String streamerId;
    /**
     * 主播名称
     */
    private String streamerName;
    /**
     * 逻辑删除标记[0-正常；1-已删除]
     */
    private Integer deleted;
    /**
     * 创建人
     */
    private String createdBy;
    /**
     * 创建时间
     */
     @CreatedDate
    private Date createdTime;
    /**
     * 更新人
     */
    private String modifiedBy;
    /**
     * 更新时间
     */
    @LastModifiedDate
    private Date modifiedTime;
    /**
     * 乐观锁
     */
    @Version
    private Long version;
}
