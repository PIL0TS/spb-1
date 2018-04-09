package com.tream.jwt;

import com.tream.common.auth.util.JwtTokenUtil;
import org.junit.runner.RunWith;

import java.util.HashMap;
import java.util.Map;

public class GenerateTest {

    public void jwtGenerateTest () {
        JwtTokenUtil tokenUtil = new JwtTokenUtil();
        Map<String, Object> map = new HashMap<String, Object>();

        String token = tokenUtil.doGenerate(map,"test01");
        System.out.println(token);
        /**
         *
         * eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ0ZXN0MDEiLCJleHAiOjE1MTg1MDIxNzksImlhdCI6MTUxNzg5NzM3OX0.QnEl6KJY0gKymheJwupgTfbEhiOR1-SjWqjKGr-eGvWWEyI-9zmMFz9ebkGcCbjybEbqTLDtdYCy9A2a62GC3w
         * eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ0ZXN0MDEiLCJleHAiOjE1MTg1MDIyMTksImlhdCI6MTUxNzg5NzQxOX0.JJxOBBWfrHQB-jy_GT6C9DXRPiANJ0SsPOkJ3uvZ4TULn5Eg6_d60arFFiare_pvCI_We3uVegtH8gHJd31i9g

         */
    }
}
