package com.lucarinelli.usersmanager;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

@SpringBootTest
public class UsersTestApiRestTemplate {

    private String url = "http://127.0.0.1:8080/users";

    @Autowired
    private TestRestTemplate restTemplate;
    
    @Test
    void testGetAll() {

        ResponseEntity<Object[]> response = restTemplate.getForEntity(url, Object[].class);
    
    }
}
