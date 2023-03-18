package com.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.Assert.*;

import static org.junit.Assert.assertEquals;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.yupi.project.service
 * @date 2022/12/10 10:38
 */
public class Test {
    @org.junit.Test
    public void testAccount() {
        Account s = new Account("zs", "2022-08", 80);
        s.setScore(101);
        assertEquals(s.getScore(), 80);
        s.setScore(-1);
        assertEquals(s.getScore(), 80);
        s.setScore(10);
        assertEquals(s.getScore(), 10);
    }
    @org.junit.Test
    public void testToString() {
        Account s = new Account("hmm", "2021-01", 60);
        assertEquals("{name:\"hmm\";time:\"2021-01\";score:60}", s.toString());
    }

    @org.junit.Test
    public void testInit(){
        assertEquals("zl",Db.infos[3].getName());
        assertEquals(24,Db.infos[4].getAge());
        assertEquals("18012345678",Db.infos[5].getPhone());

        assertEquals(Db.accountsLength,12);
        assertEquals(91,Db.accounts[6].getScore());
        assertEquals(99,Db.accounts[7].getScore());
        assertEquals("sq",Db.accounts[8].getName());
        assertEquals("sq",Db.accounts[9].getName());
        assertEquals("2022-01",Db.accounts[10].getTime());
        assertEquals("2022-02",Db.accounts[11].getTime());
    }

    @org.junit.Test
    public void testQueryNum(){
        assertEquals(92,AccountService.queryNum("zs","2022-02"));
        assertEquals(74,AccountService.queryNum("qb","2022-01"));
    }
    @org.junit.Test
    public void testQueryMax() {
        assertEquals("zl",AccountService.queryMax());
    }


    InfoService infoService = new InfoService();

    /**
     * 测试打印输出所有年龄为偶数的员工的信息
     */
    @org.junit.Test
    public void testShowAll() {
        ByteArrayOutputStream bao = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bao));
        infoService.showAll();
        String rst = new String(bao.toByteArray());
        String[] split = rst.split("\n");
        assertArrayEquals(new String[] {"zs-20-男-18011112222", "ww-22-男-18055556666",
                "sq-24-男-18099990000"}, split);
    }

    /**
     * 测试查找员工功能
     */
    @org.junit.Test
    public void testFind() {
        Info i1 = infoService.find("ww");
        assertNotNull(i1);
        Info i2 = infoService.find("ldh");
        assertNull(i2);
    }


}
