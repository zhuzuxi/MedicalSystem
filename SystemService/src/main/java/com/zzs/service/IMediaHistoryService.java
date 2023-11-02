package com.zzs.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zzs.common.R;
import com.zzs.entity.Article;
import com.zzs.entity.Mediahistory;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zzs
 * @since 2023-10-14
 */
public interface IMediaHistoryService extends IService<Mediahistory> {

    R<String> updateMediaHistory(Mediahistory mediahistory);

    R<Mediahistory> getMediaHistoryById(Integer id);
}
