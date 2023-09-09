package com.zzs.service;

import com.zzs.Common.R;
import com.zzs.Entity.Doctor;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zzs
 * @since 2023-07-16
 */
public interface IDoctorService {

    R login(Doctor doctor, HttpServletResponse response) throws IOException;

    R logout(String token);

    R registry(Doctor doctor);

    R update(Doctor doctor);
}
