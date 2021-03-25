package de.dennissuffel.pairProgrammingFinderBackend.user;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import de.dennissuffel.pairProgrammingFinderBackend.TestDataCreator;
import de.dennissuffel.pairProgrammingFinderBackend.user.model.User;

public class UserRepositoryIntegrationTest {

	@Test
	public void readAllUsers() throws JsonParseException, JsonMappingException, IOException {

		UserRepository userRepo = new UserRepository();
		List<User> actualUsers = userRepo.readAllUsers();

		// The expected users and the users in the test file are the same
		List<User> expectedUsers = TestDataCreator.createTwoUsers();

		assertEquals(expectedUsers, actualUsers);
	}

}
