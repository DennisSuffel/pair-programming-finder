package de.dennissuffel.pairProgrammingFinderBackend.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.dennissuffel.pairProgrammingFinderBackend.user.model.User;

@Service
public class UserService {

	private UserRepository userRepository;

	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	/*
	 * TODO: Errorhandling if id is not found
	 */
	public User findUser(int id) {
		return this.userRepository.getOne(id);
	}

	public List<User> findAllUsers() {

		return this.userRepository.findAll();
	}
}
