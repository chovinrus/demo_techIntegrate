package demo.zjm;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import redis.clients.jedis.Jedis;

/**
 * Unit test for simple App.
 */
@SpringBootTest
public class AppTest {
    @Test
    public void test(){

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                try(Jedis jedis = new Jedis("192.168.0.10", 6379)){
                    for (int j = 0; j < 100; j++) {   //每个客户端获取a然后增加a的值再写回去，如果不加锁那么肯定会出问题
                        int a = Integer.parseInt(jedis.get("a")) + 1;
                        jedis.set("a", a+"");
                    }
                }
            }).start();
        }


        //ArrayList<String> nodes = new ArrayList<>();
        //nodes.add("redis://192.168.172.137:6380");
        //nodes.add("redis://192.168.172.137:6381");
        //nodes.add("redis://192.168.172.137:6382");
        //nodes.add("redis://192.168.172.137:6383");
        //nodes.add("redis://192.168.172.137:6384");
        //nodes.add("redis://192.168.172.137:6385");
        //Config config = new Config();
        //config.useClusterServers()
        //        .setNodeAddresses(nodes);   //配置连接的Redis服务器，也可以指定集群

        //RedissonClient client =  Redisson.create(config);   //从Netty的config来创建RedissonClient客户端
        //for (int i = 0; i <  10; i++) {
        //    new Thread(() -> {
        //        try(Jedis jedis = new Jedis("192.168.172.137", 6380)){
        //            RLock lock = client.getLock("testLock");    //指定锁的名称，拿到锁对象
        //            for (int j = 0; j < 100; j++) {
        //                lock.lock();    //加锁
        //                int a = Integer.parseInt(jedis.get("a")) + 1;
        //                jedis.set("a", a+"");
        //                lock.unlock();   //解锁
        //            }
        //        }
        //        System.out.println("结束！");
        //    }).start();
        //}
    }
}