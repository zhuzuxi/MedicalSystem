package com.zzs.Entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.Version;
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
 * @since 2023-07-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Patient implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "ID", type = IdType.AUTO)
    private Integer ID;

    private String name;

    /**
     * 手机号 与病历号关联
     */
    private String phone;

    private Integer age;

    private String address;

    /**
     * 身份证号 与病历号关联
     */
    private String identificationcard;

    private LocalDateTime last_visit;


}
