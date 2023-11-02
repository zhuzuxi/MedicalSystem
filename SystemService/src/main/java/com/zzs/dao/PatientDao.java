package com.zzs.dao;

import com.zzs.entity.Patient;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zzs
 * @since 2023-10-14
 */
@Mapper
public interface PatientDao extends BaseMapper<Patient> {

}
