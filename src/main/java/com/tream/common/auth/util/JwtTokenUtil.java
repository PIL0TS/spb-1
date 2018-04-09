package com.tream.common.auth.util;

import com.tream.common.config.properties.JwtProperties;
import com.tream.utils.ToolUtil;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


/**
 * jwt token 工具类
 *
 *      jwt 的 claim 里一般包含以下几种数据：
 *          1.  iss -- token 的发行者
 *          2.  sub -- 该token 所面向的用户
 *          3.  aud -- 接受该 jwt 的一方
 *          4.  exp -- token 的失效时间
 *          5.  nbf -- 在此时间段之前，不会被处理
 *          6.  iat -- jwt的发布时间
 *          7.  jti -- jwt唯一标志，防止重复使用
 */


@Component
public class JwtTokenUtil {

    @Autowired
    JwtProperties jwtProperties = new JwtProperties();


    /**
     * 从token中获取用户名
     */
    public String getUserNameFromToken (String token) {
        return getClaimFromToken(token).getSubject();
    }


    /**
     * 获取 jwt 发布时间
     */
    public Date getIssuedDateFromToken (String token) {
        return getClaimFromToken(token).getIssuedAt();
    }


    /**
     * 获取 jwt 失效时间
     */
    public Date getExpirationFromToken (String token) {
        return getClaimFromToken(token).getExpiration();
    }


    /**
     *  获取 jwt 接受者
     */
    public String getAudienceFromToken (String token) {
        return getClaimFromToken(token).getAudience();
    }


    /**
     * 获取私有的 jwt claim
     */
    public String getPrivateClaimFromToken (String token, String key) {
        return getClaimFromToken(token).get(key).toString();
    }


    /**
     * 从 token 中获取 md5 key
     */
    public String getMd5KeyFromToken (String token) {
        return getPrivateClaimFromToken(token, jwtProperties.getMd5Key());
    }

    /**
     * 获取 jwt 的 payload 部分
     */
    public Claims getClaimFromToken (String token) {

        return Jwts.parser()
                .setSigningKey(jwtProperties.getSecret())
                .parseClaimsJws(token)
                .getBody();

    }


    /**
     * 解析token，不正确会报异常
     */
    public void parseToken (String token) throws JwtException {
        Jwts.parser().setSigningKey(jwtProperties.getSecret()).parseClaimsJws(token).getBody();
    }


    /**
     * token 是否失效
     * true ： 过期      false ： 没过期
     */
    public Boolean isTokenExpired (String token) {
        final Date expiration = getExpirationFromToken(token);
        return expiration.before(new Date());
    }

    /**
     * 生成token（通过用户名和签名时候用的随机数）
     */
    public String generateToken (String userName, String randomKey) {
        Map<String, Object> claims = new HashMap<String, Object>();
        claims.put(jwtProperties.getMd5Key(), randomKey);
        return  doGenerate(claims, userName);
    }

    /**
     * 生成token
     */
    public String doGenerate (Map<String, Object> claims, String subject) {
        final Date createDate = new Date();
        final Date expirationDate = new Date(createDate.getTime() + jwtProperties.getExpiration() * 1000);

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(createDate)
                .setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS512, jwtProperties.getSecret())
                .compact();
    }

    /**
     * 获取混淆MD5签名用的随机字符串
     */
    public String getRandomKey () {
        return ToolUtil.getRandomString(6);
    }



}
