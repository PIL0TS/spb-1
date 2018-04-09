package com.tream.utils;

import com.tream.common.result.GlobalErrorInfoEnum;
import com.tream.common.result.GlobalErrorInfoException;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 渲染工具类
 */
public class RenderUtil {

    /**
     * 渲染 json 对象
     */
    public static void randerJson (HttpServletResponse response, Object jsonObject){

        try {
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            PrintWriter writer = response.getWriter();
            writer.write(jsonObject.toString());
            //跨域设置
            response.addHeader("Access-Control-Allow-Origin", "*");
            response.addHeader("Access-Control-Allow-Methods",
                    "GET, POST, PUT, DELETE, OPTIONS");
            response.addHeader("Access-Control-Allow-Headers",
                    "*");

        } catch (IOException e) {
            throw new GlobalErrorInfoException(GlobalErrorInfoEnum.WRITE_ERROR);
        }





    }

}
