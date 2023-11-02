package com.zzs.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zzs.common.Constant;
import com.zzs.common.R;
import com.zzs.entity.Article;
import com.zzs.dao.ArticleDao;
import com.zzs.service.IArticleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;

import javax.annotation.Resource;
import javax.swing.plaf.PanelUI;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
public class ArticleServiceImpl extends ServiceImpl<ArticleDao, Article> implements IArticleService {

    @Resource
    private ArticleDao articleDao;

    /**
     * 将该3天内 likes 最高的前100个文章加入到redis中 初始化
     */
    
    @Resource
    private Jedis jedis;


    public R<String> initArticleModel(){
        LocalDateTime threedayago = LocalDateTime.now().minusDays(3);
        LambdaQueryWrapper<Article> query = new LambdaQueryWrapper<>();
        query.ge(Article::getCreate_datetime,threedayago).orderByDesc(Article::getLikes).last("limit 100");
        List<Article> articles = articleDao.selectList(query);

        HashMap<String, String> map = new HashMap<>();
        for (Article article : articles) {
            String article_id=Constant.REDIS_ARTICLE_ID_PRE+article.getArtical_id();
            String article_json= JSON.toJSONString(article);
            map.put(article_id,article_json);
        }
        Pipeline pipelined = jedis.pipelined();
        for (Map.Entry<String,String> entry : map.entrySet()){
            pipelined.hset(Constant.REDIS_HASHMAP_ARTICLE_KEY,entry.getKey(),entry.getValue());
        }
        pipelined.sync();
        pipelined.close();
        return R.success("加载完成",null);
    }

    @Override
    public R<Article> getArticleById(Integer id) {
        String redis_article_field=Constant.REDIS_ARTICLE_ID_PRE+id;
        String article_json = jedis.hget(Constant.REDIS_HASHMAP_ARTICLE_KEY, redis_article_field);
        if (!article_json.isEmpty()){
            Article article = JSON.parseObject(article_json, Article.class);
            return R.success("查询成功",article);
        }
        LambdaQueryWrapper<Article> query = new LambdaQueryWrapper<>();
        query.eq(Article::getArtical_id,id);
        Article article = articleDao.selectOne(query);
        if (Objects.isNull(article)){
            return R.err("查无此文章，请刷新重试");
        }
        return R.success("查询成功",article);
    }

    @Transactional
    @Override
    public R<String> deleteArticleById(Integer id) {
        articleDao.deleteById(id);
        return R.success("删除成功","删除成功");
    }

    @Transactional
    @Override
    public R<String> addArticle(Article article) {
        articleDao.insert(article);
        return R.success("增加成功","增加成功");
    }

    /**
     * 进入到文章模块先调用这个函数
     * 根据当前时间降序、likes降序或得文章页面内容
     * @param pageNum
     * @return
     */
    @Override
    public R<Page<Article>> loadPageArticle(Integer pageNum) {
        LambdaQueryWrapper<Article> query = new LambdaQueryWrapper<>();
        query.orderByDesc(Article::getCreate_datetime).orderByDesc(Article::getLikes);
        Page<Article> page = new Page<>(pageNum, Constant.DEFAULT_ARTICLE_PAGE_SIZE);
        Page<Article> articlePage = articleDao.selectPage(page, query);
        return R.success("查询成功", articlePage);
    }



}
