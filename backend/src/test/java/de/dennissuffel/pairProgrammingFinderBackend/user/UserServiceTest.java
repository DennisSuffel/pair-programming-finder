package de.dennissuffel.pairProgrammingFinderBackend.user;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import de.dennissuffel.pairProgrammingFinderBackend.TestDataCreator;
import de.dennissuffel.pairProgrammingFinderBackend.TestUtil;
import de.dennissuffel.pairProgrammingFinderBackend.user.model.User;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

	@Mock
	private UserRepository userRepositoryMock;

	/*
	 * TODO: Remove throws declaration as soon as errorhandling in UserRepository is
	 * created.
	 */
	@Test
	public void findAllUsers() throws JsonParseException, JsonMappingException, IOException {

		List<User> expectedAllUsers = TestDataCreator.createTwoUsers();
		Mockito.when(this.userRepositoryMock.readAllUsers()).thenReturn(TestUtil.deepCopyUsersList(expectedAllUsers));

		UserService userService = new UserService(this.userRepositoryMock);
		List<User> actualAllUsers = userService.findAllUsers();

		assertEquals(expectedAllUsers, actualAllUsers);
	}
}
