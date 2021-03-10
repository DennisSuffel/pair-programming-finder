package de.dennissuffel.pairprogrammingfinderbackend.service;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;

import de.dennissuffel.pairprogrammingfinderbackend.model.User;

public class UserServiceTest {

	@Test
	public void findAllUsers() {
		UserService userService = new UserService();
		List<User> allUsers = userService.findAllUsers();
		assertNotNull(allUsers);
		assertFalse(allUsers.isEmpty());
	}

}
