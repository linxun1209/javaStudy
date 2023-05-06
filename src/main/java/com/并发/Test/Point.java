package com.并发.Test;

import java.util.concurrent.locks.StampedLock;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.并发.Test
 * @date 2023/5/6 21:11
 */
class Point {
    private double x,y;

    //锁实例
    private final StampedLock s1=new StampedLock();

    //排他锁--写锁(writeLock)
    void move(double deletaX,double deletaY){
        long stamp =s1.writeLock();
        try {
            x+=deletaX;
            y+=deletaY;

        }finally {
            s1.unlockWrite(stamp);
        }
    }


    //乐观读锁(tryOptimisticRead)
    double distanceFromOrigin(){
        //尝试获取乐观锁
        long stamp=s1.tryOptimisticRead();
        //将全部的变量复制到方法体栈内
        double currentX=x,currentY=y;
        //检查获取的读锁戳记后,锁有没有被其他线程排他性抢占
        if(!s1.validate(stamp)){
            //如果被抢占则获取一个共享读锁(悲观锁获取)
            stamp=s1.readLock();
        }
        try {
            //将全部变量复制到方法体栈内
            currentX=x;
            currentY=y;
        }finally {
            //释放共享读锁
            s1.unlockRead(stamp);
        }
        return Math.sqrt(currentX*currentX+currentY*currentY);

    }

    //使用悲观锁获取读锁,并尝试转换为写锁
    void moveIfAtOrigin(double newX,double newY){
        //这里可以使用乐观锁替换
        long stamp=s1.readLock();
        try {
            //如果当前点在原点移动
            while (x==0.0&&y==0.0){
                //尝试将获取的读锁升级为写锁
                long ws=s1.tryConvertToWriteLock(stamp);
                //升级成功之后,则更新戳记,并设置坐标值,然后退出循环
                if (ws!=0L){
                    stamp=ws;
                    x=newX;
                    y=newY;
                    break;
                }else {
                    //读锁升级写锁则释放读锁,显式获取独占写锁,然后循环重试
                    s1.unlockRead(stamp);
                    stamp=s1.writeLock();
                }
            }
        }finally {
            s1.unlock(stamp);
        }
    }
}
