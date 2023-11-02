package com.zzs.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.Date;

import com.zzs.common.AppointmentFee;
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
public class Medicalappointment implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "reservation_id", type = IdType.AUTO)
    private Integer reservation_id;

    private Integer doctor_id;

    private Integer patient_id;

    /**
     * 对应门诊类型
     */
    private String appointment_type;

    private Float appointment_fee;

    /**
     * 预约创建时间
     */
    private LocalDateTime appointment_datetime;

    public Medicalappointment(Doctor doctor,Patient patient){
        this.doctor_id=doctor.getId();
        this.patient_id=patient.getId();
        this.appointment_type=doctor.getDepartment();
        this.appointment_fee=5.0f;//假数据
        appointment_datetime= LocalDateTime.now();
    }



}
