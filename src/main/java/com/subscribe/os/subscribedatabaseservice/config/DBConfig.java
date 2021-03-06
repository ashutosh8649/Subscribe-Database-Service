package com.subscribe.os.subscribedatabaseservice.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.subscribe.os.subscribedatabaseservice.repository.SubscribeRepository;
import com.subscribe.os.subscribedatabaseservice.subscribeBean.SubscribeBean;

@EnableMongoRepositories(basePackageClasses = SubscribeRepository.class)
@Configuration
public class DBConfig {
	
/*    @Bean
    CommandLineRunner commandLineRunner(SubscribeRepository subscribeRepository) {
        return strings -> {
        	subscribeRepository.save(new SubscribeBean(1,3,"saree"));
        	subscribeRepository.save(new SubscribeBean(2,10,"shirt"));
        };
    }*/

}
