package demo.zjm._05_抽象工厂模式.util;

import lombok.Data;

/**
 * @program: DesignPattern
 * @ClassName: ResponseResult
 * @description:
 * @author: AlanMa
 * @create: 2024-01-06 10:12
 */
@Data
public class ResponseResult {
    private String status; // 状态码
    private String message; // 信息

    public ResponseResult(String status, String message) {
        this.status = status;
        this.message = message;
    }

}
