package com.xingchen.xuexi;

class T1{

    public int maxArea(int[] height) {
//        int max=0;
//        int l=0;
//        int r=height.length-1;
//        while (l<r){
//            int distance=r-l;
//            if(height[l]>height[r]){
//                l++;
//            }
//            else {
//                r--;
//            }
//            int height_min=Math.min(height[l],height[r]);
//            max=Math.max(max,distance*height_min);
//        }
//        return max;
        int ans=0;
        for (int l=0,r=height.length-1;l<r;){
            ans=Math.max(ans,(r-l)*Math.min(height[r],height[l]));
            if(height[l]>=height[r]){
                l++;
            }else {
                r--;
            }

        }
        return  ans;

    }
}