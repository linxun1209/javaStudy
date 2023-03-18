package com.xingchen.zhengze;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.xingchen
 * @date 2022/8/30 20:12
 */
public class StartEnd {
    public static void main(String[] args) {
        // 创建一个Pattern对象，并用它建立一个Matcher对象
        String regStr = "Java is very easy!";
        System.out.println("目标字符串是：" + regStr);
        Matcher m = Pattern.compile("\\w+").matcher(regStr);
        while (m.find()) {
            System.out.println(m.group() + "子串的起始位置：" + m.start() + "，其结束位置：" + m.end());
        }
    }
}
