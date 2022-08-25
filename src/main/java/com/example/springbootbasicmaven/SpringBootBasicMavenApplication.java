package com.example.springbootbasicmaven;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;

import java.util.Arrays;

@SpringBootApplication
public class SpringBootBasicMavenApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootBasicMavenApplication.class, args);

	}
@Bean
public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
	return args -> {

		System.out.println("Let's inspect the beans provided by Spring Boot:");

		YYY beanName = (YYY) ctx.getBean("YYY");
		System.out.println(beanName.sayHello());

		ConfigurableApplicationContext context = (ConfigurableApplicationContext)ctx;
		DefaultListableBeanFactory beanFactory = (DefaultListableBeanFactory)context.getBeanFactory();
		BeanDefinitionBuilder builder = BeanDefinitionBuilder.rootBeanDefinition(YourClass.class);
		beanFactory.registerBeanDefinition("YourClass", builder.getBeanDefinition());
		YourClass beanName1 = (YourClass) ctx.getBean("YourClass");
		System.out.println(beanName1.sayHello());

	};
}

}
