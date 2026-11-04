package com.tqz.demo.textblocks;

/**
 * Java 17 文本块提供了更好的多行字符串表示方式，特别适合SQL、HTML等内容。
 *
 * @author <a href="https://github.com/tian-qingzhao">tianqingzhao</a>
 * @since 2025/9/27
 */
public class TextBlocksExample {

    public static void main(String[] args) {
        // 传统多行字符串
        String oldHtml = "<html>\n" +
                "    <body>\n" +
                "        <p>Hello, World!</p>\n" +
                "    </body>\n" +
                "</html>";

        // 使用文本块
        String html = """
                <html>
                    <body>
                        <p>Hello, World!</p>
                    </body>
                </html>
                """;

        // SQL查询示例
        String query = """
                SELECT id, name, email
                FROM users
                WHERE status = 'active'
                  AND last_login > DATE_SUB(NOW(), INTERVAL 30 DAY)
                ORDER BY name ASC
                """;

        // JSON示例
        String json = """
                {
                    "name": "张三",
                    "age": 30,
                    "address": {
                        "city": "北京",
                        "district": "海淀"
                    },
                    "skills": ["Java", "Spring", "Kubernetes"]
                }
                """;
    }
}