package com.zzs.dao;

import com.zzs.entity.Doctor;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zzs
 * @since 2023-10-14
 */
@Mapper
public interface DoctorDao extends BaseMapper<Doctor> {
    @Select("select * from doctor")
    public List<Doctor> getAll();

    @Select("select * from doctor where phone=#{phone}")
    Doctor getByPhone(String phone);


//    public Integer add(Doctor doctor);

    @Select("select * from doctor where id=#{id}")
    Doctor getById(int id);

//    Doctor update(Doctor doctor);

}
