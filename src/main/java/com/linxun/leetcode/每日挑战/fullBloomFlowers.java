package com.linxun.leetcode.每日挑战;

import lombok.var;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.TreeMap;
import java.util.stream.IntStream;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.每日挑战
 * @date 2023/9/28 16:08
 */
public class fullBloomFlowers {


    /**
     * 超时
     *
     * @param flowers
     * @param people
     * @return
     */
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        int[] answer=new int[people.length];
        int m=flowers.length;
        int n=flowers[0].length;
        for (int i=0;i<answer.length;i++){
            answer[i]=0;
        }
        for (int i=0;i<people.length;i++){
            for (var flower:flowers){
                if(flower[0]<=people[i]&&flower[1]>=people[i]){
                    answer[i]++;
                }
            }
        }return answer;


    }


    public int[] fullBloomFlowers2(int[][] flowers, int[] people) {
        int m=flowers.length;
        int n=people.length;
        int[] ans=new int[n];
        for (int i=0;i<ans.length;i++){
            ans[i]=0;
        }
        var start=new int[n];
        var end=new int[n];
        for (int i=0;i<m;i++){
            start[i]=flowers[i][0];
            end[i]=flowers[i][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);
        for (int i=0;i<m;i++){
            int res=n;
            int l=0,r=n-1;
            while (l<=r){
                int mid=(l+r)>>1;
                if(start[mid]>people[i]){
                    r=mid-1;
                    res=mid;
                }else {
                    l=mid+1;
                }
                ans[i]+=res;
                l=0;r=n-1;
                while (l<=r){
                     mid=(r+l)>>1;
                     if(end[mid]>=people[i]){
                         r=mid-1;
                         res=mid;
                     }else {
                         l=mid+1;
                     }

                }
                ans[i]-=res;
            }
        }
        return ans;
    }
    public static int[] fullBloomFlowers3(int[][] flowers, int[] people) {
        int n = flowers.length, m = people.length;
        int[] ans = new int[m];
        for (int i = 0; i < m; i++) ans[i] = 0;
        var start = new int[n];
        var end = new int[n];
        for (int i = 0; i < n; i++) {
            start[i] = flowers[i][0];
            end[i] = flowers[i][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);
        for (int i = 0; i < m; i++) {
            int res = n;
            int l = 0, r = n - 1;
            while (l <= r) {
                int mid = (l + r) >> 1;
                if (start[mid] > people[i]) {
                    r = mid - 1;
                    res = mid;
                }else l = mid + 1;
            }
            ans[i] += res;
            l = 0; r = n - 1;
            while (l <= r) {
                int mid = (l + r) >> 1;
                if(end[mid] >= people[i]) {
                    r = mid - 1;
                    res = mid;
                }else l = mid + 1;
            }
            ans[i] -= res;
        }
        return ans;
    }

    public int[] fullBloomFlowers4(int[][] flowers, int[] persons) {
        TreeMap<Integer, Integer> cnt = new TreeMap<>();
        for (int[] flower : flowers) {
            cnt.put(flower[0], cnt.getOrDefault(flower[0], 0) + 1);
            cnt.put(flower[1] + 1, cnt.getOrDefault(flower[1] + 1, 0) - 1);
        }
        int m = persons.length;
        Integer[] indices = IntStream.range(0, m).boxed().toArray(Integer[]::new);
        Arrays.sort(indices, (i, j) -> persons[i] - persons[j]);
        int[] ans = new int[m];
        int curr = 0;
        for (int x : indices) {
            while (!cnt.isEmpty() && cnt.firstKey() <= persons[x]) {
                curr += cnt.pollFirstEntry().getValue();
            }
            ans[x] = curr;
        }
        return ans;
    }


    public static void main(String[] args) {
        int[][] flowers={{1,6},{3,7},{9,12},{4,13}};
        int[] people={2,3,7,11};
        fullBloomFlowers3(flowers,people);
    }
}


