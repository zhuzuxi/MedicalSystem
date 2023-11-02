package com.zzs.service;

import com.zzs.common.R;
import com.zzs.entity.Medicalappointment;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zzs
 * @since 2023-10-14
 */
public interface IMedicalappointmentService extends IService<Medicalappointment> {

    R subscribe(int doctorId, int patientId);

    R<Medicalappointment> getAllAppointmentById(Integer id);
}
