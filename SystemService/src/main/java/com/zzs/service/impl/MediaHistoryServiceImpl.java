package com.zzs.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zzs.common.R;
import com.zzs.dao.ArticleDao;
import com.zzs.dao.MediaHistoryDao;
import com.zzs.entity.Article;
import com.zzs.entity.Mediahistory;
import com.zzs.service.IArticleService;
import com.zzs.service.IMediaHistoryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
public class MediaHistoryServiceImpl extends ServiceImpl<MediaHistoryDao, Mediahistory> implements IMediaHistoryService {

    @Resource
    private MediaHistoryDao mediaHistoryDao;
    @Transactional
    @Override
    public R<String> updateMediaHistory(Mediahistory mediahistory) {
        LambdaQueryWrapper<Mediahistory> mediahistoryLambdaQueryWrapper = new LambdaQueryWrapper<>();
        mediahistoryLambdaQueryWrapper.eq(Mediahistory::getID,mediahistory.getID());
        if (Objects.isNull(mediaHistoryDao.selectOne(mediahistoryLambdaQueryWrapper))) {
            return R.err("没有该病例,确定是否有该病例");
        }
//        LambdaUpdateWrapper<Mediahistory> mediahistoryLambdaUpdateWrapper = new LambdaUpdateWrapper<>();
//        mediahistoryLambdaUpdateWrapper.eq(Mediahistory::getID,mediahistory.getID());

        int res_row = mediaHistoryDao.update(mediahistory, mediahistoryLambdaQueryWrapper);
        return R.success("提交成功",res_row);
    }

    @Override
    public R<Mediahistory> getMediaHistoryById(Integer id) {
        LambdaQueryWrapper<Mediahistory> mediahistoryLambdaQueryWrapper = new LambdaQueryWrapper<>();
        mediahistoryLambdaQueryWrapper.eq(Mediahistory::getID,id);
        Mediahistory mediahistory = mediaHistoryDao.selectOne(mediahistoryLambdaQueryWrapper);
        if (Objects.isNull(mediahistory)){
            return R.err("查无此人");
        }
        return R.success("查询成功",mediahistory);
    }
}
