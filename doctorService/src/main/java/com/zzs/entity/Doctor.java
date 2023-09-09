package com.zzs.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

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
public class Doctor implements Serializable {

    private static final long serialVersionUID = 1L;

//    @TableId(value = "ID")
    private String ID;

    private String name;

    private String phone;

    private String password;

    private Integer age;

    private String sex;

    private String position;

    private String department;

    private LocalDateTime worktime;

    private LocalDateTime closingtime;

    public Doctor(){
        this.ID= UUID.randomUUID().toString();
    }


}
