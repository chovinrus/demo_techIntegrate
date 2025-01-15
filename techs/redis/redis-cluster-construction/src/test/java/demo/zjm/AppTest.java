package demo.zjm;


import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

/**
 * Unit test for simple App.
 */
@SpringBootTest
public class AppTest {

    @Test
    public void test() {
        //List<String> list = new ArrayList<>();
        //list.add("192.168.172.137:6380");
        //list.add("192.168.172.137:6381");
        //list.add("192.168.172.137:6382");
        //try (JedisSentinelPool pool = new JedisSentinelPool("mymaster",
        //        new HashSet<>(list))) {
        //    Jedis jedis = pool.getResource();   //获取master节点
        //    jedis.set("test", "114514");    //直接写入即可，实际上就是向Master节点写入
        //    Jedis jedis2 = pool.getResource();   //再次获取
        //    System.out.println(jedis2.get("test"));   //读取操作
        //} catch (Exception e) {
        //    e.printStackTrace();
        //}

        try (JedisCluster cluster = new JedisCluster(new HostAndPort("192.168.172.137", 6380))) {
            System.out.println("集群实例数量：" + cluster.getClusterNodes().size());//6
            cluster.set("a", "yyds");
            System.out.println(cluster.get("a"));//yyds
        }
    }
}
