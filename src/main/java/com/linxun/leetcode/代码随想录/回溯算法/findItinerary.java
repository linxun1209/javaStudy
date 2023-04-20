package com.linxun.leetcode.代码随想录.回溯算法;

import java.util.*;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.代码随想录.回溯算法
 * @date 2023/4/20 23:26
 */
public class findItinerary {
        private LinkedList<String> res;
        private LinkedList<String> path = new LinkedList<>();

        public List<String> findItinerary(List<List<String>> tickets) {
            Collections.sort(tickets, (a, b) -> a.get(1).compareTo(b.get(1)));
            path.add("JFK");
            boolean[] used = new boolean[tickets.size()];
            backTracking((ArrayList) tickets, used);
            return res;
        }

        public boolean backTracking(ArrayList<List<String>> tickets, boolean[] used) {
            if (path.size() == tickets.size() + 1) {
                res = new LinkedList(path);
                return true;
            }

            for (int i = 0; i < tickets.size(); i++) {
                if (!used[i] && tickets.get(i).get(0).equals(path.getLast())) {
                    path.add(tickets.get(i).get(1));
                    used[i] = true;

                    if (backTracking(tickets, used)) {
                        return true;
                    }

                    used[i] = false;
                    path.removeLast();
                }
            }
            return false;
        }


    class Solution {
        private Deque<String> res;
        private Map<String, Map<String, Integer>> map;

        private boolean backTracking(int ticketNum){
            if(res.size() == ticketNum + 1){
                return true;
            }
            String last = res.getLast();
            if(map.containsKey(last)){//防止出现null
                for(Map.Entry<String, Integer> target : map.get(last).entrySet()){
                    int count = target.getValue();
                    if(count > 0){
                        res.add(target.getKey());
                        target.setValue(count - 1);
                        if(backTracking(ticketNum)) {
                            return true;
                        }
                        res.removeLast();
                        target.setValue(count);
                    }
                }
            }
            return false;
        }

        public List<String> findItinerary(List<List<String>> tickets) {
            map = new HashMap<String, Map<String, Integer>>();
            res = new LinkedList<>();
            for(List<String> t : tickets){
                Map<String, Integer> temp;
                if(map.containsKey(t.get(0))){
                    temp = map.get(t.get(0));
                    temp.put(t.get(1), temp.getOrDefault(t.get(1), 0) + 1);
                }else{
                    temp = new TreeMap<>();//升序Map
                    temp.put(t.get(1), 1);
                }
                map.put(t.get(0), temp);

            }
            res.add("JFK");
            backTracking(tickets.size());
            return new ArrayList<>(res);
        }
    }
}
