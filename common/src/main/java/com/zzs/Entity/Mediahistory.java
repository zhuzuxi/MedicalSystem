package com.zzs.Entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.Version;
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
 * @since 2023-07-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Mediahistory implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 病历ID
     */
    @TableId(value = "ID", type = IdType.AUTO)
    private Integer ID;

    /**
     * 患者ID
     */
    private String PID;

    private String name;

    private String phone;

    /**
     * 家庭住址
     */
    private String address;

    private String identificationcard;

    /**
     * 病历内容
     */
    private String content;


}
