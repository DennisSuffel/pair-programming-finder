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

import de.dennissuffel.pairprogrammingfinderbackend.user.model.SessionType;
import de.dennissuffel.pairprogrammingfinderbackend.user.model.User;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

	@Mock
	private UserRepository userRepositoryMock;

	@Test
	public void findAllUsers() throws MalformedURLException {

		/*
		 * TODO: Code Duplication with UserRepository#readAllUsers() and
		 * UserBuilderTest#initializeExpectedUser()
		 */
		User expectedUser1 = new UserBuilder().setId(111111).setName("TestName1")
				.setProfilePictureUrl(new URL("https://www.test.test"))
				.setInterests(new ArrayList<String>(Arrays.asList(new String[] { "Java", "TDD" })))
				.setPreferedSessionType(SessionType.BOTH).setArea("Frankfurt")
				.setVideoConferenceTools(new ArrayList<String>(Arrays.asList(new String[] { "Zoom", "MS Teams" })))
				.build();

		User expectedUser2 = new UserBuilder().setId(111111).setName("TestName2")
				.setProfilePictureUrl(new URL("https://www.test2.test"))
				.setInterests(new ArrayList<String>(Arrays.asList(new String[] { "C#", "Code Katas" })))
				.setPreferedSessionType(SessionType.LOCAL).setArea("Paris")
				.setVideoConferenceTools(new ArrayList<String>(Arrays.asList(new String[] { "Skype", "Lifesize" })))
				.build();

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
