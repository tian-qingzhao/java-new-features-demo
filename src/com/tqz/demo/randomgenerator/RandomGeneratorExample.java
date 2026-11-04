package com.tqz.demo.randomgenerator;

import java.util.random.RandomGenerator;
import java.util.random.RandomGeneratorFactory;

/**
 * Java 17引入了强大的随机数生成器API，提供了更多算法选择和更好的性能。
 *
 * @author <a href="https://github.com/tian-qingzhao">tianqingzhao</a>
 * @since 2025/9/28
 */
public class RandomGeneratorExample {

    public static void main(String[] args) {
        // 获取默认实现
        RandomGenerator defaultRandom = RandomGenerator.getDefault();

        // 生成随机数
        System.out.println("随机整数: " + defaultRandom.nextInt(100));

        // 使用特定算法
        RandomGenerator xoroshiro = RandomGeneratorFactory.of("Xoroshiro128PlusPlus")
                .create(42); // 使用种子值

        // 生成随机序列
        xoroshiro.ints(10, 1, 100)
                .forEach(n -> System.out.print(n + " "));

        // 列出所有可用算法
        System.out.println("\n可用随机数生成器算法:");
        RandomGeneratorFactory.all()
                .map(factory -> factory.name())
                .sorted()
                .forEach(System.out::println);
    }
}