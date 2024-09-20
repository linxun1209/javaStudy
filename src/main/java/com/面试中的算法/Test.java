//package com.面试中的算法;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
///**
// * @author xing'chen
// * @version 1.0
// * @description: TODO
// * @date 2024/9/13 10:10
// */
//public class Test {
//    public static void main(String[] args) {
//        List<String> test = new ArrayList<String>();
//        for (int i = 0; i < test.size(); i++) {
//            if(test.get(i).equals("a")){
//                test.remove(i);
//            }
//
//        }
//    }
//
////    private List<String> delete(List<String> test) {
////        Set<String> set = new HashSet<>();
////        for (String s : test) {
////            if (!set.contains(s)) {
////                set.add(s);
////            }
////        }
////        List<String> ans=new ArrayList<>();
////        for (int j = 0; j <set.size(); j++) {
////            ans.add(set.get(j));
////        }
////        return ans;
////    }
//
//
////    private List<String> map(Map<String,Integer> map){
////        List<String> ans=new ArrayList<>();
////        Arrays.sort(map.get(o1),map.get(o2) -> o2.getValue() - o1.getValue();
////        for (Map.Entry<String, Integer> entry : map.entrySet()) {
////            if(ans.size()==3){
////                break;
////            }
////            ans.add(entry.getKey());
////        }
////
////    }
//
//    private Map<String,Integer> getCount(List<String> test) {
//        Map<String,Integer> map=new HashMap<>();
//        for (String s : test) {
//            map.put(s,map.getOrDefault(s,0)+1);
//        }
//        return map;
//    }
//
//
//    private List<List<String>> sort(List<String> list){
//        List<List<String>> ans=new ArrayList<>();
//        List<String> temp=new ArrayList<>();
//        List<String> temp1=new ArrayList<>();
//        for (int i = 0; i < list.size(); i++) {
//            if(list.get(i) instanceof String){
//                temp.add(list.get(i));
//            }else {
//                temp1.add(list.get(i));
//            }
//        }
//        ans.add(temp);
//        ans.add(temp1);
//        return ans;
//
//    }
//
//
//
//    private Map<String,List<Integer>> getScore(Map<String,Integer> map){
//        Map<String,Integer> ans=new HashMap<>();
//       for (Map.Entry<String, Integer> entry : map.entrySet()) {
//           map.replaceAll((k,v) -> v*entry.getValue());
//       }
//        return ans;
//    }
//
//
//
//
//
//
//}
//
