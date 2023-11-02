package com.zzs.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zzs.common.R;
import com.zzs.entity.Article;
import com.zzs.service.IArticleService;
import com.zzs.service.impl.ArticleServiceImpl;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zzs
 * @since 2023-10-14
 */
@RestController
@RequestMapping("/article")
public class ArticleController {

    @Resource
    private IArticleService articleService;

    /**
     * 按时间倒序 通过页数 获得页
     * @param pageNum
     * @return
     */
    @GetMapping("/list")
    public R<Page<Article>> loadPageArticle(@RequestParam(defaultValue = "1") Integer pageNum ){
        return articleService.loadPageArticle(pageNum);
    }

    @GetMapping("/init")
    public R<String> initArticleModel(){
        return articleService.initArticleModel();
    }


    @GetMapping("/{id}")
    public R<Article> getArticleById(@PathVariable Integer id){
        return articleService.getArticleById(id);
    }


}

