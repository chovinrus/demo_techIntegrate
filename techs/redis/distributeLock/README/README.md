#### redis数据并发问题
不加锁肯定出现并发错误，加锁分别在节点本身加完全不够
```java
@GetMapping("test")
    public String test(){
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                try(Jedis jedis = new Jedis("192.168.172.137", 6382)){
                    for (int j = 0; j < 100; j++) {   //每个客户端获取a然后增加a的值再写回去，如果不加锁那么肯定会出问题
                        int a = Integer.parseInt(jedis.get("a")) + 1;
                        jedis.set("a", a+"");
                    }
                }
            }).start();
        }
        return "completed";
    }
```

