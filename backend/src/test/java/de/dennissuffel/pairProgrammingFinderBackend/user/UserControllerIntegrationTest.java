package de.dennissuffel.pairProgrammingFinderBackend.user;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import de.dennissuffel.pairProgrammingFinderBackend.TestDataCreator;
import de.dennissuffel.pairProgrammingFinderBackend.TestUtil;
import de.dennissuffel.pairProgrammingFinderBackend.user.model.User;

@Tag("IntegrationTest")
@WebMvcTest
public class UserControllerIntegrationTest {

	private UserController userController;

	@Autowired
	private MockMvc mvc;

	@MockBean
	UserService userService;

	@BeforeEach
	public void initUserController() {
		this.userController = new UserController(this.userService);
	}

	@Test
	public void getUser() throws Exception {
		User expectedUser = TestDataCreator.createUser();
		when(this.userService.findUser(Mockito.anyInt())).thenReturn(new User(expectedUser));

		User actualUser = this.userController.getUser(expectedUser.getId());

		assertEquals(expectedUser, actualUser);

		this.mvc.perform(get("/user/" + expectedUser.getId()).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().json(new ObjectMapper().writeValueAsString(expectedUser)));
	}

	@Test
	public void getAllUsers() throws Exception {

		List<User> expectedUsers = TestDataCreator.createTwoUsers();
		when(this.userService.findAllUsers()).thenReturn(TestUtil.deepCopyUsersList(expectedUsers));

		List<User> actualUsers = this.userController.getAllUsers();

		assertEquals(expectedUsers, actualUsers);

		this.mvc.perform(get("/user/all").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(content().json(new ObjectMapper().writeValueAsString(expectedUsers)));
	}

}
