package com.lucarinelli.usersmanager.mapper;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtil {

    private static ObjectMapper mapper = new ObjectMapper();

	public static byte[] toJson(Object object) throws IOException {
		return mapper.writeValueAsBytes(object);
	}

}
