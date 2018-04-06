package com.subscribe.os.subscribedatabaseservice.testController;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Arrays;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.subscribe.os.subscribedatabaseservice.subscribeBean.SubscribeBean;
import com.subscribe.os.subscribedatabaseservice.subscribeResource.SubscribeResource;

@RunWith(SpringJUnit4ClassRunner.class)
public class TestSubscribeResource {



    private MockMvc mockMvc;

    @Mock
    private SubscribeBean subscribeBean;
    
    
    @InjectMocks
    private SubscribeResource subscribeResource;


	//private List<SubscribeBean> subscribeBeans;


    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(subscribeResource)
                .build();
        //subscribeBeans=Arrays.asList(new SubscribeBean(2,10,"shirt"));
        
    }
    
    @Test
    public void testHelloWorld() throws Exception {

    	System.out.println("hello");
    	System.out.println(subscribeBean);

        mockMvc.perform(get("/rest/subscribe/all").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.userId", Matchers.is(2)))
                .andExpect(jsonPath("$.vendorId", Matchers.is(10)))
                .andExpect(jsonPath("$.category", Matchers.is("shirt")));

    }
    
/*    @Test
    public void testHelloWorld() throws Exception {

        when(subscribeResource.getAll()).thenReturn("hello");

        mockMvc.perform(get("/rest/subscribe/all"))
                .andExpect(status().isOk())
                .andExpect(content().string("hello"));

        verify(subscribeResource).getAll();
    }*/
    
/*    @Test
    public void testGetAll() throws Exception{

    	mockMvc.perform(get("/rest/subscribe/all").accept(MediaType.APPLICATION_JSON))
    			.andExpect(status().isOk())
                .andExpect(jsonPath("$.userId", Matchers.is("2")))
                .andExpect(jsonPath("$.vendorId", Matchers.is("10")))
                .andExpect(jsonPath("$.category", Matchers.is("shirt")));
    	}*/
}
	