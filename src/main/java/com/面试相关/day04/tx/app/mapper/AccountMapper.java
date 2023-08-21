package com.面试相关.day04.tx.app.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * @author xing'chen
 */
public interface AccountMapper {

    @Update("update account set balance=balance+#{balance} where accountNo=#{accountNo}")
    void update(@Param("accountNo") int accountNo, @Param("balance") int balance);

    @Select("select balance from account where accountNo=#{accountNo} for update")
    int findBalanceBy(int accountNo);
}
