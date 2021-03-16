package de.dennissuffel.pairprogrammingfinderbackend.user;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import de.dennissuffel.pairprogrammingfinderbackend.user.model.SessionType;
import de.dennissuffel.pairprogrammingfinderbackend.user.model.User;

public class UserBuilderTest {

	private static User expectedUser;

	private UserBuilder userBuilderToTest;

	@BeforeAll
	public static void initializeExpectedUser() throws MalformedURLException {
		/*
		 * Because we want to test the behavior of UserBuilder we cannot use it for a
		 * better way to initialize the user object
		 */
		User user = new User();
		user.setId(111111);
		user.setName("TestName1");
		user.setProfilePictureUrl(new URL("https://www.test.test"));
		user.setInterests(new ArrayList<String>(Arrays.asList(new String[] { "Java", "TDD" })));
		user.setPreferedSessionType(SessionType.BOTH);
		user.setArea("Frankfurt");
		user.setVideoConferenceTools(new ArrayList<String>(Arrays.asList(new String[] { "Zoom", "MS Teams" })));

		expectedUser = user;
	}

	@BeforeEach
	public void initializeUserBuilderWithValues() {

		this.userBuilderToTest = new UserBuilder().setId(expectedUser.getId()).setName(expectedUser.getName())
				.setProfilePictureUrl(expectedUser.getProfilePictureUrl()).setInterests(expectedUser.getInterests())
				.setPreferedSessionType(expectedUser.getPreferedSessionType()).setArea(expectedUser.getArea())
				.setVideoConferenceTools(expectedUser.getVideoConferenceTools());
	}

	@Test
	public void build() throws MalformedURLException {

		User actualUser = this.userBuilderToTest.build();

		assertEquals(expectedUser, actualUser);
	}

	@Test
	public void reset() throws MalformedURLException {

		User actualUser = this.userBuilderToTest.reset().build();

		assertEquals(new User(), actualUser);
	}
}
