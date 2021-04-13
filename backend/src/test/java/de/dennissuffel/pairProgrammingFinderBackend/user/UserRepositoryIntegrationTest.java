package de.dennissuffel.pairProgrammingFinderBackend.user;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import de.dennissuffel.pairProgrammingFinderBackend.TestDataCreator;
import de.dennissuffel.pairProgrammingFinderBackend.user.model.User;

@Tag("IntegrationTest")
@DataJpaTest
public class UserRepositoryIntegrationTest {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private UserRepository userRepository;

	private List<User> expectedUsers;

	@BeforeEach
	public void initDatabase() throws Exception {
		this.expectedUsers = TestDataCreator.createTwoUsers(false);

		this.entityManager.clear();

		for (User expectedUser : this.expectedUsers) {
			expectedUser.setId(null);

			User deepCopyOfExpectedUser = new User(expectedUser);
			this.entityManager.persist(deepCopyOfExpectedUser);
			this.entityManager.flush();

			expectedUser.setId(deepCopyOfExpectedUser.getId());
		}
	}

	@Test
	public void readUser() throws Exception {

		User actualUser = this.userRepository.getOne(expectedUsers.get(0).getId());

		assertEquals(this.expectedUsers.get(0), actualUser);
	}

	@Test
	public void readAllUsers() throws Exception {

		List<User> actualUsers = this.userRepository.findAll();

		assertEquals(this.expectedUsers, actualUsers);
	}
}
