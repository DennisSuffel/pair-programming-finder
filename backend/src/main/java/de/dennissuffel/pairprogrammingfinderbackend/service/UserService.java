package de.dennissuffel.pairprogrammingfinderbackend.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import de.dennissuffel.pairprogrammingfinderbackend.model.User;

@Service
public class UserService {

	public List<User> findAllUsers() {
		List<User> allUsers = new ArrayList<User>();
		allUsers.add(new User());
		return allUsers;
	}
}
