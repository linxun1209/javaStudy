package com.Test;


/**
 * @author xingchen
 * @version V1.0
 * @Package com.yupi.project.service
 * @date 2022/12/10 10:14
 */
/**
 * 员工绩效相关操作
 * @author tangyg
 *
 */
public class AccountService {
    /**
     * 根据员工姓名和日期查询绩效
     *
     * 需求：
     * 如果数据不存在，则返回0，如果存在则返回绩效
     *
     * @param name 员工姓名
     * @param time 时间日期
     */
    public static int queryNum(String name,String time) {
        // 补全代码：
        // 注意：数据来自Db.accounts
        Account[] accounts = Db.accounts;
        for (int i = 0; i < accounts.length; i++) {
            if(accounts[i].getName().equals(name)&&accounts[i].getTime().equals(time)){
                return accounts[i].getScore();
            }

        }
        return 0;
    }

    /**
     * 查询员工绩效分最高的员工姓名
     *
     * 需求：
     * 返回绩效分最高的员工姓名
     *
     */
    public static String queryMax() {
        // 补全代码
        // 注意：数据来自Db.accounts
        String name = "";
        Account[] accounts = Db.accounts;
        int temp=accounts[0].getScore();
        for (int i = 1; i < accounts.length; i++) {
            if(accounts[i].getScore()>temp){
                temp=accounts[i].getScore();
            }else {


            }
        }


        return name;
    }
}
