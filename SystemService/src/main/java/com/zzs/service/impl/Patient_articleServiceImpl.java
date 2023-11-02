package com.zzs.service.impl;

import com.zzs.common.R;
import com.zzs.entity.Patient_article;
import com.zzs.dao.Patient_articleDao;
import com.zzs.service.IPatient_articleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zzs
 * @since 2023-10-14
 */
@Service
public class Patient_articleServiceImpl extends ServiceImpl<Patient_articleDao, Patient_article> implements IPatient_articleService {

    @Resource
    private Patient_articleDao patientArticleDao;
    @Override
    public R<String> like(Integer aid, Integer pid) {

        Patient_article patientArticle = new Patient_article();
        patientArticle.setAid(aid);
        patientArticle.setPid(pid);

        patientArticleDao.insert(patientArticle);
        return R.success("点赞成功","点赞成功");
    }
}
