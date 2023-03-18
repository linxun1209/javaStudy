package com.java8的新特性;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.java8的新特性
 * @date 2022/11/2 19:41
 */
public class Employee {

    private Integer id;

    private String name;

    private Integer m;

    private Integer age;

    public Employee(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getM() {
        return m;
    }

    public void setM(Integer m) {
        this.m = m;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", m=" + m +
                ", age=" + age +
                '}';
    }

    public Employee(Integer id) {
        this.id = this.id;
    }

    public Employee(Integer id, String name, Integer m, Integer age) {
        this.id = id;
        this.name = name;
        this.m = m;
        this.age = age;
    }
}
