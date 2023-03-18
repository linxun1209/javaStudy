package com.集合源码.set;

import java.util.HashSet;
import java.util.Set;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.集合源码.set
 * @date 2022/10/20 16:33
 */
@SuppressWarnings({"all"})
public class HashSet_ {
    public static void main(String[] args) {
//老韩解读
//1. 构造器走的源码
/*
public HashSet() {
map = new HashMap<>();
}2. HashSet 可以存放 null ,但是只能有一个 null,即元素不能重复
*/
        Set hashSet = new HashSet();
        hashSet.add(null);
        hashSet.add(null);
        System.out.println("hashSet=" + hashSet);
    }
}
