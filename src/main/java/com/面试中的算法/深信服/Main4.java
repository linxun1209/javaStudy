//package com.面试中的算法.深信服;
//
//import java.util.Scanner;
//
///**
// * @author xing'chen
// * @version 1.0
// * @description: TODO
// * @date 2024/8/18 20:31
// */
//public class Main4 {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n=in.nextInt();
//        int m=in.nextInt();
//        in.nextLine();
//        String[][] fireString=new String[n][6];
//        for (int i = 0; i < n; i++) {
//            fireString[i]=in.nextLine().split(" ");
//        }
//        for (int i = 0; i < m; i++) {
//            String[] request=in.nextLine().split(" ");
//            boolean flag=false;
//            for (int j = 0; j < n; j++) {
//                if(isMatch(fireString[j],request)){
//                    flag=true;
//                    break;
//                }
//            }
//        }
//    }
//
//
//
//    private static boolean ipMatch(String s1,String s2){
//        if(s1.equals("0.0.0.0")){
//            return true;
//        }
//        return s1.equals(s2);
//    }
//
//    private static boolean isPort(String port1,String port2){
//        if(port2.contains("-")){
//            String[] ports=port2.split("-");
//            int start=Integer.parseInt(ports[0]);
//            int end=Integer.parseInt(ports[1]);
//            int protNum=Integer.parseInt(port1);
//            return start<=protNum&&protNum<=end;
//        }
//        return port1.equals(port2);
//    }
//
//
//
//
//
//    private static boolean isMatch(String[] strings, String[] request) {
//        return ipMatch(request[0],String[0]&&isPort(request[1],String[1]))
//    }
//}
//
