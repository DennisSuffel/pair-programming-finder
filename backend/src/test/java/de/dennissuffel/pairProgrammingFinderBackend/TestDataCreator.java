package de.dennissuffel.pairProgrammingFinderBackend;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import de.dennissuffel.pairProgrammingFinderBackend.user.UserBuilder;
import de.dennissuffel.pairProgrammingFinderBackend.user.model.SessionType;
import de.dennissuffel.pairProgrammingFinderBackend.user.model.User;

public class TestDataCreator {

	public static User createUser(boolean withId) throws MalformedURLException {
		UserBuilder userBuilder = new UserBuilder().setName("TestName1")
				.setProfilePictureUrl(new URL("https://www.test.test"))
				.setInterests(new ArrayList<String>(Arrays.asList(new String[] { "Java", "TDD" })))
				.setPreferedSessionType(SessionType.BOTH).setArea("Frankfurt")
				.setVideoConferenceTools(new ArrayList<String>(Arrays.asList(new String[] { "Zoom", "MS Teams" })));

		if (withId) {
			userBuilder.setId(111111);
		}
		return userBuilder.build();
	}

	public static List<User> createTwoUsers(boolean withId) throws MalformedURLException {

		List<User> users = new ArrayList<User>();
		users.add(TestDataCreator.createUser(withId));

		UserBuilder userBuilder = new UserBuilder().setName("TestName2")
				.setProfilePictureUrl(new URL("https://www.test2.test"))
				.setInterests(new ArrayList<String>(Arrays.asList(new String[] { "C#", "Code Katas" })))
				.setPreferedSessionType(SessionType.LOCAL).setArea("Paris")
				.setVideoConferenceTools(new ArrayList<String>(Arrays.asList(new String[] { "Skype", "Lifesize" })));

		if (withId) {
			userBuilder.setId(22222);
		}

		users.add(userBuilder.build());

		return users;
	}

	public static User createUserWithoutUserBuilder() throws MalformedURLException {
		User user = new User();
		user.setId(3333);
		user.setName("TestName3");
		user.setProfilePictureUrl(new URL("https://www.test3.test"));
		user.setInterests(new ArrayList<String>(Arrays.asList(new String[] { "JavaScript", "DDD" })));
		user.setPreferedSessionType(SessionType.BOTH);
		user.setArea("Berlin");
		user.setVideoConferenceTools(new ArrayList<String>(Arrays.asList(new String[] { "Zoom", "Slack" })));

		return user;
	}
}
