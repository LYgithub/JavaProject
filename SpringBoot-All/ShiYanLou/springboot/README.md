## SpringBoot

### 配置方式

1. application.properties 文件
    - 创建 配置文件
    - 使用 @value("${key}") 方式自动注入
    
2. Java配置
    - 创建 配置类， 实现`WebServerFactoryCustomizer<ConfigurableWebServerFactory>`
    - 添加 `@Configuration` 注解 , 被`@ComponentScan`扫描 
3. xml 配置
    - 创建 Xml文件
    - 在启动类前，使用 `@ImportResource(value = "classpath:config.xml")` 加载


### 静态资源路径

> SpringBoot 的静态资源默认路径为 /static /public /resource META-INF/resource
> 默认映射路径 都是 /
> 搜索顺序  META-INF/resource > resource > static > public 

**自定义 静态资源路径**

1、实现`WebMvcConfigurer` 接口的 `addResourceHandlers` 方法来自定义静态资源
```java
import org.springframework.context.annotation.Configuration;import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class WebConfig implements WebMvcConfigurer{
    @Override
        public void addResourceHandlers(ResourceHandlerRegistry registry) {
            // 将 /upload/ 路径 映射为 /**
            registry.addResourceHandler("/**")
                    .addResourceLocations(
                            "classpath:/static/upload/",
                            "classpath:/static/css/",
                            "classpath:/static/");
        }
}
```
2、设置配置 application.properties 
    `spring.resources.static-locations = classpath:/static`
