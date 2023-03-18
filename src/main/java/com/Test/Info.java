package com.Test;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.yupi.project.service
 * @date 2022/12/10 10:14
 */
/**
 * 员工信息类
 * @author tangyg
 *
 */
public class Info {
    //员工姓名
    private String name;
    //员工年龄
    private int age;
    //员工性别
    private String sex;
    //员工电话
    private String phone;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Info(){}

    /**
     * Info类的构造方法
     * @param name
     * @param age
     * @param sex
     * @param phone
     */
    public Info(String name, int age, String sex, String phone) {
        this.name = name;
        this.age = age;
        this.age = age;
        this.sex = sex;
        this.phone = phone;
    }
}
