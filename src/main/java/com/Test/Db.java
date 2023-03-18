package com.Test;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.yupi.project.service
 * @date 2022/12/10 10:13
 */


/**
 * 所有数据的存储
 * @author tangyg
 *
 */
public class Db {
    // 员工信息数组
    public static final Info[] infos = new Info[100];
    // 员工信息数组长度，默认是 0
    public static int infosLength = 0;
    // 员工绩效数组
    public static final Account[] accounts = new Account[100];
    // 员工绩效数组长度，默认是 0
    public static int accountsLength = 0;

    /**
     * 需求：
     *
     * 下面请在 static 静态块中初始化这 2 个数组的数据
     * 在 infos 中添加 6 个员工信息：
     *
     * 	姓名	年龄	性别	电话
     * 	zs		20		男		18011112222
     * 	ls		21		女		18033334444
     * 	ww		22		男		18055556666
     * 	zl		23		女		18077778888
     *  sq		24		男		18099990000
     *  qb		25		女		18012345678
     *
     * 	在 accounts 中添加 12 条员工绩效信息：
     * 	姓名	日期	绩效
     * 	zs		2022-01		90
     *  zs		2022-02		92
     *  ls		2022-01		80
     *  ls		2022-02		75
     *  ww		2022-01		66
     *  ww		2022-02		88
     *  zl		2022-01		91
     *  zl		2022-02		99
     * 	sq		2022-01		58
     * 	sq		2022-02		67
     * 	qb		2022-01		74
     * 	qb		2022-02		78
     */

    static{
        //参考如下代码，初始化员工信息数据（必须和上述需求、顺序一致），请补全代码
        infos[0] = new Info("zs",20,"男","18011112222");
        infos[1] = new Info("ls",21,"女","18033334444");
        infos[2] = new Info("ww",22,"男","18055556666");
        infos[3] = new Info("zl",23,"女","18077778888");
        infos[4] = new Info("sq",24,"男","18099990000");
        infos[5] = new Info("qb",25,"女","18012345678");

        //设置员工信息数组长度
        infosLength = 6;

        //参考如下代码，初始化员工绩效数据（必须和上述需求、顺序一致），请补全代码
        accounts[0] = new Account("zs","2022-01",90);
        accounts[1] = new Account("zs","2022-02",92);
        accounts[2] = new Account("ls","2022-01",80);
        accounts[3] = new Account("ls","2022-02",75);
        accounts[4] = new Account("ww","2022-01",66);
        accounts[5] = new Account("ww","2022-02",88);
        accounts[6] = new Account("zl","2022-01",91);
        accounts[7] = new Account("zl","2022-02",99);
        accounts[8] = new Account("sq","2022-01",58);
        accounts[9] = new Account("sq","2022-02",67);
        accounts[10] = new Account("qb","2022-01",74);
        accounts[11] = new Account("qb","2022-02",78);


        //设置员工绩效数组长度，请补全代码
        accountsLength=12;
    }
}
