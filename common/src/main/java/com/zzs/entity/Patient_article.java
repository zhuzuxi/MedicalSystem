package com.zzs.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

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
public class Patient_article implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户id
     */
    private Integer pid;

    /**
     * 文章id
     */
    private Integer aid;

    private Integer islike;

    private Integer isdislike;

    private Integer iscollect;

    public Patient_article(){
        this.islike=0;
        this.isdislike=0;
        this.iscollect=0;
    }


}
