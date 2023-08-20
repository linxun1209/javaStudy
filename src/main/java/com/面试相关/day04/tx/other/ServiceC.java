package com.面试相关.day04.tx.other;

public interface ServiceC {

    //    @Transactional(rollbackFor = Exception.class)
    public void transfer(int from, int to, int amount);
}
