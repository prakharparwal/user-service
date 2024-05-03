package com.versed.app.userservice.controller;

import com.versed.app.userservice.data.User;
import com.versed.app.userservice.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class UserServiceControllerTest {

    @InjectMocks
    private UserServiceController userServiceController;

    @Mock
    private UserService service;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(userServiceController).build();
    }

    @Test
    void shouldReturn200WithAllUsers() throws Exception {

        when(service.getAllUsers()).thenReturn(List.of(new User(1, "Test User")));

        MvcResult response = mockMvc.perform(MockMvcRequestBuilders
                        .get("/users/all")
                        .accept(MediaType.APPLICATION_JSON)).andReturn();

        assertEquals(HttpStatus.OK.value(), response.getResponse().getStatus());
        assertEquals("""
                [{"id":1,"name":"Test User"}]""", response.getResponse().getContentAsString());
    }
}