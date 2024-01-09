package com.zzs.controller;


import com.zzs.common.R;
import com.zzs.service.IPatientService;
import com.zzs.service.IPatient_articleService;
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
@RequestMapping("/patient_article")
public class Patient_articleController {

    @Resource
    private IPatient_articleService patientArticleService;

    /**
     *
     * @param aid 文章id
     * @param pid 患者id
     * @return
     */
    @GetMapping("/like")
    public R<String> like(@RequestParam Integer aid, @RequestParam Integer pid){
       return patientArticleService.like(aid,pid);
    }

}

