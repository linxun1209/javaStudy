package com.面试中的算法.美团.美团8_10第一次笔试;

import java.util.*;

/**
 * @author xing'chen
 * @version 1.0
 * @description: TODO
 * @date 2024/8/17 17:46
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        String ans = scanner.next();//正确答案
        //小美不会重新尝试已经尝试过的字符串。
        //所以用Set<Integer>
        Map<Integer, Set<String>> pos=new HashMap<>();
        for (int i=0;i<n;i++){
            String p = scanner.next();
            pos.computeIfAbsent(p.length(),k->new HashSet<>()).add(p);
        }
        List<Map.Entry<Integer,Set<String>>> sortedPos=new ArrayList<>(pos.entrySet());
        sortedPos.sort(Map.Entry.comparingByKey());
        int step=0;
        int min=-1,Max=-1;
        for (Map.Entry<Integer,Set<String>> entry:sortedPos){
            Set<String> value = entry.getValue();
            if(value.contains(ans)){
                min=step+1;
                Max=step+value.size();
            }else {
                step+=value.size();
            }
        }
        System.out.printf(min+" "+Max);
        scanner.close();

    }

}

