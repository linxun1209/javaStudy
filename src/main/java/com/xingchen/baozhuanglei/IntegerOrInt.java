package com.xingchen.baozhuanglei;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.xingchen.baozhuanglei
 * @date 2022/8/30 20:37
 */
public class IntegerOrInt {
    public static void main(String[] args) {
        int m = 500;
        Integer obj = new Integer(m);  // 手动装箱
        int n = obj.intValue();  // 手动拆箱
        System.out.println("n = " + n);

        Integer obj1 = new Integer(500);
        System.out.println("obj等价于obj1的返回结果为" + obj.equals(obj1));
    }
}
