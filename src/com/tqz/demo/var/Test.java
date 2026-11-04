package com.tqz.demo.var;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Java 10 引入了 var 关键字，这是一种局部变量类型推断机制。var 允许开发者在声明局部变量时不显式指定变量的类型，
 * 而是由编译器根据赋值来推断变量的类型。这使得代码更加简洁易读，特别是在某些复杂类型的声明中尤为有用。
 *
 * @author <a href="https://github.com/tian-qingzhao">tianqingzhao</a>
 * @since 2025/9/29
 */
public class Test {

    // public var z = 20; // 错误：var 不能用于成员变量

    public static void main(String[] args) {
        // 编译器推断出 number 的类型是 int
        var number = 10;
        // 输出结果：10
        System.out.println(number);

        // 编译器推断出 message 的类型是 String
        var message = "Hello, Java 10!";
        // 输出结果：Hello, Java 10!
        System.out.println(message);

        // 编译器推断出 list 的类型是 ArrayList<String>
        var list = new ArrayList<String>();
        list.add("Java");
        list.add("10");

        // 编译器推断出 item 的类型是 String
        for (var item : list) {
            // 输出结果：Java 10
            System.out.println(item);
        }

        // 错误：需要初始化以推断类型
        // var uninitialized;

        // 编译器推断出 stream 的类型是 Stream<String>
        var stream = Stream.of("Java", "10", "is", "cool");
        // 编译器推断出 result 的类型是 String
        var result = stream.collect(Collectors.joining(" "));
        // 输出结果：Java 10 is cool
        System.out.println(result);
    }
}
