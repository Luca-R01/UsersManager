package com.lucarinelli.usersmanager;

import com.lucarinelli.usersmanager.repository.UsersRepository;
import com.lucarinelli.usersmanager.service.UsersService;
import com.lucarinelli.usersmanager.service.impl.UserServiceImpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class UsersTests {
    
    @Mock
    private UsersRepository userRepository;
    private UsersService service;

    @BeforeEach
    public void init() {
        service = new UserServiceImpl();
    }

    @Test
    void TestGetAll(){
    }

}
