package com.并发.Test;

import java.util.concurrent.*;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.并发.Test
 * @date 2023/4/5 11:04
 */
public class countTest extends RecursiveTask<Integer> {

    private static final int THRESHOlD=2;
    private int start;
    private int end;

    public countTest(int start, int end) {
        this.start = start;
        this.end = end;
    }

    /**
     * The main computation performed by this task.
     *
     * @return the result of the computation
     */
    @Override
    protected Integer compute() {
        int sum=0;
        boolean canCompute=(end-start)<=THRESHOlD;
        if(canCompute){
            for (int i = start; i <=end; i++) {
                sum+=i;

            }
        }else {
            int middle=(start+end)/2;
            countTest leftTask=new countTest(start,middle);
            countTest rightTask=new countTest(middle,end);
            leftTask.fork();
            rightTask.fork();
            int leftResult=leftTask.join();
            int rightResult=rightTask.join();
            sum=leftResult+rightResult;



        }
        return sum;
    }
    public static void main(String[] agrs){
        ForkJoinPool forkJoinPool=new ForkJoinPool();
        countTest test=new countTest(1,4);
        Future<Integer> result=forkJoinPool.submit(test);
        try {
            System.out.println(result.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
