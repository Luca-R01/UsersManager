package com.lucarinelli.usersmanager;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import com.lucarinelli.usersmanager.dto.UsersRequestDto;
import com.lucarinelli.usersmanager.dto.UsersResponseDto;
import com.lucarinelli.usersmanager.mapper.UsersMapper;
import com.lucarinelli.usersmanager.model.Users;
import com.lucarinelli.usersmanager.repository.UsersRepository;
import com.lucarinelli.usersmanager.service.impl.UserServiceImpl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class UsersTests {
	
	@Mock
	private UserServiceImpl service;

    @Mock
    private UsersRepository repository;

    UsersRequestDto userCreator(){
        UsersRequestDto requestDto;
        requestDto = new UsersRequestDto();
        requestDto.setId("id");
        requestDto.setCodiceFiscale("0123456789ABCDEF");
        requestDto.setNome("N");
        requestDto.setCognome("C");
        requestDto.setEta(20);
        requestDto.setSessoString("M");
        return requestDto;
    }

    UsersRequestDto userCreator2(){
        UsersRequestDto requestDto;
        requestDto = new UsersRequestDto();
        requestDto.setId("id");
        requestDto.setCodiceFiscale("FEDCBA9876543210");
        requestDto.setNome("N2");
        requestDto.setCognome("C2");
        requestDto.setEta(19);
        requestDto.setSessoString("F");
        return requestDto;
    }


    @Test
    void TestGetAll(){
        List<UsersResponseDto> dtoList = new ArrayList<UsersResponseDto>();
        dtoList.add(new UsersResponseDto());

        when(service.getAll()).thenReturn(dtoList);
        List<UsersResponseDto> expected = service.getAll();
        assertEquals(expected, dtoList);

    }

    @Test
    void TestGetById(){
        UsersRequestDto requestDto = userCreator();
        Users user = UsersMapper.ToUser(requestDto);
        UsersResponseDto responseDto = UsersMapper.toDto(user);

        when(service.getById(user.getId())).thenReturn(responseDto);
        UsersResponseDto expected = service.getById(user.getId());
        assertEquals(expected, responseDto);
    }

    @Test
    void TestGetByCodiceFiscale(){
        UsersRequestDto requestDto = userCreator();
        Users user = UsersMapper.ToUser(requestDto);
        UsersResponseDto responseDto = UsersMapper.toDto(user);

        when(service.getByCodiceFiscale(user.getCodiceFiscale())).thenReturn(responseDto);
        UsersResponseDto expected = service.getByCodiceFiscale(user.getCodiceFiscale());
        assertEquals(expected, responseDto);
    }

    @Test
    void TestCreaUser(){
        UsersRequestDto requestDto = userCreator();
        Users user = UsersMapper.ToUser(requestDto);
        UsersResponseDto responseDto = UsersMapper.toDto(user);
        
        when(service.creaUser(requestDto)).thenReturn(responseDto);
        UsersResponseDto userCreated = service.creaUser(requestDto);
        assertEquals(userCreated.getCodiceFiscale(),user.getCodiceFiscale());
    }

    @Test
    void TestModificaUser(){
        UsersRequestDto requestDto2 = userCreator2();
        Users user2 = UsersMapper.ToUser(requestDto2);
        UsersResponseDto responseDto2 = UsersMapper.toDto(user2);

        when(service.modificaUser("0123456789ABCDEF", requestDto2)).thenReturn(responseDto2);
        UsersResponseDto expected = service.modificaUser("0123456789ABCDEF", requestDto2);
        assertEquals(expected, responseDto2);
    }

    @Test
    void TestEliminaUser(){
        service.eliminaUser("0123456789ABCDEF");
    }

}
