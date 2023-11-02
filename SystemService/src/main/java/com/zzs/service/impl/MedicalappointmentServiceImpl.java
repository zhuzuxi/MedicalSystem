package com.zzs.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zzs.common.R;
import com.zzs.dao.*;
import com.zzs.entity.Doctor;
import com.zzs.entity.Medicalappointment;
import com.zzs.entity.Patient;
import com.zzs.service.IMedicalappointmentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zzs
 * @since 2023-10-14
 */
@Service
public class MedicalappointmentServiceImpl extends ServiceImpl<MedicalappointmentDao, Medicalappointment> implements IMedicalappointmentService {

    @Resource
    private DoctorDao doctorDao;

    @Resource
    private MedicalappointmentDao medicalappointmentDao;

    @Resource
    private PatientDao patientDao;
    @Override
    public R subscribe(int doctorId, int patientId) {
        //可以先返回提交预约成功 提示预约成功将返回预约信息
        //然后发送消息队列 异步去进行实际的预约的逻辑
        LambdaQueryWrapper<Doctor> doctorLambdaQueryWrapper = new LambdaQueryWrapper<>();
        doctorLambdaQueryWrapper.eq(Doctor::getId,doctorId);
        Doctor doctor = doctorDao.selectOne(doctorLambdaQueryWrapper);

        AtomicInteger Remaining_reservation = new AtomicInteger(doctor.getRemaining_reservation());
        if (Remaining_reservation.get()<=0){
            return R.err("没有预约名额了");
        }

        //预约名额减少
        Remaining_reservation.decrementAndGet();
        LambdaUpdateWrapper<Doctor> doctorUpdateRemaining_reservation = new LambdaUpdateWrapper<>();
        doctorUpdateRemaining_reservation.set(Doctor::getRemaining_reservation,Remaining_reservation.get());
        doctorDao.update(doctor,doctorUpdateRemaining_reservation);



//      数据填充
        LambdaQueryWrapper<Patient> patientByIdQuery = new LambdaQueryWrapper<>();
        patientByIdQuery.eq(Patient::getId,patientId);
        Patient patient = patientDao.selectOne(patientByIdQuery);
        Medicalappointment medicalappointment=new Medicalappointment(doctor,patient);

        //插入预约表
        medicalappointmentDao.insert(medicalappointment);

        return R.success("预约成功",medicalappointment.getReservation_id());
    }


    /**
     * 获取今天的预约列表
     * @param id 医生id
     * @return
     */
    @Override
    public R<Medicalappointment> getAllAppointmentById(Integer id) {
        LambdaQueryWrapper<Medicalappointment> query = new LambdaQueryWrapper<>();
        query.eq(Medicalappointment::getDoctor_id,id).apply("DATE_FORMAT(appointment_datetime, '%Y-%m-%d') = {0}", LocalDate.now());
        List<Medicalappointment> medicalappointments = medicalappointmentDao.selectList(query);
        if (Objects.isNull(medicalappointments)){
            return R.err("查询失败");
        }
        if (medicalappointments.size()==0){
            return R.success("暂时无人预约",medicalappointments);
        }

        return R.success("查询成功",medicalappointments);
    }
}
