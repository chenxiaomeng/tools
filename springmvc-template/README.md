# SpringMVC Maven Archetype

## 介绍

这是一个用于生成springmvc项目的脚手架，该脚手架是springmvc，swagger，myabtis，log4j2等最佳实践的脚手架。

## 使用教程
参考[maven archetype plugin](https://maven.apache.org/archetype/maven-archetype-plugin/advanced-usage.html)介绍
Install Archetype
```
    mvn archetype:create-from-project
    cd target/generated-sources/archetype
    mvn install
```
Generate Project
```
    cd /tmp/
    mvn archetype:generate -DarchetypeCatalog=local
```

## 内容说明

### 三层结构
Module，Service，Controller是目前非常流行的分层方式。虽然带来一定的结构复杂性，但是好处也是非常显而易见

### ORM - Mybatis
[Mybatis](http://www.mybatis.org/mybatis-3/)是目前非常火爆的ORM框架，相比较Hibernate更加轻量级，并且拥有相对成熟的配套解决方案。

### MVC - SpringMVC
[SpringMVC](https://docs.spring.io/spring/docs/4.3.x/spring-framework-reference/html/)是目前应该最广泛的MVC框架，相比较struct，jersy，SpringMVC有强大的团队支持，并且有一整套开发解决方案。相比较于SpringBoost，多了很多需要手动处理的配置，但是是有tomcat容器通用的端口更加易维护，并且发布的包更小。

### APIDOC - Swagger
[Swagger](https://swagger.io/)是目前应用非常广泛的API框架，用于生成API接口文档。

### Log - log4j2
[log4j2](https://logging.apache.org/log4j/2.x/)是一个接口更加灵活，性能更加好的日志模块。
