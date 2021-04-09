package de.dennissuffel.pairProgrammingFinderBackend.user;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.InputStream;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import de.dennissuffel.pairProgrammingFinderBackend.TestDataCreator;
import de.dennissuffel.pairProgrammingFinderBackend.TestUtil;
import de.dennissuffel.pairProgrammingFinderBackend.user.model.User;

@ExtendWith(MockitoExtension.class)
public class UserRepositoryTest {

	private UserRepository userRepo;

	@Mock
	private ObjectMapper mapper;

	@BeforeEach
	public void initUserRepo() {
		this.userRepo = new UserRepository(this.mapper);
	}

	@Test
	public void readUser() throws Exception {
		List<User> expectedUsers = TestDataCreator.createTwoUsers();

		Mockito.when(this.mapper.readValue(Mockito.any(InputStream.class),
				ArgumentMatchers.<TypeReference<List<User>>>any()))
				.thenReturn(TestUtil.deepCopyUsersList(expectedUsers));

		User actualUser = this.userRepo.readUser(expectedUsers.get(0).getId());

		assertEquals(expectedUsers.get(0), actualUser);
	}

	@Test
	public void readAllUsers() throws Exception {

		List<User> expectedUsers = TestDataCreator.createTwoUsers();

		Mockito.when(this.mapper.readValue(Mockito.any(InputStream.class),
				ArgumentMatchers.<TypeReference<List<User>>>any()))
				.thenReturn(TestUtil.deepCopyUsersList(expectedUsers));

		List<User> actualUsers = this.userRepo.readAllUsers();

		assertEquals(expectedUsers, actualUsers);
	}

}
