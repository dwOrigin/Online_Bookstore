package com.springboot.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.ResourceServlet;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
@MapperScan("com.houduan.mapper")
public class MybatisPlusConfig {
    /**
     * Druid数据库连接池
     * @Bean("druidDataSource"):标注这是一个Bean对象
     * @Primary:如果Spring IOC容器中出现了相同类型的bean对象  优先使用这个
     * @ConfigurationProperties(prefix = "spring.datasource.druid"):
     *      读取springboot核心配置文件中的属性值 前缀必须为  spring.datasource.druid
     */
    @Bean("druidDataSource")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.druid")
    public DataSource druidDataSource(){
        return  new DruidDataSource();
    }

    /**
     * 注册一个Servlet ,把Druid提供的监控Servlet注册进去，并提供一个访问路径,用户名和密码
     * 当前自定义Servlet的注册方式一致，你也可以在web.xml中配置，只是SpringBoot项目中不建议这么做
     * @return
     */
    @Bean
    public ServletRegistrationBean druidStatViewServlet(){
        //监控界面Servlet的访问设置，访问路劲为根目录下的/druid/**,Druid数据源提供了一套显示页面，StatViewServlet，只需要注入即可，
        ServletRegistrationBean servletRegistration = new ServletRegistrationBean(new StatViewServlet(),"/druid/*");
        //添加Servlet的初始值，访问这个监控界面的用户名和密码，如果不配置，则默认不需要密码，不显示登录界面
        servletRegistration.addInitParameter(ResourceServlet.PARAM_NAME_USERNAME,"admin");
        servletRegistration.addInitParameter(ResourceServlet.PARAM_NAME_PASSWORD,"admin");
        return servletRegistration;
    }

    /**
     * 过滤器注册，需要配置Druid监控器需要监控的请求和操作
     * 配置一下过滤规则，让静态资源和它自己的视图界面不拦截
     * @return
     */
    @Bean
    public FilterRegistrationBean druidStatFilter(){
        //那些信息要监控，需要定义该过滤器来进行拦截，Druid是数据源，当然只拦截请求操作了，静态资源需要放行
        FilterRegistrationBean filterRegistration = new FilterRegistrationBean(new WebStatFilter());
        //过滤器拦截路径
        filterRegistration.addUrlPatterns("/*");   //拦截所有请求
        //不拦截的请求
        filterRegistration.addInitParameter(WebStatFilter.PARAM_NAME_EXCLUSIONS,"*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        return filterRegistration;
    }

    // 最新版
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
        return interceptor;
    }

}
