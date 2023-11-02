package com.zzs.service;

import com.zzs.common.R;
import com.zzs.entity.Patient;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zzs
 * @since 2023-10-14
 */
public interface IPatientService extends IService<Patient> {
    R<Patient> getPatientById(Integer id);

}
