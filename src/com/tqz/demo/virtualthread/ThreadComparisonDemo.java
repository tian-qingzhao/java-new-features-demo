package com.tqz.demo.virtualthread;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 面对平台线程的局限性，Java 19（2022 年 9 月）正式引入虚拟线程（Virtual Threads），
 * 并在 Java 21 中成为稳定特性。它不是对平台线程的修补，而是一种全新的线程模型。
 *
 * <p>初始栈大小仅几百字节（平台线程是 MB 级），
 * 支持创建百万级甚至千万级线程（平台线程仅支持几千级），
 * 线程创建成本降低 99% 以上。
 *
 * <p>当虚拟线程执行阻塞操作（如网络 IO、文件读写）时，JVM 会自动将其 "挂起"，
 * 并将底层平台线程让给其他虚拟线程使用。这种 "阻塞即让出" 的特性，彻底解决了传统线程 "阻塞时浪费资源" 的问题。
 *
 * @author <a href="https://github.com/tian-qingzhao">tianqingzhao</a>
 * @since 2025/9/27
 */
public class ThreadComparisonDemo {

    private static final int TASK_COUNT = 10000; // 任务数量
    private static final int IO_DELAY = 10;      // 模拟IO延迟(毫秒)

    public static void main(String[] args) throws InterruptedException {
        System.out.println("任务数量: " + TASK_COUNT + ", IO延迟: " + IO_DELAY + "ms");

        // 测试普通线程
        long platformTime = measureTime(ThreadComparisonDemo::runWithPlatformThreads);
        System.out.printf("普通线程耗时: %d ms%n", platformTime);

        // 测试虚拟线程
        long virtualTime = measureTime(ThreadComparisonDemo::runWithVirtualThreads);
        System.out.printf("虚拟线程耗时: %d ms%n", virtualTime);

        // 计算性能提升百分比
        double improvement = (1.0 - (double) virtualTime / platformTime) * 100;
        System.out.printf("虚拟线程性能提升: %.2f%%%n", improvement);
    }

    // 普通线程测试
    private static void runWithPlatformThreads() {
        try (ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors())) {
            for (int i = 0; i < TASK_COUNT; i++) {
                executor.submit(ThreadComparisonDemo::simulateIoTask);
            }
        }
    }

    // 虚拟线程测试
    private static void runWithVirtualThreads() {
        try (ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor()) {
            for (int i = 0; i < TASK_COUNT; i++) {
                executor.submit(ThreadComparisonDemo::simulateIoTask);
            }
        }
    }

    // 模拟IO密集型任务
    private static void simulateIoTask() {
        try {
            Thread.sleep(IO_DELAY); // 模拟IO等待时间
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    // 计时辅助方法
    private static long measureTime(Runnable action) {
        Instant start = Instant.now();
        try {
            action.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Duration.between(start, Instant.now()).toMillis();
    }

}
