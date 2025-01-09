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
 * 表名称：t_room
 * 表注释：直播间表
 * NOTICE:本文件由代码生成器code-generator生成，不要在本文件手工追加任何内容，因为随时可能重新生成替换
 * github：https://github.com/feiniaojin/code-generator
 */
@Data
@Table("t_room")
@Generated("generator")
public class Room implements Serializable {
    /**
     * 自增主键
     */
    @Id
    private Long id;
    /**
     * 房间号，业务主键
     */
    private String roomId;
    /**
     * 房间名称
     */
    private String roomName;
    /**
     * 房间封面
     */
    private String roomCover;
    /**
     * 房间描述
     */
    private String roomDescription;
    /**
     * 房间状态
     */
    private Integer roomStatus;
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
