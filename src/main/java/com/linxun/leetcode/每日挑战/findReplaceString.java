package com.linxun.leetcode.每日挑战;

import java.util.Arrays;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.每日挑战
 * @date 2023/8/15 17:15
 */
public class findReplaceString {
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        StringBuilder sb=new StringBuilder();
        //设置二维字符组存入对应的sources和target数组
        String[][] arr=new String[1001][2];
        int n=indices.length;
        //初始化把字符串存进去
        for (int i=0;i<n;i++){
            arr[indices[i]][0]=sources[i];
            arr[indices[i]][1]=targets[i];
        }
        for (int i=0;i<s.length();i++){
            if(arr[i][0]!=null){
                if(s.substring(i,i+arr[i][0].length()).equals(arr[i][0])){
                    sb.append(arr[i][1]);
                    i+=arr[i][0].length()-1;
                }else {
                    sb.append(s.charAt(i));
                }
            }else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }


    /**
     * 排序+双指针
     * @param s
     * @param indices
     * @param sources
     * @param targets
     * @return
     */
    public String findReplaceString2(String s, int[] indices, String[] sources, String[] targets) {
        int st[][]=new int[sources.length][2];
        for(int i=0;i<sources.length;i++){
            st[i][0]=indices[i];
            st[i][1]=i;
        }
        Arrays.sort(st,(a, b) -> (a[0] != b[0]) ? a[0] -b[0] : b[1] - a[1]);
        StringBuffer res = new StringBuffer(s);
        int pre=0;
        for(int i=0;i<sources.length;i++){
            int p1=st[i][0]+pre;
            int p2=0;
            int start=-1;
            int length=sources[st[i][1]].length();
            int length2=res.length();
            for(int j=0;j<length;j++){
                if(p1<length2 && res.charAt(p1)==sources[st[i][1]].charAt(p2)){
                    if(start==-1){
                        start=p1;
                    }
                    p1++;
                    p2++;
                }else if(start!=-1){
                    start=-1;
                    break;
                }
            }
            if(start!=-1){
                res.delete(start,start+p2);
                res.insert(start,targets[st[i][1]]);
                pre+=(targets[st[i][1]].length()-sources[st[i][1]].length());
            }
        }
        return res.toString();
    }
}
