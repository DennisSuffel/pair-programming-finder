package de.dennissuffel.pairprogrammingfinderbackend.user;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import de.dennissuffel.pairprogrammingfinderbackend.user.model.User;

@Component
public class UserRepository {

	private ObjectMapper mapper;

	private String filePath = "/user/users.json";

	public UserRepository() {
		this.mapper = new ObjectMapper();
	}

	public UserRepository(ObjectMapper mapper) {
		this.mapper = mapper;
	}

	public List<User> readAllUsers() throws JsonParseException, JsonMappingException, IOException {
		/*
		 * TODO: Errohandling for the exception, that are in the throws declaration at
		 * the moment
		 */
		return this.mapper.readValue(UserRepository.class.getResourceAsStream(this.filePath),
				new TypeReference<List<User>>() {
				});
	}

}
