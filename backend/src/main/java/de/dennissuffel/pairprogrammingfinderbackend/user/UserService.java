package de.dennissuffel.pairprogrammingfinderbackend.user;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import de.dennissuffel.pairprogrammingfinderbackend.user.model.User;

@Service
public class UserService {

	private UserRepository userRepository;

	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	/*
	 * TODO: Remove throws declaration as soon as errorhandling in UserRepository is
	 * created
	 */
	public List<User> findAllUsers() throws JsonParseException, JsonMappingException, IOException {

		return this.userRepository.readAllUsers();
	}
}
