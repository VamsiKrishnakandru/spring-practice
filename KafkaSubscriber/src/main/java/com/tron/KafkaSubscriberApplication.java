package com.tron;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;

import com.tron.util.AppConstants;

@SpringBootApplication
public class KafkaSubscriberApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaSubscriberApplication.class, args);
	}
	
	@KafkaListener(topics=AppConstants.TOPIC_NAME, groupId="group_tron_customer")
	public void subscribeMsgFromKafkaTopic(String cxData)
	{
		System.out.println("Message is coming from kafka server");
		System.out.println(cxData);
	}

}
