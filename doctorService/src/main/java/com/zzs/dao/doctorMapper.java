package com.zzs.dao;

import com.zzs.Entity.Doctor;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zzs
 * @since 2023-07-16
 */
@Mapper
public interface doctorMapper {
//     @Select("select * from doctor")
    public List<Doctor> getAll();

    @Select("select * from doctor where phone=#{phone}")
    Doctor getByPhone(String phone);


    public Integer add(Doctor doctor);

//    Doctor update(Doctor doctor);
}
