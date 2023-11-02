package com.zzs.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.zzs.Utill.JwtUtil;
import com.zzs.common.Constant;
import com.zzs.common.R;
import com.zzs.entity.Doctor;
import com.zzs.dao.DoctorDao;
import com.zzs.service.IDoctorService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import redis.clients.jedis.Jedis;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;
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
public class DoctorServiceImpl extends ServiceImpl<DoctorDao, Doctor> implements IDoctorService {

    @Resource
    private DoctorDao doctorDao;

    @Resource
    private Jedis jedis;
    @Override
    public R<Doctor> getDoctorById(Integer id) {
        Doctor doctor = doctorDao.getById(id);
        if (Objects.isNull(doctor)){
            return R.err("查无此人，请输入正确的id");
        }
        return R.success("查询成功",doctor);
    }

    @Override
    public R<List<Doctor>> getDoctorListByDepartment(String department) {
        LambdaQueryWrapper<Doctor> doctorLambdaQueryWrapper = new LambdaQueryWrapper<>();
        doctorLambdaQueryWrapper.eq(Doctor::getDepartment,department);
        List<Doctor> doctors = doctorDao.selectList(doctorLambdaQueryWrapper);
        if (doctors.size()==0){
            return R.err("网络异常，请重试");
        }
        return R.success("查询成功",doctors);
    }

    @Override
    public R<String> login(String phone, String password) {

        LambdaQueryWrapper<Doctor> doctorLambdaQueryWrapper = new LambdaQueryWrapper<Doctor>().eq(Doctor::getPhone, phone)
                                                                                                .eq(Doctor::getPassword, password);
        Doctor doctor = doctorDao.selectOne(doctorLambdaQueryWrapper);

        if (Objects.isNull(doctor)){
            R.err("电话或密码错误，请检查后重试");
        }

        String token = JwtUtil.createToken(phone, password);
        jedis.setex(Constant.REDIS_TOKEN_PRE+token, Math.toIntExact(Constant.INIT_EXPIRATION),token);

        return R.success("登录成功",token);
    }

    @Transactional
    @Override
    public R<String> deleteDoctorById(Integer id) {
        doctorDao.deleteById(id);
        return R.success("删除成功","删除成功");
    }

    @Transactional
    @Override
    public R<String> addDoctor(Doctor doctor) {
        doctorDao.insert(doctor);
        return R.success("增加成功","增加成功");
    }

    @Transactional
    @Override
    public R<String> updateDoctorById(Doctor doctor) {
        LambdaQueryWrapper<Doctor> query = new LambdaQueryWrapper<>();
        query.eq(Doctor::getId,doctor.getId());
        doctorDao.update(doctor,query);
        return R.success("更改成功","更改成功");
    }


}
