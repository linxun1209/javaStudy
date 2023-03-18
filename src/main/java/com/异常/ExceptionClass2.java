package com.异常;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.异常
 * @date 2022/9/19 21:21
 */
/**
 * 异常处理示例：
 * 子类方法的异常要比父类方法的异常更小
 * a、如果父类方法没有抛出异常，子类重写后也不能抛出异常
 * b、如果父类方法抛出了异常，子类方法可以抛出相同的异常，也可以抛出父类异常的子异常，也可以不抛出异常
 */
public class ExceptionClass2 {

    public static void main(String[] args) {
    }

    class UserNotFoundException extends Exception {

    }

    /**
     * 定义一个接口，里面有一个抽象login方法，并且抛出了UserNotFoundException异常
     */
    interface UserManager {
        void login(String username, String password) throws UserNotFoundException;
    }

    /**
     * 正确写法，这里可以抛出UserNotFoundException异常，也可以不抛出异常
     */
    class UserManagerImpl1 implements UserManager {
        public void login(String username, String password) throws UserNotFoundException {

        }
    }

    /**
     * 不正确，因为UserManager接口中，login()方法没有要求抛出PasswordFailureException异常
     * 子类异常不能超出父类的异常范围
     */
    class UserManagerImpl2 implements UserManager {
        public void login(String username, String password)  {

        }
    }

    /**
     * 正确，因为MyException是UserNotFoundException子类
     * MyException异常没有超出接口的要求
     */
    class UserManagerImpl3 implements UserManager {
        public void login(String username, String password) throws UserNotFoundException, MyException {

        }
    }

    class PasswordFailureException extends Exception {

    }

    class MyException extends UserNotFoundException {

    }

}

