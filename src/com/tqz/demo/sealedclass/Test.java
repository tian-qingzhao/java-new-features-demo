package com.tqz.demo.sealedclass;

/**
 * Java 17 密封类允许开发者精确控制哪些类可以继承或实现一个类或接口，增强了Java的封装性。
 *
 * @author <a href="https://github.com/tian-qingzhao">tianqingzhao</a>
 * @since 2025/9/27
 */
public class Test {

    public static void main(String[] args) {
        System.out.println(getShapeDescription(new Circle(4)));
    }

    public static String getShapeDescription(Shape shape) {
        return switch (shape) {
            case Circle c -> "圆形，面积: " + c.area();
            case Rectangle r -> "矩形，面积: " + r.area();
            case Triangle t -> "三角形，面积: " + t.area();
            // 编译器知道所有可能的子类，不需要default分支
        };
    }
}
