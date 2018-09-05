package impl;

import api.*;
import org.coodex.concrete.core.intercept.ConcreteInterceptor;
import org.coodex.concrete.core.intercept.RBACInterceptor;
import org.coodex.concrete.core.token.TokenManager;
import org.coodex.concrete.core.token.local.LocalTokenManager;
import org.coodex.concrete.spring.ConcreteSpringConfiguration;
import org.coodex.concrete.spring.aspects.ConcreteAOPChain;
import org.coodex.concrete.support.jsr339.ConcreteJaxrs339Application;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.logging.LoggingFeature;
import org.glassfish.jersey.servlet.ServletContainer;
import org.glassfish.jersey.servlet.ServletProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.*;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication //声明一个spring boot application，也就是说，这是一个spring boot框架定义中的微服务
@Configuration
@EnableAspectJAutoProxy //同 <aop:aspectj-autoproxy/>
@ImportResource("classpath:spring-data-env.xml")
@Import(ConcreteSpringConfiguration.class)// 同<bean class="org.coodex.concrete.spring.ConcreteSpringConfiguration"/>
public class SpringBootWithoutXML extends SpringBootServletInitializer{

    private List<ConcreteInterceptor> interceptors() {
        List<ConcreteInterceptor> interceptors = new ArrayList<>();
        interceptors.add(new RBACInterceptor());//rbac 切片
        return interceptors;
    }


    // 同切片链的定义方式，参见 https://book.concrete.coodex.org/%E5%B7%A5%E5%85%B7%E9%93%BE/Aspects.html#切片链方式
    @Bean
    public ConcreteAOPChain aspects() {
        return new ConcreteAOPChain(interceptors());
    }


    // 同  <bean class="org.coodex.concrete.core.token.local.LocalTokenManager"/>
    @Bean
    public TokenManager getTokenManger() {
        return new LocalTokenManager();
    }

    /**
     * jaxrs规范的Application
     */
    public static class ExampleApplication extends ConcreteJaxrs339Application{

        public ExampleApplication() {
            register(JacksonFeature.class,// 使用jersey的jackson插件序列化
                    LoggingFeature.class,
                    ExampleApi.class,
                    SelectOwnerInfo.class,
                    SelectAllOwnerInfoService.class,
                    DeleteOwnerInfoService.class,
                    UpdateOwnerInfoService.class,
                    AddOwnerInfoService.class,
                    AddChangeInfoService.class,
                    SelectChangeInfoService.class
                    );// 注册服务Api，需要发布哪些服务就注册哪些，也可以使用registerPackage按包注册

        }
    }

    @Bean
    public ExampleApi getExampleApi(){
        return new ExampleImpl();
    }

    @Bean
    public SelectOwnerInfo getSelectOwnerInfo(){
        return new SelectOwnerInfoImpl();
    }

    @Bean
    public SelectAllOwnerInfoService getAllOwnerInfo(){return new SelectAllOwnerInfoServiceImpl();}

    @Bean
    public DeleteOwnerInfoService deleteOwnerInfo(){return new DeleteOwnerInfoServiceImpl();}

    @Bean
    public UpdateOwnerInfoService updateOwnerInfo(){return new UpdateOwnerInfoServiceImpl();}

    @Bean
    public AddOwnerInfoService addOwnerInfo(){return new AddOwnerInfoServiceImpl();}

    @Bean
    public AddChangeInfoService addChangeInfo(){return new AddChangeInfoServiceImpl();}

    @Bean
    public SelectChangeInfoService selectChangeInfo(){return new SelectChangeInfoServiceImpl();}

    @Bean
    public ServletRegistrationBean testServlet() {
        ServletContainer container = new ServletContainer();
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(
                container, "/jaxrs/*");
        registrationBean.addInitParameter(ServletProperties.JAXRS_APPLICATION_CLASS,
                ExampleApplication.class.getName());
        registrationBean.setName("demo");
        registrationBean.setAsyncSupported(true);
        return registrationBean;
    }


    public static void main(String [] args){
        // 设为前后端分离开发模式
       /* System.setProperty("org.coodex.concrete.jaxrs.devMode", "true");*/
        SpringApplication.run(SpringBootWithoutXML.class, args);
    }

}