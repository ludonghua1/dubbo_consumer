package com.yitian.dubbo_provider;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

@SpringBootApplication
public class DubboProviderApplication {

	public static void main(String[] args) throws IOException {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"spring-dubbo-provider.xml"});
		context.start();
		System.in.read();
	}

}

