package com.tream.common.auth.filter;

import com.tream.common.auth.util.JwtTokenUtil;
import com.tream.common.config.properties.JwtProperties;
import com.tream.common.result.GlobalErrorInfoEnum;
import com.tream.common.tips.ErrorTip;
import com.tream.utils.RenderUtil;
import io.jsonwebtoken.JwtException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Order(1)
@WebFilter(urlPatterns = "/*")
public class AuthFilter extends OncePerRequestFilter{

    Logger log = LoggerFactory.getLogger(this.getClass());

    /**
     * 对客户端请求的jwt token验证过滤器
     * @param httpServletRequest
     * @param httpServletResponse
     * @param filterChain
     * @throws ServletException
     * @throws IOException
     */

    @Autowired
    JwtProperties jwtProperties;
    @Autowired
    JwtTokenUtil jwtTokenUtil;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {


        System.out.println("AuthFilter--" + request.getServletPath());
//TODO        if (request.getServletPath().equals("/" + jwtProperties.getAuthPath())) {
        if (true) {

            filterChain.doFilter(request, response);

            return;
        }

        final String requestHeader = request.getHeader(jwtProperties.getHeader());
        System.out.println(requestHeader);
        String authToken = null;
        if (requestHeader != null && requestHeader.startsWith("token ")) {
            authToken = requestHeader.substring(6);

            //验证token是否过期，包含了验证jwt是否正确
            try {
                System.out.println(authToken);
                boolean flag = jwtTokenUtil.isTokenExpired(authToken);

                if (flag) {
                    RenderUtil.randerJson(response, new ErrorTip(GlobalErrorInfoEnum.TOKEN_ERROR.getCode(), GlobalErrorInfoEnum.TOKEN_ERROR.getMessage()));
                    return;
                }
            } catch (JwtException e) {
                //有异常就是token接信息失败了
                RenderUtil.randerJson(response, new ErrorTip(GlobalErrorInfoEnum.TOKEN_ERROR.getCode(), GlobalErrorInfoEnum.TOKEN_ERROR.getMessage()));
                return;
            }
        } else {
            //header 没有bearer 字段
            RenderUtil.randerJson(response, new ErrorTip(GlobalErrorInfoEnum.TOKEN_ERROR.getCode(), GlobalErrorInfoEnum.TOKEN_ERROR.getMessage()));
            return;
        }

        filterChain.doFilter(request, response);
    }
}
