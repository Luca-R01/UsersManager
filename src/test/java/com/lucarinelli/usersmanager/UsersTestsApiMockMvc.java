/*package com.lucarinelli.usersmanager;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.io.IOException;

import com.lucarinelli.usersmanager.controller.UsersController;
import com.lucarinelli.usersmanager.dto.UsersRequestDto;
import com.lucarinelli.usersmanager.mapper.JsonUtil;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


@ExtendWith(SpringExtension.class)
@WebMvcTest(UsersController.class)
@WebAppConfiguration
public class UsersTestsApiMockMvc {
	
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private UsersController controller;

	private static UsersRequestDto user1 = new UsersRequestDto();
	private static UsersRequestDto user2 = new UsersRequestDto();

	@BeforeAll
	static void setup(){
		user1.setCodiceFiscale("1234567890123456");
		user1.setNome("Nome");
		user1.setCognome("Cognome");
		user1.setEta(20);
		user1.setSesso("M");

		user2.setCodiceFiscale("6543210987654321");
		user2.setNome("Nome2");
		user2.setCognome("Cognome2");
		user2.setEta(18);
		user2.setSesso("F");
	}

	@Test
	void testCreateUser() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.post("/users")
			.contentType(MediaType.APPLICATION_JSON)
			.content(JsonUtil.toJson(user1)))
			.andExpect(MockMvcResultMatchers.status().isOk())
			.andReturn();
	} 

	@Test
    void testGetAll() throws Exception {
		this.mockMvc.perform(get("/users")
		.accept(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andReturn();
    }

	@Test
    void testGetByCodiceFiscale() throws Exception {
		this.mockMvc.perform(get("/users/codicefiscale/" + user1.getCodiceFiscale())
		.accept(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andReturn();
    }

	@Test
	void testModificaUser() throws IOException, Exception {
		mockMvc.perform(MockMvcRequestBuilders.put("/users/codicefiscale/" + user1.getCodiceFiscale())
			.contentType(MediaType.APPLICATION_JSON)
			.content(JsonUtil.toJson(user2)))
			.andExpect(MockMvcResultMatchers.status().isOk())
			.andReturn();
	}

	@Test 
	void testEliminaUser() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.delete("/users/codicefiscale/" + user2.getCodiceFiscale()))
			.andExpect(MockMvcResultMatchers.status().isOk())
			.andReturn();
	}
	

} */
