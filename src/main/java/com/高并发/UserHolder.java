package com.高并发;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserHolder {
    // 这里使用static 修饰,会导致存储在 ThreadLocal 对象不会被回收,需要每次用完都 remove
    private static final ThreadLocal<Long> tl = new ThreadLocal<>();

    public static void setUser(Long userId) {
        tl.set(userId);
    }
    public static Long getUser() {
        return tl.get();
    }
    public static void removeUser(){
        tl.remove();
    }
}

