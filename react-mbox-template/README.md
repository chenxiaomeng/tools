# React Mbox

## 介绍

这是一个使用Create-React-App创建的脚手架，集成自定义Babel Plugin，使用Mbox管理状态，集成Antd组件库，集成Fetch和Lodash工具库，添加WebDevServer代理配置。

## 内容详解

### Yarn
[参考文档](https://github.com/yarnpkg/yarn)
Yarn是一个快速，可靠，安全的依赖管理工具。相比较NPM在包的版本管理上更加方便易用，NPM自动更新小版本非常麻烦。

### Create-React-App

[参考文档](https://github.com/facebook/create-react-app)
使用命令
```
yarn install -g create-react-app
create-react-app ${project-name}
cd ${project-name}
yarn run eject
```
Eject是打开CRA的配置内容，用于自定义配置，不好的地方在于无法自动更新React-Scripts，使用新特性。
如果代码使用了版本管理，eject之前需要先提交代码。

### Babel

[参考文档](https://github.com/babel/babel)
1. 项目下新增.babelrc文件
2. 文件中新增以下内容
```
{
    "presets": [
        "react-app", 
        "es2015",
        "react",
        "stage-1"
    ],
    "plugins": ["transform-decorators-legacy", 
        "transform-object-rest-spread", 
        ["import", { "libraryName": "antd", "style": "css" }]
    ]
}
```
3. 相关说明：
  presets:
  react-app是加载React相关的解析模块，例如编译Jsx，默认create-react-app会增加该依赖
  es2015是为了浏览器兼容Es6语法
  [stage-1](https://babeljs.io/docs/plugins/preset-stage-1/)是目前建议的，虽然stage-0更强大。
  plugins:
  transform-decorators-legacy是为了使用es7中的装饰器模式，主要是@这个关键字
  transform-object-rest-spread是为了使用es6中的Rest参数
  import是为了分模块加载antd的模块
4. 安装相关依赖
```
yarn add babel-preset-es2015 babel-preset-stage-1 babel-plugin-transform-decorators-legacy babel-plugin-transform-object-rest-spread babel-plugin-import
```

### 组件库和工具库

[Fetch](https://github.com/github/fetch)，目前非常适合与服务器交换数据的工具库，与[其他工具对比](https://gist.github.com/hedleysmith/15fa60fda5ef4369636a4b23e018dc8f)，create-react-app默认使用了该依赖
[Antd](https://ant.design/index-cn)，目前非常流行的一款React组件库
[Lodash](https://lodash.com/)，目前非常流行的基础工具库
[Autobind](https://github.com/andreypopp/autobind-decorator)，目前非常棒的一款自动bind this的装饰器
安装
```
yarn add antd lodash autobind-decorator
```

### Mobx

[参考文档](https://github.com/mobxjs/mobx)
[新手入门](http://cn.mobx.js.org/)
需要与React绑定
```
yarn add mobx mobx-react
```