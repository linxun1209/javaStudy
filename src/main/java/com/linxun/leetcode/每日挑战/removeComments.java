package com.linxun.leetcode.每日挑战;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.每日挑战
 * @date 2023/8/3 12:30
 */
public class removeComments {
    public List<String> removeComments1(String[] source) {

        List<String> res = new ArrayList<>();
        boolean block = false;   //表示当前是否在一个块注释内部
        StringBuilder build = new StringBuilder();
        for (String s : source) {
            int n = s.length();
            for (int i = 0; i < n; i++) {
                char c = s.charAt(i);
                if (!block) {
                    if (c != '/' || i == n - 1) {
                        build.append(c);
                    } else {
                        if (s.charAt(i + 1) == '/') {
                            break;
                        } else if (s.charAt(i + 1) == '*') {
                            block = true;
                            i++;
                        } else {
                            build.append(c);
                        }
                    }
                } else {
                    if (s.charAt(i) == '*') {
                        if (i < n - 1 && s.charAt(i + 1) == '/') {
                            block = false;
                            i++;
                        }
                    }
                }
            }
            if (!block && build.length() > 0) { //本行没有新起的块注释了，即没有隐式换行符了
                res.add(build.toString());
                build = new StringBuilder();
            }
        }
        return res;
    }
}
