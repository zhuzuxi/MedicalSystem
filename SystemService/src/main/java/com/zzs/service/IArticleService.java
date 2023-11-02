package com.zzs.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zzs.common.R;
import com.zzs.entity.Article;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zzs
 * @since 2023-10-14
 */
public interface IArticleService extends IService<Article> {

    R<Page<Article>> loadPageArticle(Integer pageNum);
    R<String> initArticleModel();

    R<Article> getArticleById(Integer id);

    R<String> deleteArticleById(Integer id);

    R<String> addArticle(Article article);
}
