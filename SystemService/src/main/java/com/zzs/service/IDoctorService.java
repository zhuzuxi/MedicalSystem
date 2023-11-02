package com.zzs.service;

import com.zzs.common.R;
import com.zzs.entity.Doctor;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zzs
 * @since 2023-10-14
 */
public interface IDoctorService extends IService<Doctor> {


    R<Doctor> getDoctorById(Integer id);

    R<List<Doctor>> getDoctorListByDepartment(String department);

    R<String> login(String username, String password);

    R<String> deleteDoctorById(Integer id);

    R<String> addDoctor(Doctor doctor);

    R<String> updateDoctorById(Doctor doctor);
}
