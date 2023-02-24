//package com.thymeleaf.handler;
//
//import cn.hutool.json.JSONUtil;
//import com.thymeleaf.result.MessageResult;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.web.authentication.AuthenticationFailureHandler;
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
//public class LoginFailureHandler implements AuthenticationFailureHandler {
//    @Override
//    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
//            response.setContentType("application/json;charset=UTF-8");
//            ServletOutputStream outputStream = response.getOutputStream();
//        response.sendRedirect("/abc");
//        MessageResult result =new MessageResult();
//        result.fail("Username or password incorrect!");
//
//        outputStream.write(JSONUtil.toJsonStr(result).getBytes(StandardCharsets.UTF_8));
//        outputStream.flush();
//        outputStream.close();
//    }
//}
