package com.zzs.controller;


import com.zzs.common.Constant;
import com.zzs.common.R;
import com.zzs.dao.MediaHistoryDao;
import com.zzs.entity.Doctor;
import com.zzs.entity.Mediahistory;
import com.zzs.entity.Medicalappointment;
import com.zzs.entity.Patient;
import com.zzs.service.IDoctorService;
import com.zzs.service.IMediaHistoryService;
import com.zzs.service.IMedicalappointmentService;
import org.springframework.web.bind.annotation.*;
import redis.clients.jedis.Jedis;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zzs
 * @since 2023-10-14
 */
@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Resource
    private Jedis jedis;

    @Resource
    private IDoctorService doctorService;

    @Resource
    private IMediaHistoryService mediaHistoryService;

    @Resource
    private IMedicalappointmentService medicalappointmentService;

    @GetMapping("/{id}")
    public R<Doctor> getDoctorById(@PathVariable Integer id) {
        return doctorService.getDoctorById(id);
    }

    @GetMapping("/{department}")
    public R<List<Doctor>> getDoctorListByDepartment(@PathVariable String department){

        return doctorService.getDoctorListByDepartment(department);
    }

    /**
     * 修改病历
     * @param mediahistory
     * @return
     */
    @PutMapping("/history}")
    public R<String> updateMediaHistory(@RequestBody Mediahistory mediahistory){
       return mediaHistoryService.updateMediaHistory(mediahistory);
    }


    /***
     * 医生获取病历
     * @param id
     * @return
     */
    @GetMapping("/history/{id}")
    public R<Mediahistory> getMediaHistoryById(@PathVariable Integer id){
        return mediaHistoryService.getMediaHistoryById(id);
    }


    /**
     * 通过医生id获取 预约该医生的所有预约信息
     * @param id 医生id
     * @return
     */
    @GetMapping("/appointment/{id}")
    public R<Medicalappointment> getAllAppointmentById(@PathVariable Integer id){
        return medicalappointmentService.getAllAppointmentById(id);
    }


    /**
     * 登录
     * @param doctor
     * @return
     */

    @PostMapping("/login")
    public R<String> login(@RequestBody Doctor doctor){
        return doctorService.login(doctor.getPhone(),doctor.getPassword());
    }

    /**
     * 退出账号
     * @param token
     * @return
     */
    @PostMapping("/logout")
    public R<String> logout(@RequestBody String token){
        String redis_token=Constant.REDIS_TOKEN_PRE+token;
        Long del = jedis.del(redis_token);
        return R.success("删除成功",del);
    }









}

