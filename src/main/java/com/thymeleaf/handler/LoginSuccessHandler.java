//package com.thymeleaf.handler;
//
//import cn.hutool.json.JSONUtil;
//import com.thymeleaf.result.MessageResult;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
//import org.springframework.stereotype.Component;
//
//import javax.servlet.ServletException;
//import javax.servlet.ServletOutputStream;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.nio.charset.StandardCharsets;
//
//@Component
//public class LoginSuccessHandler implements AuthenticationSuccessHandler {
//    @Override
//    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
//        response.setContentType("application/json;charset=UTF-8");
//        MessageResult result =new MessageResult().success("Login success");
//
//        ServletOutputStream outputStream = response.getOutputStream();
//
//        outputStream.write(JSONUtil.toJsonStr(result).getBytes(StandardCharsets.UTF_8));
//
//        outputStream.flush();
//        outputStream.close();
//    }
//}
