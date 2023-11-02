package com.zzs.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
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
public class Patient implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;


    private String name;

    /**
     * 手机号 与病历号关联
     */
    private String phone;

    private String password;

    private Integer age;

    private String address;

    /**
     * 身份证号 与病历号关联
     */
    private String identificationcard;

    private LocalDateTime last_visit;


}
