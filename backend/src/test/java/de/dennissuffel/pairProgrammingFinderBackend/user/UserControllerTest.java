package de.dennissuffel.pairProgrammingFinderBackend.user;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import de.dennissuffel.pairProgrammingFinderBackend.TestDataCreator;
import de.dennissuffel.pairProgrammingFinderBackend.TestUtil;
import de.dennissuffel.pairProgrammingFinderBackend.user.model.User;

@ExtendWith(MockitoExtension.class)
@TestInstance(Lifecycle.PER_CLASS)
public class UserControllerTest {

	private UserController userController;

	@Mock
	private UserService userService;

	@BeforeEach
	public void initUserController() {
		this.userController = new UserController(this.userService);
	}

	@Test
	public void getAllUsers() throws Exception {

		List<User> expectedUsers = TestDataCreator.createTwoUsers(true);
		when(this.userService.findAllUsers()).thenReturn(TestUtil.deepCopyUsersList(expectedUsers));

		List<User> actuallUsers = this.userController.getAllUsers();

		assertEquals(expectedUsers, actuallUsers);
	}

	@Test
	public void getUser() throws Exception {

		User expectedUser = TestDataCreator.createUser(true);
		when(this.userService.findUser(Mockito.anyInt())).thenReturn(new User(expectedUser));

		User actualUser = this.userController.getUser(expectedUser.getId());

		assertEquals(expectedUser, actualUser);
	}
}
