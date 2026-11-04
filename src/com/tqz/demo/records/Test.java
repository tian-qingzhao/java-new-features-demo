package com.tqz.demo.records;

/**
 * Java 17 Records为创建不可变数据传输对象(DTO)提供了简洁的语法。
 *
 * @author <a href="https://github.com/tian-qingzhao">tianqingzhao</a>
 * @since 2025/9/27
 */
public class Test {

    public static void main(String[] args) {
        // 创建记录实例
        Person person = new Person("张三", 30);

        // 获取属性
        System.out.println("姓名: " + person.name());
        System.out.println("年龄: " + person.age());

        // 使用自定义方法
        System.out.println("是否成年: " + person.isAdult());

        // 解构记录
        var userInfo = getUserInfo();
        processUserData(userInfo.username(), userInfo.email());
    }

    private static UserInfo getUserInfo() {
        return new UserInfo("admin", "admin@example.com");
    }

    private static void processUserData(String username, String email) {
        System.out.println("处理用户: " + username + ", 邮箱: " + email);
    }

    record UserInfo(String username, String email) {
    }
}
