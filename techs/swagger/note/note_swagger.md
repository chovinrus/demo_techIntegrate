#### Swagger, knife4j简介

Swagger是一款RESTFUL接口的文档在线自动生成+功能测试功能软件。

集成SpringFox只支持SpringBoot2.x，而基于Swagger的SpringDoc的社区现在十分活跃，版本不断更新。SpringFox自从2020年7月14号之后就不更新了。
SpringDoc也是Spring官方推荐的API。

```xml
<dependency>
    <groupId>org.springdoc</groupId>
    <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
    <version>2.4.0</version>
</dependency>
<dependency>
    <groupId>org.springdoc</groupId>
    <artifactId>springdoc-openapi-starter-webmvc-api</artifactId>
    <version>2.4.0</version>
</dependency>
```

``knife4j``是``springfox-swagger`的增强UI实现，为Java开发者在使用Swagger的时候，提供了简洁、强大的接口文档体验。knife4j完全遵循了springfox-swagger中的使用方式，并在此基础上做了增强功能，如果你用过Swagger，你就可以无缝切换到knife4j。

#### Swagger配置

[后端 API 接口文档 Swagger 使用指南 - 知乎 (zhihu.com)](https://zhuanlan.zhihu.com/p/98560871)