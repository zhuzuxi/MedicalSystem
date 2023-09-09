package com.zzs.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.zzs.Common.R;
import com.zzs.Entity.Doctor;
import com.zzs.Utill.JwtUtil;
import com.zzs.dao.doctorMapper;
import com.zzs.service.IDoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.zzs.Common.Constant.DOCTOR_TOKEN_PRE;
import static com.zzs.Common.Constant.INIT_EXPIRATION;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zzs
 * @since 2023-07-16
 */
@Service
public class DoctorServiceImpl implements IDoctorService {

    @Autowired
    private doctorMapper doctorMapper;

    @Autowired
    private Jedis jedis;

    @Override
    public R login(Doctor doctor, HttpServletResponse response) throws IOException {
        /*
        * 根据手机号查用户
        * 有则进行下一步判断 手机号和密码是否对应
        *
        * */
        Doctor res=doctorMapper.getByPhone(doctor.getPhone());
        if (res==null){
            return R.err("此用户不存在,请注册！");
        }

        if(!doctor.getPassword().equals(res.getPassword())){
            return R.err("密码不正确");
        }
        String token = JwtUtil.createToken(res.getPhone(), res.getPassword());

        response.setHeader("token",token);

        String RedisToken=DOCTOR_TOKEN_PRE+token;
        if (!jedis.exists(RedisToken)){
            jedis.setex(RedisToken, Math.toIntExact(INIT_EXPIRATION), JSONObject.toJSONString(res));
        }

        return R.success("登录成功",res);
    }

    @Override
    public R logout(String token) {
        Long del = jedis.expire(token,0);
        if (del==null){
            return R.err("退出失败");
        }
        return R.success("退出成功",del);
    }

    @Override
    public R registry(Doctor doctor) {
        if(doctor==null){
            return R.err("请重试");
        }
        if (doctor.getPhone()==null || doctor.getPassword()==null){
            R.err("password或phone不能为空");
        }

        if(!(doctor.getPassword().length()>=6)){
            return R.err("密码长度不能小于6");
        }
        int add = doctorMapper.add(doctor);

        return R.success("注册成功",add);
//        if (add){
//
//        }

    }

    @Override
    public R update(Doctor doctor) {
        //TODO 对传入的数据做一些校验
//        doctorMapper.update(doctor);
        return null;
    }

}
