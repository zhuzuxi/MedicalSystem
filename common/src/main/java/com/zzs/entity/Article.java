package com.zzs.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * <p>
 * 
 * </p>
 *
 * @author zzs
 * @since 2023-10-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class Article implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "artical_id", type = IdType.ASSIGN_ID)
    private Integer artical_id;

    /**
     * 作者或来源
     */
    private String author;

    private String title;

    private String desc;

    private String content;

    private Integer likes;

    private Integer unlikes;

    private Integer collects;

    private LocalDateTime create_datetime;

}
