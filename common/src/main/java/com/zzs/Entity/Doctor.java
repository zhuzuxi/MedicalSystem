package com.zzs.Entity;

import com.alibaba.fastjson2.util.UUIDUtils;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Doctor doctor = (Doctor) o;
        return ID.equals(doctor.ID) && name.equals(doctor.name) && phone.equals(doctor.phone) && password.equals(doctor.password) && Objects.equals(age, doctor.age) && Objects.equals(sex, doctor.sex) && Objects.equals(position, doctor.position) && Objects.equals(department, doctor.department) && Objects.equals(worktime, doctor.worktime) && Objects.equals(closingtime, doctor.closingtime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, name, phone, password, age, sex, position, department, worktime, closingtime);
    }
    
}
