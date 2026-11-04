package com.tqz.demo.switchs;

import com.tqz.demo.records.Person;

/**
 * Java 17继承了Java 14引入的Switch表达式，与模式匹配结合使用更加强大。
 *
 * @author <a href="https://github.com/tian-qingzhao">tianqingzhao</a>
 * @since 2025/9/27
 */
public class Test {

    public static void main(String[] args) {
        System.out.println(getTypeDescription(123));

        System.out.println(analyzePerson(new Person("tqz", 18)));
    }

    public static String getTypeDescription(Object obj) {
        return switch (obj) {
            case String s -> "字符串，内容: " + s;
            case Integer i -> "整数: " + i;
            case Long l -> "长整型: " + l;
            case Double d -> "双精度: " + d;
            case null -> "空值";
            default -> "其他类型";
        };
    }

    // 带条件的模式匹配
    public static String analyzePerson(Person person) {
        return switch (person) {
            case Person p when p.age() < 18 -> p.name() + " 是未成年人";
            case Person p when p.age() < 65 -> p.name() + " 是成年人";
            case Person p -> p.name() + " 是老年人";
        };
    }
}
