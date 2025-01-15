package demo.zjm._04_工厂方法模式.util;

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
    private Object data;

    public ResponseResult(String status, String message) {
        this.status = status;
        this.message = message;
    }

}
