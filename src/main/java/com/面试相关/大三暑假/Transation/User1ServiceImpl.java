//package com.面试相关.大三暑假.Transation;
//
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Propagation;
//import org.springframework.transaction.annotation.Transactional;
//
//@Service
//public class User1ServiceImpl implements User1Service {
//    //省略其他...
//    @Override
//    @Transactional(propagation = Propagation.REQUIRED)
//    public void addRequired(User1 user){
//        user1Mapper.insert(user);
//    }
//}