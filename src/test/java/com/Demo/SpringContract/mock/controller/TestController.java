package com.Demo.SpringContract.mock.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.Demo.SpringContract.Controller.UserController;
import com.Demo.SpringContract.Service.UserService;
import com.Demo.SpringContract.User.User;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(MockitoJUnitRunner.class)
public class TestController {

    @Mock
    private UserService userService;

    MockMvc mockMvc;

    @InjectMocks
    private UserController controller = new UserController();

    @Before
    public void init() {
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void nothingtest() {
        System.out.println("success on test run");
    }

    @Test
    public void testGetById() throws Exception {
        User user = new User();
        user.setUserid(1);
        user.setFirstName("nithi");
        user.setLastName("sn");
        user.setEmail("nithi@gm.com");
        Mockito.when(userService.getById(1)).thenReturn(user);
        mockMvc.perform(MockMvcRequestBuilders.get("/users/{userid}", 1))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.userid").value(1));
    }

    @Test
    public void testSaveUser() throws Exception {
        User user = new User();
        // user.setUserid(1);
        user.setFirstName("nithi");
        user.setLastName("sn");
        user.setEmail("nithi@gm.com");
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writeValueAsString(user);
        Mockito.when(userService.save(Mockito.any(User.class))).thenReturn(user);
        mockMvc.perform(MockMvcRequestBuilders.post("/new").content(jsonString).contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(201)).andReturn();
        // Assert.assertEquals(201, result.getResponse().getStatus());
    }

    @Test
    public void testUpdateUser() throws Exception {
        User user = new User();
        user.setUserid(1);
        user.setFirstName("nithi");
        user.setLastName("sn");
        user.setEmail("nithi@gm.com");

        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writeValueAsString(user);
        Mockito.when(userService.getById(Mockito.anyInt())).thenReturn(user);
        Mockito.when(userService.update(Mockito.any(User.class))).thenReturn(user);
        mockMvc.perform(MockMvcRequestBuilders.put("/users/{userid}", 1).content(jsonString)
                .contentType(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().is2xxSuccessful());

    }

    @Test
    public void testDeleteUser() throws Exception {
        User user = new User();
        user.setUserid(1);
        user.setFirstName("nithi");
        user.setLastName("sn");
        user.setEmail("nithi@gm.com");

        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writeValueAsString(user);
        Mockito.doNothing().when(userService).delete(Mockito.anyInt());
        mockMvc.perform(
                MockMvcRequestBuilders.delete("/users/1").content(jsonString).contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
    }
}
