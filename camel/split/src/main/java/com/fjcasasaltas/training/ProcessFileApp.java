package com.fjcasasaltas.training;

import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ProcessFileApp {

	private static final Logger log = LoggerFactory.getLogger(ProcessFileApp.class);
	
	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("/META-INF/spring/applicationContext.xml");
		CamelContext camelContext = applicationContext.getBean(CamelContext.class);
		ProducerTemplate producer = camelContext.createProducerTemplate();
		
		log.info("Starting process...");
		producer.requestBody("direct:start", new Object());
		log.info("Process finished");
		
		applicationContext.close();
		
	}
	
}
