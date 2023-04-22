package com.并发.Test;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.并发.Test
 * @date 2023/4/21 13:29
 */
public class IteratorTest {
    public static void main(String[] args) {
        CopyOnWriteArrayList<String> arrayList=new CopyOnWriteArrayList<>();
        arrayList.add("hello");
        arrayList.add("abbbb");
        Iterator<String> iterator=arrayList.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }





        }
}
