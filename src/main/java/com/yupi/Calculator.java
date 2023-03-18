package com.yupi;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.yupi
 * @date 2022/10/27 10:17
 */
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.Vector;
public class Calculator {
    String a="0";//初始化第一个操作数
    String b="0";//初始化第二个操作数
    String signal="+";//初始化操作符
    String result="0";//初始化结果，避免空等于
    JButton store;
    int k1=0;int k2=0;int k3=0;int k4=0;int k5=0;
    Vector vt=new Vector(20,10);
    //Vector线程更安全，在这里不建议使用ArrayList
    JTextField textesult=new JTextField(result,20);
    //内部类实现功能
    //继承接口实现监听功能
    //监听数字类键
    class Listener_key implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String ss= ((JButton) e.getSource()).getText();//得到button键值
            store=(JButton) e.getSource();
            vt.add(store);
            if(k1==1){
                if(k3==1){
                    a="";
                    k5=1;
                }
                a=a+ss;
                k3=k3+1;
                textesult.setText(a);
            } else if (k1==2) {
                if(k4==1){
                    b="";
                    k5=1;
                }
                b=b+ss;
                k4=k4+1;
                textesult.setText(b);

            }
        }
    }
    //监听符号类键
    class Listener_signal implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            String optional=((JButton) e.getSource()).getText();
            store=(JButton) e.getSource();
            vt.add(store);
            if(k2==1){
                k1=2;
                k5=1;
                signal=optional;
                k2=k2+1;
            }else {
                int k=vt.size();
                JButton c=(JButton) vt.get(k-2);
                if(!(c.getText().equals("+"))
                        &&!(c.getText().equals("-"))
                        &&!(c.getText().equals("*"))
                        &&!(c.getText().equals("/"))){
                    cal();
                    a=result;
                    k1=2;
                    k5=1;
                    k4=1;
                    signal=optional;
                }
                k2=k2+1;
            }
        }
    }
    class Listener_point implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            store=(JButton) e.getSource();
            vt.add(store);
            if(k5==1){
                String str=((JButton) e.getSource()).getText();
                if(k1==1){
                    if(k3==1){
                        a="";
                        k5=1;
                    }
                    a=a+str;
                    k3=k3+1;
                    textesult.setText(a);
                } else if (k1 == 2) {
                    if(k4==1){
                        b="";
                        k5=1;
                    }
                    b=b+str;
                    k4=k4+1;
                    textesult.setText(b);
                }
            }
            k5=k5+1;


        }
    }
    class Listener_equal implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            String ss=((JButton) e.getSource()).getText();
            store=(JButton) e.getSource();
            vt.add(store);
            cal();
            k1=1;k2=1;k3=1;k4=1;k5=1;
            a=result;
        }
    }
    class Listener_clear implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            store=(JButton) e.getSource();
            vt.add(store);
            k1=1;k2=1;k3=1;k4=1;k5=1;
            a="0"; b="0"; signal="+";result="";
            textesult.setText(result);
            vt.clear();
        }
    }
    public void cal(){
        double d1;
        double d2;
        String c=signal;
        double r=0;
        if(c.equals("")){
            textesult.setText("please input number to calculate");
        } else {
            if(a.equals(".")){
                a="0.0";
            }
            if(b.equals(".")){
                b="0.0";
            }
            d1=Double.valueOf(a).doubleValue();
            d2=Double.valueOf(b).doubleValue();
            if(c.equals("+")){
                r=d1+d2;
            }
            if(c.equals("-")){
                r=d1-d2;
            }

            if(c.equals("*")){
                BigDecimal m1=new BigDecimal(Double.toString(d1));
                BigDecimal m2=new BigDecimal(Double.toString(d2));
                r=m1.multiply(m2).doubleValue();
            }
            if(c.equals("/")){
                if(d2==0){
                    r=0;
                }else{
                    r=d1/d2;
                }
            }

        }
        result=((new Double(r)).toString());
        textesult.setText(result);
    }

}
