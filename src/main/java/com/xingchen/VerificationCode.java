package com.xingchen;

import java.util.Random;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.xingchen
 * @date 2022/8/17 19:47
 */
public class VerificationCode {
    public static void main(String[] args) {
        char[] chars=new char[52];
        for (int i = 0; i <chars.length ; i++) {
            if(i<=25) {
                chars[i] = (char) (97 + i);

            }else{
                chars[i]=(char)(65+i-26);

            }
        }
        String result="";
        Random random=new Random();
        for (int i = 0; i < 4; i++) {
            int randomIndex=random.nextInt(chars.length);
            result+=chars[randomIndex];
        }
        int i = random.nextInt(10);
        result+=i;
        System.out.println(result);
    }
}
