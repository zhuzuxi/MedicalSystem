package com.zzs.entity;

import com.baomidou.mybatisplus.annotation.IdType;

import java.time.LocalDateTime;
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
public class Doctor implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private int id;

    private String name;

    /**
     * 用于登录的账号
     */
    private String phone;

    private String password;

    private Integer age;

    private String sex;

    private String position;

    private String department;

    private LocalDateTime worktime;

    private LocalDateTime closingtime;

    private Integer remaining_reservation;


}
