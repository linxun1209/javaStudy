package com.Test;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.yupi.project.service
 * @date 2022/12/10 10:15
 */

/**
 * 员工信息相关操作
 * @author tangyg
 *
 */
public class InfoService {
    /**
     * 打印输出所有年龄为偶数的员工的信息
     *
     * 需求：
     * 按照以下格式输出员工信息，属性之间用短杠（-）分隔，每输出一个员工信息后换行：
     *
     * 姓名1-年龄1-性别1-电话1
     * 姓名2-年龄2-性别2-电话2
     * ……
     *
     * 样例：
     * zs-20-男-18011112222
     * ww-22-男-18055556666
     * ……
     */
    public void showAll() {
        // 补全代码
        // 注意1：数据来自Db.infos
        // 注意2：是直接输出打印到控制台
        Info[] infos = Db.infos;
        for (int i = 0; i < infos.length; i++) {
            if(infos[i].getAge()%2==0){
                System.out.println("000000000000000");
                System.out.println(infos[i].getName()+"-"+infos[i].getAge()+"-"+infos[i].getSex()+"-"+infos[i].getPhone());
            }
        }
    }

    /**
     * 根据员工的姓名来查询员工信息
     *
     * 需求：
     * 如果员工存在则返回员工信息对象，不存在则返回null
     *
     * @param name 员工姓名
     * @return 返回对象
     */
    public Info find(String name){
        // 补全代码
        // 注意：数据来自Db.infos
        Info[] infos = Db.infos;
        for (int i = 0; i < infos.length; i++) {
            if(infos[i].getName().equals(name)){
                System.out.println(infos[i].toString());
                return infos[i];
            }
        }
        return null;
    }
}

