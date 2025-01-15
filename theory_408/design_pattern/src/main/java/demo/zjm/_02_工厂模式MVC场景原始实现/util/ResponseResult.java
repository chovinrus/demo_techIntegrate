package demo.zjm._02_工厂模式MVC场景原始实现.util;

/**
 * @program: DesignPattern
 * @ClassName: ResponseResult
 * @description:
 * @author: AlanMa
 * @create: 2024-01-06 10:12
 */
public class ResponseResult {
    private String status; // 状态码
    private String message; // 信息

    public ResponseResult(String status, String message) {
        this.status = status;
        this.message = message;
    }
}
