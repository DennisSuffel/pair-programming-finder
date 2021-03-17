package de.dennissuffel.pairprogrammingfinderbackend.user;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.net.MalformedURLException;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import de.dennissuffel.pairprogrammingfinderbackend.TestDataCreator;
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
		expectedUser = TestDataCreator.createUserWithoutUserBuilder();
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
