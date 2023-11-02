package com.zzs.service.impl;

import com.zzs.common.R;
import com.zzs.entity.Patient;
import com.zzs.dao.PatientDao;
import com.zzs.service.IPatientService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zzs
 * @since 2023-10-14
 */
@Service
public class PatientServiceImpl extends ServiceImpl<PatientDao, Patient> implements IPatientService {

    @Resource
    private PatientDao patientDao;
    @Override
    public R<Patient> getPatientById(Integer id) {
        Patient patient = patientDao.selectById(id);
        if (Objects.isNull(patient)){
            return R.err("查无此人");
        }
        return R.success("查询成功",patient);
    }


}
