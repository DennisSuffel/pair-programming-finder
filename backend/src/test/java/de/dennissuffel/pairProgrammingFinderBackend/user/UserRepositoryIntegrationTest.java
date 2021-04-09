package de.dennissuffel.pairProgrammingFinderBackend.user;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import de.dennissuffel.pairProgrammingFinderBackend.TestDataCreator;
import de.dennissuffel.pairProgrammingFinderBackend.user.model.User;

@Tag("IntegrationTest")
public class UserRepositoryIntegrationTest {

	@Test
	public void readUser() throws Exception {
		UserRepository userRepo = new UserRepository();
		// The expected users and the users in the test file are the same
		List<User> expectedUsers = TestDataCreator.createTwoUsers();

		User actualUser = userRepo.readUser(expectedUsers.get(0).getId());

		assertEquals(expectedUsers.get(0), actualUser);
	}

	@Test
	public void readAllUsers() throws Exception {

		UserRepository userRepo = new UserRepository();
		List<User> actualUsers = userRepo.readAllUsers();

		// The expected users and the users in the test file are the same
		List<User> expectedUsers = TestDataCreator.createTwoUsers();

		assertEquals(expectedUsers, actualUsers);
	}

}
