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

	public static User createUser() throws MalformedURLException {
		return new UserBuilder().setId(111111).setName("TestName1")
				.setProfilePictureUrl(new URL("https://www.test.test"))
				.setInterests(new ArrayList<String>(Arrays.asList(new String[] { "Java", "TDD" })))
				.setPreferedSessionType(SessionType.BOTH).setArea("Frankfurt")
				.setVideoConferenceTools(new ArrayList<String>(Arrays.asList(new String[] { "Zoom", "MS Teams" })))
				.build();
	}

	public static List<User> createTwoUsers() throws MalformedURLException {

		List<User> users = new ArrayList<User>();
		users.add(TestDataCreator.createUser());

		User user2 = new UserBuilder().setId(22222).setName("TestName2")
				.setProfilePictureUrl(new URL("https://www.test2.test"))
				.setInterests(new ArrayList<String>(Arrays.asList(new String[] { "C#", "Code Katas" })))
				.setPreferedSessionType(SessionType.LOCAL).setArea("Paris")
				.setVideoConferenceTools(new ArrayList<String>(Arrays.asList(new String[] { "Skype", "Lifesize" })))
				.build();
		users.add(user2);

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
