package com.zzs.controller;


import com.zzs.common.R;
import com.zzs.service.IMedicalappointmentService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zzs
 * @since 2023-10-14
 */
@RestController
@RequestMapping("/medicalappointment")
public class MedicalappointmentController {
    @Resource
    private IMedicalappointmentService medicalappointmentService;

    @PostMapping("/subscribe")
    public R subscribe(@RequestParam int doctor_id, @RequestParam int patient_id){
        return medicalappointmentService.subscribe(doctor_id,patient_id);
    }


}

