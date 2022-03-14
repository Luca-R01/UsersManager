package com.lucarinelli.usersmanager;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import com.lucarinelli.usersmanager.dto.UsersRequestDto;
import com.lucarinelli.usersmanager.dto.UsersResponseDto;
import com.lucarinelli.usersmanager.mapper.UsersMapper;
import com.lucarinelli.usersmanager.model.Users;
import com.lucarinelli.usersmanager.service.impl.UserServiceImpl;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class UsersTestsService {
	
	@Mock
	private UserServiceImpl service;
    
    private static UsersRequestDto requestDto;
    private static UsersRequestDto requestDto2;
    
    @BeforeAll
    static void setup() {
        requestDto = new UsersRequestDto();
        requestDto.setCodiceFiscale("0123456789ABCDEF");
        requestDto.setNome("N");
        requestDto.setCognome("C");
        requestDto.setEta(20);
        requestDto.setSessoString("M");
        
        requestDto2 = new UsersRequestDto();
        requestDto2.setCodiceFiscale("FEDCBA9876543210");
        requestDto2.setNome("N2");
        requestDto2.setCognome("C2");
        requestDto2.setEta(19);
        requestDto2.setSessoString("F");
    }


    @Test
    void testGetAll(){
        List<UsersResponseDto> dtoList = new ArrayList<UsersResponseDto>();
        dtoList.add(new UsersResponseDto());

        when(service.getAll()).thenReturn(dtoList);
        List<UsersResponseDto> expected = service.getAll();
        assertEquals(expected, dtoList);

    }

    @Test
    void testGetById(){
        Users user = UsersMapper.ToUser(requestDto);
        UsersResponseDto responseDto = UsersMapper.toDto(user);

        when(service.getById(user.getId())).thenReturn(responseDto);
        UsersResponseDto expected = service.getById(user.getId());
        assertEquals(expected, responseDto);
    }

    @Test
    void testGetByCodiceFiscale(){
        Users user = UsersMapper.ToUser(requestDto);
        UsersResponseDto responseDto = UsersMapper.toDto(user);

        when(service.getByCodiceFiscale(user.getCodiceFiscale())).thenReturn(responseDto);
        UsersResponseDto expected = service.getByCodiceFiscale(user.getCodiceFiscale());
        assertEquals(expected, responseDto);
    }

    @Test
    void testCreaUser(){
        Users user = UsersMapper.ToUser(requestDto);
        UsersResponseDto responseDto = UsersMapper.toDto(user);
        
        when(service.creaUser(requestDto)).thenReturn(responseDto);
        UsersResponseDto userCreated = service.creaUser(requestDto);
        assertEquals(userCreated.getCodiceFiscale(),user.getCodiceFiscale());
    }

    @Test
    void testModificaUser(){
        Users user2 = UsersMapper.ToUser(requestDto2);
        UsersResponseDto responseDto2 = UsersMapper.toDto(user2);

        when(service.modificaUser("0123456789ABCDEF", requestDto2)).thenReturn(responseDto2);
        UsersResponseDto expected = service.modificaUser("0123456789ABCDEF", requestDto2);
        assertEquals(expected, responseDto2);
    }

    @Test
    void testEliminaUser(){
        service.eliminaUser("0123456789ABCDEF");
    }

}
