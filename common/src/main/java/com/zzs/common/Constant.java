package com.zzs.common;

public class Constant {
    public static final Long INIT_EXPIRATION = (Long) (3600L*1000*24*7);//单位为毫秒 token的有效时长 7天
    public static final Long DELAY_EXPIRATION = 3600L*24*10;//单位为秒 token的有效时长 续期3天

    public static final String REDIS_HASHMAP_ARTICLE_KEY="article";

    public static final String REDIS_TOKEN_PRE="token:" ;

    public static final Integer DEFAULT_ARTICLE_PAGE_SIZE=10;

    public static final String REDIS_ARTICLE_ID_PRE="article:id:";




}
