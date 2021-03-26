package de.dennissuffel.pairProgrammingFinderBackend.user;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import de.dennissuffel.pairProgrammingFinderBackend.TestDataCreator;
import de.dennissuffel.pairProgrammingFinderBackend.TestUtil;
import de.dennissuffel.pairProgrammingFinderBackend.user.model.User;

@ExtendWith(MockitoExtension.class)
public class UserControllerTest {

	@Mock
	UserService userService;

	@Test
	public void getAllUsers() throws Exception {

		List<User> expectedUser = TestDataCreator.createTwoUsers();
		when(this.userService.findAllUsers()).thenReturn(TestUtil.deepCopyUsersList(expectedUser));

		UserController userController = new UserController(this.userService);
		List<User> actuallUser = userController.getAllUsers();

		assertEquals(expectedUser, actuallUser);
	}

}
