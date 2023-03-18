package com.yupi;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.yupi
 * @date 2022/10/27 10:22
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Demo {
    public static void main(String[] args) {
        JFrame f=new JFrame();
        f.setLocation(300,200);
        f.setResizable(false);
        JPanel p=new JPanel();
        p.setLayout(new GridLayout(4,4));
        JButton b1=new JButton("1");
        JButton b2=new JButton("2");
        JButton b3=new JButton("3");
        JButton b4=new JButton("4");
        JButton b5=new JButton("5");
        JButton b6=new JButton("6");
        JButton b7=new JButton("7");
        JButton b8=new JButton("8");
        JButton b9=new JButton("9");
        JButton b0=new JButton("0");
        JButton add=new JButton("+");
        JButton minus=new JButton("-");
        JButton multiply=new JButton("*");
        JButton except=new JButton("/");
        JButton point=new JButton(".");
        JButton clear=new JButton("AC");
        JButton equal=new JButton("=");

        p.add(b7);p.add(b8);p.add(b9);p.add(add);
        p.add(b4);p.add(b5);p.add(b6);p.add(minus);
        p.add(b1);p.add(b2);p.add(b3);p.add(multiply);
        p.add(b0);p.add(point);p.add(except);p.add(equal);

        p.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));

        //菜单退出
        JMenuBar bar=new JMenuBar();
        f.setJMenuBar(bar);
        JMenu Menu=new JMenu("选项");
        JMenuItem name=new JMenuItem("EXIT");
        Menu.add(name);
        bar.add(Menu);
        name.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });




        JPanel p1=new JPanel();
        p1.setLayout(new BorderLayout());
        Calculator cal=new Calculator();
        p1.add(cal.textesult,BorderLayout.WEST);
        p1.add(clear,BorderLayout.EAST);

        f.getContentPane().setLayout(new BorderLayout());
        f.getContentPane().add(p,BorderLayout.CENTER);
        f.getContentPane().add(p1,BorderLayout.NORTH);
        f.pack();
        f.setVisible(true);

        Calculator.Listener_key key=cal.new Listener_key();
        b0.addActionListener(key);
        b1.addActionListener(key);
        b2.addActionListener(key);
        b3.addActionListener(key);
        b4.addActionListener(key);
        b5.addActionListener(key);
        b6.addActionListener(key);
        b7.addActionListener(key);
        b8.addActionListener(key);
        b9.addActionListener(key);

        Calculator.Listener_clear Clear = cal.new Listener_clear();
        clear.addActionListener(Clear);

        Calculator.Listener_equal Equal = cal.new Listener_equal();
        equal.addActionListener(Equal);

        Calculator.Listener_point Point = cal.new Listener_point();
        point.addActionListener(Point);

        Calculator.Listener_signal Signal = cal.new Listener_signal();
        add.addActionListener(Signal);
        minus.addActionListener(Signal);
        multiply.addActionListener(Signal);
        except.addActionListener(Signal);

        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });


    }
}


