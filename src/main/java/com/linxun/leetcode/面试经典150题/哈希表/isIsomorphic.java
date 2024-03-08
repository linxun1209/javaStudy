package com.linxun.leetcode.面试经典150题.哈希表;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xing'chen
 * @version 1.0
 * @description: 205. 同构字符串
 * @date 2024/3/8 23:51
 */
public class isIsomorphic {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map1 = new HashMap<>();
        Map<Character, Character> map2 = new HashMap<>();
        for(int i=0,j=0;i<s.length();i++,j++){
            if (!map1.containsKey(s.charAt(i))) {
                map1.put(s.charAt(i), t.charAt(j)); // map1保存 s[i] 到 t[j]的映射
            }
            if (!map2.containsKey(t.charAt(j))) {
                map2.put(t.charAt(j), s.charAt(i)); // map2保存 t[j] 到 s[i]的映射
            }
            if(map1.get(s.charAt(i))!=t.charAt(j)||map2.get(t.charAt(j))!=s.charAt(i)){
                return false;
            }
        }
        return true;
    }



    public boolean isIsomorphic2(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }

        HashMap<Character, Character> map = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            if(!map.containsKey(s.charAt(i))){
                if(map.containsValue(t.charAt(i))){
                    return false;
                }
                map.put(s.charAt(i), t.charAt(i));
            }else{
                if(map.get(s.charAt(i))!=t.charAt(i)){
                    return false;
                }
            }
        }

        return true;
    }


    public boolean isIsomorphic3(String s, String t) {
        for(int i = 0; i < s.length(); i++){
            if(s.indexOf(s.charAt(i)) != t.indexOf(t.charAt(i))){
                return false;
            }
        }
        return true;
    }

}

