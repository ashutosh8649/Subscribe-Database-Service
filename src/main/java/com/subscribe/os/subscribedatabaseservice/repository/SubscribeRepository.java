package com.subscribe.os.subscribedatabaseservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.subscribe.os.subscribedatabaseservice.subscribeBean.SubscribeBean;

public interface SubscribeRepository extends MongoRepository<SubscribeBean, Integer>{

}
