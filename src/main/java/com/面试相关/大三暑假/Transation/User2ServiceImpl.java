//package com.面试相关.大三暑假.Transation;
//
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Propagation;
//import org.springframework.transaction.annotation.Transactional;
//
//@Service
//public class User2ServiceImpl implements User2Service {
//    //省略其他...
//    @Override
//    @Transactional(propagation = Propagation.REQUIRED)
//    public void addRequired(User2 user){
//        user2Mapper.insert(user);
//    }
//    @Override
//    @Transactional(propagation = Propagation.REQUIRED)
//    public void addRequiredException(User2 user){
//        user2Mapper.insert(user);
//        throw new RuntimeException();
//    }
//
//
//}