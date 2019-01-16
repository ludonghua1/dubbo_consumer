package com.yitian.dubbo_consumer;

import com.yitian.service.HelloService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class DubboConsumerApplication {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"spring-dubbo-consumer.xml"});
		context.start();
		HelloService helloService = (HelloService) context.getBean("helloService");
		helloService.say("jack");
	}

}

