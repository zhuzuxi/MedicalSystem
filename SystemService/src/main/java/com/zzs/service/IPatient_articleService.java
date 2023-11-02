package com.zzs.service;

import com.zzs.common.R;
import com.zzs.entity.Patient_article;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zzs
 * @since 2023-10-14
 */
public interface IPatient_articleService extends IService<Patient_article> {

    R<String> like(Integer aid, Integer pid);
}
