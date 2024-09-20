package com.面试中的算法.去哪儿.去哪儿2023春招;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author xing'chen
 * @version 1.0
 * @description: TODO
 * @date 2024/9/6 19:10
 */
public class Main6 {

    public static String result="";
    public static List<String> myString=new ArrayList<>();
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        List<String> ans=new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ans.add(scanner.next());
        }
        int[] used=new int[n];
        backTracking(ans,0,used,new StringBuilder(),new ArrayList<>());
        for (String s:args){

        }
    }

    private static void backTracking(List<String> strings, int level, int[] used, StringBuilder sb, List list) {
        if (level == strings.size()) {
            if (result == "") {
                result = sb.toString();
                myString = new ArrayList<>(list);
            } else {
                myString =
                        sb.toString().compareTo(result)
                                < 0 ? new ArrayList<>(list) : myString;
                result = sb.toString().compareTo(result)
                        < 0 ? sb.toString() : result;
            }
            return;
        }
        for (int i = 0; i < strings.size(); i++) {
            if (i > 0 && used[i - 1] == 0 &&
                    strings.get(i - 1).compareTo(strings.get(i)) < 0) {
                continue;
            }
            if (used[i] == 0) {
                used[i] = 1;
                sb.append(strings.get(i));
                list.add(strings.get(i));
                backTracking(strings, level + 1, used, sb, list);
                sb.delete(sb.length() - strings.get(i).length(), sb.length());
                list.remove(list.size() - 1);
                used[i] = 0;
            }
        }
    }

}

