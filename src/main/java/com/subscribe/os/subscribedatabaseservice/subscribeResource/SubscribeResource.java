package com.subscribe.os.subscribedatabaseservice.subscribeResource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.subscribe.os.subscribedatabaseservice.repository.SubscribeRepository;
import com.subscribe.os.subscribedatabaseservice.subscribeBean.SubscribeBean;

@RestController
@RequestMapping("/rest/subscribe")
public class SubscribeResource {


	private SubscribeRepository subscribeRepository;
	
    public SubscribeResource(SubscribeRepository subscribeRepository) {
        this.subscribeRepository = subscribeRepository;
    }
    
    @GetMapping(value="/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public SubscribeBean getAll() {
        return new SubscribeBean(2,10,"shirt");
    }
    
/*    @GetMapping(value="/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<SubscribeBean> getAll() {
        return subscribeRepository.findAll();
    }*/
/*    @GetMapping(value="/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<SubscribeBean>String getAll() {
        //return subscribeRepository.findAll();
    	return "hello";
    }*/
    
	@PostMapping("/add-subscribeBean")
	public Boolean addSubscribeBean(@RequestBody SubscribeBean subscribeBean) {
		Optional<SubscribeBean> option = subscribeRepository.findById(subscribeBean.getUserId());

		if(option.isPresent()) {
			if(option.get().getCategory().equals(subscribeBean.getCategory())) {
				return false;
			} 
		}
		subscribeRepository.save(subscribeBean);
		return true;
	}
	
	@DeleteMapping("/del/{userId}")
	public void del(@PathVariable("userId") Integer userId) {
		subscribeRepository.deleteById(userId);
		
	}

	

}
