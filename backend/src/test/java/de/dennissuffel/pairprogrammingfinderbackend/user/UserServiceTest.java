package de.dennissuffel.pairprogrammingfinderbackend.user;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.net.MalformedURLException;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import de.dennissuffel.pairprogrammingfinderbackend.TestDataCreator;
import de.dennissuffel.pairprogrammingfinderbackend.user.model.User;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

	@Mock
	private UserRepository userRepositoryMock;

	@Test
	public void findAllUsers() throws MalformedURLException {

		List<User> expectedAllUsers = TestDataCreator.createTwoUsers();
		/*
		 * TODO: Test takes around 450ms to complete. Check if maybe stubbing instead of
		 * mocking is faster. The extra functionality of a mock is not needed in this
		 * test.
		 */
		Mockito.when(this.userRepositoryMock.readAllUsers()).thenReturn(expectedAllUsers);

		UserService userService = new UserService(this.userRepositoryMock);
		List<User> actualAllUsers = userService.findAllUsers();

		assertNotNull(actualAllUsers);
		assertEquals(expectedAllUsers.size(), actualAllUsers.size());

		for (int i = 0; i < expectedAllUsers.size(); i++) {
			assertEquals(expectedAllUsers.get(i), actualAllUsers.get(i), "element at index " + i + " is not equal.");
		}
	}
}
