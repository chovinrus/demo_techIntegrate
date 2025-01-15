package demo.zjm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;

/**
 * @program: demo_techIntegrate
 * @ClassName: Controller
 * @description:
 * @author: AlanMa
 * @create: 2024-03-28 09:42
 */
@RestController
@RequestMapping
public class TestController {

    @Autowired
    StringRedisTemplate stringRedisTemplate;
    @GetMapping("test")
    public String test() {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                try (Jedis jedis = new Jedis("192.168.172.137", 6382)) {
                    for (int j = 0; j < 100; j++) {   //每个客户端获取a然后增加a的值再写回去，如果不加锁那么肯定会出问题
                        int a = Integer.parseInt(jedis.get("a")) + 1;
                        jedis.set("a", a + "");
                        System.out.println("a" + a);
                    }
                }
            }).start();
        }
        return "completed";
    }


}
