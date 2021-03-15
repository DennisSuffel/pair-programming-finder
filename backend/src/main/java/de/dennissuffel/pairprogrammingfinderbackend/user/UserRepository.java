package de.dennissuffel.pairprogrammingfinderbackend.user;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import de.dennissuffel.pairprogrammingfinderbackend.user.model.SessionType;
import de.dennissuffel.pairprogrammingfinderbackend.user.model.User;

@Component
public class UserRepository {

	public List<User> readAllUsers() throws MalformedURLException {
		// TODO: add tests und code for a json parser from file

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

		List<User> allUsers = new ArrayList<User>();
		allUsers.add(expectedUser1);
		allUsers.add(expectedUser2);

		return allUsers;
	}

}
