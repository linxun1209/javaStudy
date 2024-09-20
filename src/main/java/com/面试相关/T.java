//package com.面试相关;
//
//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.io.IOException;
//import java.util.Map;
//import java.util.concurrent.ConcurrentHashMap;
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//import java.util.concurrent.atomic.DoubleAdder;
//import java.util.concurrent.atomic.LongAdder;
//
//// 切勿删除模板代码
//class Solution {
//    public class TemperatureAnalyzer{
//        static class TemperatureStats{
//            private double minTemp=Double.MAX_VALUE;
//            private double maxTemp=Double.MIN_VALUE;
//            private DoubleAdder totalTemp=new DoubleAdder();
//            private LongAdder count=new LongAdder();
//        public synchronized void update(double temp){
//            minTemp=Math.min(minTemp,temp);
//            maxTemp=Math.max(maxTemp,temp);
//            totalTemp.add(temp);
//            count.increment();
//        }
//        public double getMin(){
//            return minTemp;
//        }
//        public double getMax(){
//            return maxTemp;
//        }
//        public double getAvergae(){
//            return totalTemp/count.doubleValue();
//        }
//
//    }
//    public Map<String,TemperatureStats> analyze(String filePath) throws IOException{
//        Map<String,TemperatureStats> stateMap=new ConcurrentHashMap<>();
//        ExecutorService ex= Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
//        try(BufferedReader br=new BufferedReader(new FileReader(filePath))){
//            String line;
//            while((line==br.readLine())!=null){
//                final String[] parts=line.split(",");
//                if(parts.length!=2) continue;
//                String city=parts[0].trim();
//                double temp;
//                try{
//                    temp=Double.parseDouble(parts[1].trim());
//                }catch(NumberFormatException e){
//                    continue;
//                }
//                ex.submit())->{
//                    stateMap.computeIfAbsent(city,k->new TemperatureStats()).update(temp);
//                });
//            }
//        }
//        ex.shutdown();
//        while(!ex.isTerminated()){
//            return stateMap;
//        }
//    }
//}