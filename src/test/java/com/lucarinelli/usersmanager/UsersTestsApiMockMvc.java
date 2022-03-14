package com.lucarinelli.usersmanager;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.lucarinelli.usersmanager.controller.UsersController;
import com.lucarinelli.usersmanager.dto.UsersResponseDto;
import com.lucarinelli.usersmanager.service.UsersService;

import org.apache.catalina.User;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class UsersTestsApiMockMvc {
	
	@Autowired
	private MockMvc mockMvc;

	@Mock
	private UsersService service;
    
    @Test
	public void testGetAll() throws Exception {
		List<UsersResponseDto> users = new ArrayList<UsersResponseDto>();
		when(service.getAll()).thenReturn(users);
		mockMvc.perform(MockMvcRequestBuilders.get("/users")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}

}
