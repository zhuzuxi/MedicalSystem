package com.zzs.Utill;
 
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static com.zzs.Common.Constant.*;

/**
 * @description: Jwt工具类，生成JWT和认证
 * @author: zzs
 */
public class JwtUtil {
 
    private static final Logger logger = LoggerFactory.getLogger(JwtUtil.class);
    /**
     * 密钥
     */
    private static final String SECRET = "13119571904";
 
    /**
     * 过期时间
     **/
    /**
     * 生成用户token,设置token超时时间
     */
    public static String createToken(String phone,String password ) {
        //过期时间
        Date expireDate = new Date(System.currentTimeMillis() + INIT_EXPIRATION * 1000 * 24 * 30);//30天
        Map<String, Object> map = new HashMap<>();
        map.put("alg", "HS256");
        map.put("typ", "JWT");
        String token = JWT.create()
                .withHeader(map)// 添加头部
                //可以将基本信息放到claims中
//                .withClaim("id", user.getId())//userId
                .withClaim("phone", phone)//userName
                .withClaim("password", password)//password
                .withExpiresAt(expireDate) //超时设置,设置过期的日期
                .withIssuedAt(new Date()) //签发时间
                .sign(Algorithm.HMAC256(SECRET)); //SECRET加密
        return token;
    }
 
    /**
     * 校验token并解析token
     */
    public static Map<String, Claim> verifyToken(String token) {
        DecodedJWT jwt = null;
        try {
            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(SECRET)).build();
            jwt = verifier.verify(token);
 
            //decodedJWT.getClaim("属性").asString()  获取负载中的属性值
 
        } catch (Exception e) {
            logger.error(e.getMessage());
            logger.error("token解码异常");
            //解码异常则抛出异常
            return null;
        }
        return jwt.getClaims();
    }
 
}