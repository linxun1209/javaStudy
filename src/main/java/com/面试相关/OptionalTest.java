package com.面试相关;

import java.util.Optional;

/**
 * @author xing'chen
 * @version 1.0
 * @description: TODO
 * @date 2024/9/19 23:05
 */
public class OptionalTest {
    public static void main(String[] args) {
        Optional<String> optional = Optional.of("沉默王二");
        optional.isPresent();           // true
        optional.get();                 // "沉默王二"
        optional.orElse("沉默王三");    // "bam"
        optional.ifPresent((s) -> System.out.println(s.charAt(0)));     // "沉"
    }
}

