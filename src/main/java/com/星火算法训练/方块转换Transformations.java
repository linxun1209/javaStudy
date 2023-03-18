package com.星火算法训练;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.星火算法训练
 * @date 2022/10/16 17:59
 */
import java.util.Scanner;
public class 方块转换Transformations {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int a = s.nextInt();
        String[] b = new String[a];
        String[] c = new String[a];
        for (int i = 0; i < a; i++) {
            b[i] = s.next();
        }
        for (int i = 0; i < a; i++) {
            c[i] = s.next();
        }
        int fa = 7;
        String e;
        if (fa == 7) {
            int cs = 0;
            for (int i = a - 1; i >= 0; i--) {
                StringBuilder d = new StringBuilder();
                for (int j = 0; j < a; j++)
                    d.append(c[j].charAt(i));
                e = String.valueOf(d);
                if (e.equals(b[cs]))
                    cs++;
                else break;
            }
            if (cs == a)
                fa = 1;
        } //反转90°
        if (fa == 7) {
            int cs = 0;
            for (int i = a - 1; i >= 0; i--) {
                StringBuilder d = new StringBuilder();
                for (int j = a - 1; j >= 0; j--)
                    d.append(c[i].charAt(j));
                e = String.valueOf(d);
                if (e.equals(b[cs]))
                    cs++;
                else break;
            }
            if (cs == a)
                fa = 2;
        } //反转180°
        if (fa == 7) {
            int cs = 0;
            for (int i = 0; i < a; i++) {
                StringBuilder d = new StringBuilder();
                for (int j = a - 1; j >= 0; j--)
                    d.append(c[j].charAt(i));
                e = String.valueOf(d);
                if (e.equals(b[cs])) cs++;
                else break;
            }
            if (cs == a)
                fa = 3;
        } //反转270°
        if (fa == 7) {
            int cs = 0;
            for (int i = 0; i < a; i++) {
                StringBuilder d = new StringBuilder();
                for (int j = a - 1; j >= 0; j--)
                    d.append(c[i].charAt(j));
                e = String.valueOf(d);
                if (e.equals(b[cs])) cs++;
                else break;
            }
            if (cs == a)
                fa = 4;
        } //镜像，水平对称
        String[] f = new String[a];
        int sz = 0;
        int cs = 0;
        if (fa == 7) { //方法5这个需要进行
            for (int i = a - 1; i >= 0; i--) {
                StringBuilder d = new StringBuilder();
                for (int j = 0; j < a; j++)
                    d.append(c[j].charAt(i));
                f[sz++] = String.valueOf(d);
            }
            for (int i = 0; i < a; i++) {
                StringBuilder d = new StringBuilder();
                for (int j = a - 1; j >= 0; j--)
                    d.append(f[i].charAt(j));
                e = String.valueOf(d);
                if (e.equals(b[cs])) cs++;
                else break;
            }
            if (cs == a) {
                fa = 5;
            }
        }
        if (fa == 7) {
            sz = 0;
            cs = 0;
            for (int i = a - 1; i >= 0; i--) {
                StringBuilder d = new StringBuilder();
                for (int j = a - 1; j >= 0; j--)
                    d.append(c[i].charAt(j));
                f[sz++] = String.valueOf(d);
            }
            for (int i = 0; i < a; i++) {
                StringBuilder d = new StringBuilder();
                for (int j = a - 1; j >= 0; j--)
                    d.append(f[i].charAt(j));
                e = String.valueOf(d);
                if (e.equals(b[cs])) cs++;
                else break;
            }
            if (cs == a) {
                fa = 5;
            }
        }
        if (fa == 7) {
            sz = 0;
            cs = 0;
            for (int i = 0; i < a; i++) {
                StringBuilder d = new StringBuilder();
                for (int j = a - 1; j >= 0; j--)
                    d.append(c[j].charAt(i));
                f[sz++] = String.valueOf(d);
            }
            for (int i = 0; i < a; i++) {
                StringBuilder d = new StringBuilder();
                for (int j = a - 1; j >= 0; j--)
                    d.append(f[i].charAt(j));
                e = String.valueOf(d);
                if (e.equals(b[cs])) cs++;
                else break;
            }
            if (cs == a) {
                fa = 5;
            }
        }
        if (fa == 7) {
            cs = 0;
            for (int i = 0; i < a; i++) {
                //过河卒
                if (c[i].equals(b[i]))
                    cs++;
            }
            if (cs == a)
                fa = 6;
        } // 不改变
        System.out.println(fa);
    }
}
