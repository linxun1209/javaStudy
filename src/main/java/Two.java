import java.util.Scanner;

/**
 * @author xingchen
 * @version V1.0
 * @Package PACKAGE_NAME
 * @date 2023/2/6 21:47
 */
public class Two {
    /*
     3.输入两个升序排列的序列，将两个序列合并为一个有序序列并输出
 输入包含三行，
 第一行包含两个正整数n, m（1 ≤ n,m ≤ 100），用空格分隔。
 n表示第二行第一个升序序列中数字的个数，m表示第三行第二个升序序列中数字的个数。
 第二行包含n个整数（范围1~5000），用空格分隔。
 第三行包含m个整数（范围1~5000），用空格分隔。
 （相同元素保留一个如:arr1 = [1,2,6,9],arr2 = [2,8,10,11] 合并后因为[1,2,6,8,9,10,11]）。
      */
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        String s1=sc.nextLine();
        String s2=sc.nextLine();
        String s3=s1+s2;

    }
}


