package de.dennissuffel.pairprogrammingfinderbackend.user;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import de.dennissuffel.pairprogrammingfinderbackend.TestDataCreator;
import de.dennissuffel.pairprogrammingfinderbackend.user.model.User;

@ExtendWith(MockitoExtension.class)
public class UserRepositoryTest {

	@Mock
	private ObjectMapper mapper;

	@Test
	public void readAllUsers() throws JsonParseException, JsonMappingException, IOException {

		List<User> expectedUsers = TestDataCreator.createTwoUsers();

		Mockito.when(this.mapper.readValue(Mockito.any(File.class), ArgumentMatchers.<TypeReference<List<User>>>any()))
				.thenReturn(expectedUsers);

		UserRepository userRepo = new UserRepository(this.mapper);
		List<User> actualUsers = userRepo.readAllUsers();

		actualUsers.get(0).setArea(null);

		assertNotNull(actualUsers);

		// TODO Refactor to use equals List method instead of this construct
		assertEquals(expectedUsers.size(), actualUsers.size());

		for (int i = 0; i < expectedUsers.size(); i++) {
			assertEquals(expectedUsers.get(i), actualUsers.get(i), "element at index " + i + " is not equal.");
		}
	}

}
