package de.dennissuffel.pairProgrammingFinderBackend.user;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import de.dennissuffel.pairProgrammingFinderBackend.TestDataCreator;
import de.dennissuffel.pairProgrammingFinderBackend.TestUtil;
import de.dennissuffel.pairProgrammingFinderBackend.user.model.User;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

	private UserService userService;

	@Mock
	private UserRepository userRepositoryMock;

	@BeforeEach
	public void initUserService() {
		this.userService = new UserService(this.userRepositoryMock);
	}

	@Test
	public void findUser() throws Exception {
		User expectedUser = TestDataCreator.createUser();
		Mockito.when(this.userRepositoryMock.readUser(expectedUser.getId())).thenReturn(new User(expectedUser));

		User actualUser = this.userService.findUser(expectedUser.getId());

		assertEquals(expectedUser, actualUser);
	}

	/*
	 * TODO: Remove throws declaration as soon as errorhandling in UserRepository is
	 * created.
	 */
	@Test
	public void findAllUsers() throws Exception {

		List<User> expectedAllUsers = TestDataCreator.createTwoUsers();
		Mockito.when(this.userRepositoryMock.readAllUsers()).thenReturn(TestUtil.deepCopyUsersList(expectedAllUsers));

		List<User> actualAllUsers = userService.findAllUsers();

		assertEquals(expectedAllUsers, actualAllUsers);
	}
}
