package com.并发.Test;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.并发.Test
 * @date 2023/4/15 15:56
 */
public class ForContentTest {
    static final int LINE_NUM=1024;
    static final int COLUM_NUM=1024;

    public static void main(String[] args) {
        long[][] array=new long[LINE_NUM][COLUM_NUM];
        long startTime =System.currentTimeMillis();

        for (int i=0;i<LINE_NUM;++i){
            for (int j=0;j<COLUM_NUM;++j){
                array[i][j]=i*2+j;

            }
            long endTime=System.currentTimeMillis();
            long cacheTime=endTime-startTime;
            System.out.println("cache time :"+cacheTime);
        }
    }

}
