package de.dennissuffel.pairprogrammingfinderbackend;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import de.dennissuffel.pairprogrammingfinderbackend.user.model.User;

public class TestUtil {

	public static List<User> deepCopyUsersList(List<User> userToCopy) throws MalformedURLException {
		List<User> deepCopy = new ArrayList<>();
		for (User user : userToCopy) {
			deepCopy.add(new User(user));
		}
		return deepCopy;
	}
}
