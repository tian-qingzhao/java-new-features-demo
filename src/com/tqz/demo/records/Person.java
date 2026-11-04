package com.tqz.demo.records;

/**
 *
 * @author <a href="https://github.com/tian-qingzhao">tianqingzhao</a>
 * @since 2025/9/27
 */
public record Person(String name, int age) {

    // 编译器自动生成构造器、getters、equals、hashCode和toString

    // 可以添加额外的方法
    public boolean isAdult() {
        return age >= 18;
    }

    // 可以自定义规范构造器
    public Person {
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative");
        }
    }

}
