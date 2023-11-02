package com.zzs.controller;


import com.zzs.common.R;
import com.zzs.entity.Article;
import com.zzs.entity.Doctor;
import com.zzs.service.IArticleService;
import com.zzs.service.IDoctorService;
import com.zzs.service.IPatientService;
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
@RequestMapping("/medicaladmin")
public class MedicaladminController {
    @Resource
    private IDoctorService doctorService;

    @Resource
    private IPatientService patientService;

    @Resource
    private IArticleService articleService;

    @DeleteMapping("/doctor/{id}")
    public R<String> deleteDoctorById(@PathVariable Integer id){
        return doctorService.deleteDoctorById(id);
    }

    @PostMapping("/doctor")
    public R<String> addDoctor(@RequestBody Doctor doctor){
        return doctorService.addDoctor(doctor);
    }

    @PutMapping("/doctor")
    public R<String> updateDoctorById(@RequestBody Doctor doctor){
        return doctorService.updateDoctorById(doctor);
    }


    @DeleteMapping("/article/{id}")
    public R<String> deleteArticleById(@PathVariable Integer id){
        return articleService.deleteArticleById(id);
    }

    @PostMapping("/article")
    public R<String> addArticle(@RequestBody Article article){
        return articleService.addArticle(article);
    }
}

