#### IDEA连接docker服务

1 exit config  
2 选择tcp连接  
3 输入连接的url `tcp://192.168.172.137:2375`

#### 打开监控

访问`ip:9000`  
用户名：`amind` 密码：`@Lindaiyv1998；`

#### 查看镜像的信息inspect，查看文件夹

在dashboard的右侧的省略号打开

/usr/local/etc/redis.conf

#### IDEA快速创建镜像
先创建docker configration再创建container，因为config非常方面修改创建镜像的参数和选项，改一改就能快速创建多个docker镜像了

不仅如此还可以快速复制config，创建镜像同时保留镜像的配置信息方便快速创建

#### 拉取镜像
```dockerfile
docker pull 镜像名
```