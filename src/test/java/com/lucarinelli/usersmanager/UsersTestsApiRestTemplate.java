/*package com.lucarinelli.usersmanager;

import com.lucarinelli.usersmanager.controller.UsersController;
import com.lucarinelli.usersmanager.dto.UsersRequestDto;
import com.lucarinelli.usersmanager.dto.UsersResponseDto;
import com.lucarinelli.usersmanager.mapper.UsersMapper;
import com.lucarinelli.usersmanager.model.Users;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

@ExtendWith(SpringExtension.class)
@WebAppConfiguration
public class UsersTestsApiRestTemplate {

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
	private UsersController controller;

    private static UsersRequestDto user1RequestDto = new UsersRequestDto();
    private static Users user1 = new Users();

    private static UsersRequestDto user2RequestDto = new UsersRequestDto();
    private static Users user2 = new Users();

    @BeforeAll
	static void setup(){
		user1RequestDto.setCodiceFiscale("1234567890123456");
		user1RequestDto.setNome("Nome");
		user1RequestDto.setCognome("Cognome");
		user1RequestDto.setEta(20);
		user1RequestDto.setSesso("M");

        user1 = UsersMapper.ToUser(user1RequestDto);
        UsersMapper.toDto(user1);

		user2RequestDto.setCodiceFiscale("6543210987654321");
		user2RequestDto.setNome("Nome2");
		user2RequestDto.setCognome("Cognome2");
		user2RequestDto.setEta(18);
		user2RequestDto.setSesso("F");

        user2 = UsersMapper.ToUser(user2RequestDto);
        UsersMapper.toDto(user2);
	}

    @Test
    void testGetAll(){
        Mockito.when(restTemplate.getForEntity("http://localhost:8080/users/", UsersResponseDto.class));
    }

    @Test
    void testGetByCodiceFiscale(){
        Mockito.when(restTemplate.getForEntity("http://localhost:8080/users/" + user1.getId(), UsersResponseDto.class));
    }

    @Test
    void testCreaUser(){
        Mockito.when(restTemplate.postForEntity("http://localhost:8080/users/", user1RequestDto, UsersResponseDto.class));
    }

    @Test
    void testModificaUser(){
        restTemplate.put("http://localhost:8080/users/codiceFiscale/" + user1.getCodiceFiscale(), user2RequestDto, UsersResponseDto.class);
    }

    @Test
    void testEliminaUser(){
        restTemplate.delete("http://localhost:8080/users/codiceFiscale/" + user2.getId());
    }
    
}
*/