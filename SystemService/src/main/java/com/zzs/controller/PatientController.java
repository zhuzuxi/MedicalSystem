package com.zzs.controller;


import com.zzs.common.R;
import com.zzs.entity.Patient;
import com.zzs.service.IPatientService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

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
@RequestMapping("/patient")
public class PatientController {

    @Resource
    private IPatientService patientService;

    @GetMapping("/{id}")
    public R<Patient> getPatientById(Integer id){
        return patientService.getPatientById(id);
    }





}

