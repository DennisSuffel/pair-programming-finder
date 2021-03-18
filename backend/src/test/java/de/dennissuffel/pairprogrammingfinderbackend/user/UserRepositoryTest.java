package de.dennissuffel.pairprogrammingfinderbackend.user;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.net.MalformedURLException;
import java.util.List;

import org.junit.jupiter.api.Test;

import de.dennissuffel.pairprogrammingfinderbackend.user.model.User;

public class UserRepositoryTest {

	@Test
	public void readAllUsers() throws MalformedURLException {

		UserRepository userRepo = new UserRepository();
		List<User> users = userRepo.readAllUsers();

		assertNotNull(users);
		assertFalse(users.isEmpty());
	}

}
