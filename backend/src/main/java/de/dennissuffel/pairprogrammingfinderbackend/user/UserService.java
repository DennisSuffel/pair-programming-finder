package de.dennissuffel.pairprogrammingfinderbackend.user;

import java.net.MalformedURLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.dennissuffel.pairprogrammingfinderbackend.user.model.User;

@Service
public class UserService {

	private UserRepository userRepository;

	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public List<User> findAllUsers() throws MalformedURLException {

		return this.userRepository.readAllUsers();
	}
}
