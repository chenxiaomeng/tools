# SpringMVC Maven Archetype

## 介绍

这是一个用于生成springmvc项目的脚手架，是springmvc，swagger，myabtis，log4j2等工具最佳实践的脚手架。

## 使用教程

参考[maven archetype plugin](https://maven.apache.org/archetype/maven-archetype-plugin/advanced-usage.html)

Install Archetype
```
mvn clean
mvn archetype:create-from-project
cd target/generated-sources/archetype
mvn install
```
Generate Project
```
cd /tmp/
mvn archetype:generate -DarchetypeCatalog=local
```

备注：**生成的项目一定设置version为1.0**

## 内容详解

### 三层结构

Module，Service，Controller是目前非常流行的分层方式。虽然结构的复杂性，但是好处也是显而易见的。

1. 清晰的分层结构，可以更加方便的解耦代码和阅读代码。
2. 抽取出来的Module层可以作为Dubbo服务的Client，只包含Entity，Constant以及Interface。
3. 抽取出来的Service层，是核心的处理模块，服务依赖和业务处理都在在这层，并且能单独提供单测能力。
4. 抽取出来的Controller层，是对外的Rest层，可以方便的替换为SpringBoot。

```
├─controller
│  └─src
│      ├─main
│      │  ├─java
│      │  │  └─com
│      │  │      └─cxm
│      │  │          └─springmvc
│      │  │              ├─controller
│      │  │              ├─i18n
│      │  │              └─interceptor
│      │  ├─resources
│      │  │  ├─i18n
│      │  │  └─spring
│      │  └─webapp
│      │      └─WEB-INF
│      └─test
│          ├─java
│          │  └─com
│          │      └─cxm
│          │          └─springmvc
│          │              └─controller
│          └─resources
│              └─spring-test
├─module
│  └─src
│      └─main
│          ├─java
│          │  └─com
│          │      └─cxm
│          │          └─springmvc
│          │              ├─constant
│          │              ├─entity
│          │              └─service
│          └─resources
└─service
    └─src
        ├─main
        │  ├─java
        │  │  └─com
        │  │      └─cxm
        │  │          └─springmvc
        │  │              ├─mapper
        │  │              ├─service
        │  │              │  └─impl
        │  │              └─util
        │  └─resources
        │      └─spring
        └─test
            ├─java
            │  └─com
            │      └─cxm
            │          └─springmvc
            │              └─service
            │                  └─impl
            └─resources
                └─spring-test

```

### ORM - Mybatis
[Mybatis](http://www.mybatis.org/mybatis-3/)是目前非常火爆的ORM框架，相比较Hibernate更加轻量级，并且拥有相对成熟的配套解决方案。

1. [Mybatis-Generator](http://www.mybatis.org/generator/)是一个生成单表的增删改查操作的插件。生成的单表查询操作易用强大。多表操作集中在Service层代码处理，尽量不使用Join操作，这样在可能扩展的分库分表方案上极有优势。
2. [Page-Helper](https://github.com/pagehelper/Mybatis-PageHelper)是一个非常易用的数据库分页插件，支持的数据库类型覆盖常用数据库。
3. [Druid](https://github.com/alibaba/druid)是一个提供监控的数据库链接池，并且相比较C3P0更加稳定。

### MVC - SpringMVC
[SpringMVC](https://docs.spring.io/spring/docs/4.3.x/spring-framework-reference/html/)是目前应该最广泛的MVC框架，相比较Struct和Jersy，SpringMVC有强大的团队支持，并且有一整套开发解决方案。相比较于SpringBoot，多了很多需要手动处理的配置，但是Tomcat容器通用的端口更加易维护，并且发布的包更小。

### APIDOC - Swagger
[Swagger](https://swagger.io/)是目前应用非常广泛的API生成框架，用于生成API接口文档。集成方便简洁。

### Log - Log4j2
[Log4j2](https://logging.apache.org/log4j/2.x/)是一个接口更加灵活，性能更加好的日志模块。推荐使用
