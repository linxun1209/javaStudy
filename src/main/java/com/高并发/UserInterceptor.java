package com.高并发;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 前置逻辑校验
         UserHolder.setUser(1l);
        // 放行
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
      // 因为Tomcat 有线程池,多个线程会公用同一个 变量,为防止内存泄漏,使用完毕后 需要清理
        UserHolder.removeUser();
    }
}