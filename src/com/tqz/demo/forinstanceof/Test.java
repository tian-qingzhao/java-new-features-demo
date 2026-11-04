package com.tqz.demo.forinstanceof;

/**
 * Java 17改进了instanceof运算符，使其能够同时进行类型检查和类型转换。
 *
 * @author <a href="https://github.com/tian-qingzhao">tianqingzhao</a>
 * @since 2025/9/27
 */
public class Test {

    public static void main(String[] args) {
        System.out.println(getDescription("abc"));
    }

    // 使用模式匹配for instanceof
    public static String getDescription(Object obj) {
        if (obj instanceof String s) {
            return "字符串，长度: " + s.length();
        } else if (obj instanceof Integer i) {
            return "整数: " + i;
        } else {
            return "未知类型";
        }
    }

}
