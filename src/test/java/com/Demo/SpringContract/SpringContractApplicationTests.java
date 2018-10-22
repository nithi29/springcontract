package com.Demo.SpringContract;

import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.setup.StandaloneMockMvcBuilder;

import com.Demo.SpringContract.Controller.UserController;
import com.Demo.SpringContract.Service.UserService;
import com.Demo.SpringContract.Service.Util.ApplicationException;
import com.Demo.SpringContract.User.User;
import static org.mockito.Mockito.any;
import io.restassured.module.mockmvc.RestAssuredMockMvc;

@RunWith(SpringRunner.class)
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@Ignore
@SpringBootTest(classes = SpringContractApplication.class)
public class SpringContractApplicationTests {
    @Autowired 
    UserController userController;

    @MockBean
    private UserService userService;
    
    @Before 
    public void setup() throws ApplicationException {
        User savedUser = new User();
        savedUser.setUserid(44);
        savedUser.setFirstName("nithii");
        savedUser.setLastName("nithi");
        savedUser.setEmail("nith@gmail.com");
        // ?
        when(userService.save(any(User.class))).thenReturn(savedUser);  
        when(userService.getById(Mockito.anyInt())).thenReturn(savedUser);
        when(userService.update(any(User.class))).thenReturn(savedUser);
        StandaloneMockMvcBuilder standaloneMockMvcBuilder = MockMvcBuilders.standaloneSetup(userController);
        RestAssuredMockMvc.standaloneSetup(standaloneMockMvcBuilder);    
    }
	@Test
	public void contextLoads() {	   
	}
    
}
