package de.dennissuffel.pairprogrammingfinderbackend.user;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import de.dennissuffel.pairprogrammingfinderbackend.user.UserRepository;
import de.dennissuffel.pairprogrammingfinderbackend.user.UserService;
import de.dennissuffel.pairprogrammingfinderbackend.user.model.SessionType;
import de.dennissuffel.pairprogrammingfinderbackend.user.model.User;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

	@Mock
	private UserRepository userRepositoryMock;

	@Test
	public void findAllUsers() throws MalformedURLException {
		/*
		 * TODO: Refactor Builder Pattern
		 * https://www.vogella.com/tutorials/DesignPatternBuilder/article.html
		 */

		// TODO: Code Duplication with UserRepository#readAllUsers()
		User expectedUser1 = new User();
		expectedUser1.setId(111111);
		expectedUser1.setName("TestName1");
		expectedUser1.setProfilePictureUrl(new URL("https://www.test.test"));
		expectedUser1.setInterests(new ArrayList<String>(Arrays.asList(new String[] { "Java", "TDD" })));
		expectedUser1.setPreferedSessionType(SessionType.BOTH);
		expectedUser1.setArea("Frankfurt");
		expectedUser1
				.setVideoConferenceTools(new ArrayList<String>(Arrays.asList(new String[] { "Zoom", "MS Teams" })));

		User expectedUser2 = new User();
		expectedUser2.setId(111111);
		expectedUser2.setName("TestName2");
		expectedUser2.setProfilePictureUrl(new URL("https://www.test2.test"));
		expectedUser2.setInterests(new ArrayList<String>(Arrays.asList(new String[] { "C#", "Code Katas" })));
		expectedUser2.setPreferedSessionType(SessionType.LOCAL);
		expectedUser2.setArea("Paris");
		expectedUser2
				.setVideoConferenceTools(new ArrayList<String>(Arrays.asList(new String[] { "Skype", "Lifesize" })));

		List<User> expectedAllUsers = new ArrayList<User>();
		expectedAllUsers.add(expectedUser1);
		expectedAllUsers.add(expectedUser2);
		Mockito.when(this.userRepositoryMock.readAllUsers()).thenReturn(expectedAllUsers);

		UserService userService = new UserService(this.userRepositoryMock);
		List<User> actualAllUsers = userService.findAllUsers();

		assertNotNull(actualAllUsers);
		assertEquals(expectedAllUsers.size(), actualAllUsers.size());
		assertEquals(expectedUser1, actualAllUsers.get(0));
		assertEquals(expectedUser2, actualAllUsers.get(1));
	}

}
