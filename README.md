# swagger2-springmvc

springmvc整合swagger2 请求list集合解析 返回泛型解析

返回对象解析参考：https://blog.csdn.net/appleren/article/details/80011951

> swagger是项目名

* springmvc 拦截/api/*的话 访问json地址是http://localhost:8080/swagger/api/v2/api-docs

* springmvc 拦截/的话 访问json地址是http://localhost:8080/swagger/v2/api-docs

> 支持mvn compile 直接生成json

> mybatis生成model带swagger注解

https://github.com/ciweigg2/mybatis-generator-plugins

> 新增漂亮的swagger2界面

github地址:https://gitee.com/xiaoym/swagger-bootstrap-ui

访问地址:http://localhost:8080/doc.html

集成:

```java
    <dependency>
      <groupId>com.github.xiaoymin</groupId>
      <artifactId>swagger-bootstrap-ui</artifactId>
      <version>1.8.6</version>
    </dependency>
```

Spring项目中启用swagger,代码如下：

swagger封装给出的请求地址默认是/v2/api-docs,所以swagger-bootstrap-ui调用后台也是/v2/api-docs,不能带后缀,且需返回json格式数据,框架如果是spring boot的可以不用修改,直接使用,如果是Spring MVC在web.xml中配置了DispatcherServlet,则需要追加一个url匹配规则,如下：

```java
<!--默认配置,.htm|.do|.json等等配置-->
<servlet-mapping>
	<servlet-name>cmsMvc</servlet-name>
 	<url-pattern>*.htm</url-pattern>
</servlet-mapping>
<!-- 配置swagger-bootstrap-ui的url请求路径-->
<servlet-mapping>
   <servlet-name>cmsMvc</servlet-name>
   <url-pattern>/v2/api-docs</url-pattern>
</servlet-mapping>
```

springboot框架可以开启ui高级排序功能：

@EnableSwaggerBootstrapUI

文档：http://www.xiaominfo.com/2018/08/29/swagger-bootstrap-ui-description/

