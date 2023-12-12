package com.project.zelda.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import project.zelda.ZeldaProjectApplication;
import project.zelda.controllers.UserController;
import project.zelda.models.UserModel;
import project.zelda.repository.UserRepository;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;


@ExtendWith(MockitoExtension.class)
@SpringBootTest(classes = ZeldaProjectApplication.class)
public class UserControllerTests {

    @Autowired
    private MockMvc mockMvc;
    @Mock
    private UserRepository userRepository;
    @InjectMocks
    private UserController userController;

    @Test
    public void testGetAllUsers() throws Exception {
        List<UserModel> users = Arrays.asList(new UserModel(1L, "User1", 25), new UserModel(2L, "User2", 30));
        given(userRepository.findAll()).willReturn(users);

        mockMvc.perform(get("/api/users"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].name").value("User1"))
                .andExpect(jsonPath("$[1].name").value("User2"));
    }
    @Test
    public void testGetUserById() throws Exception {
        Long id = 1L;
        UserModel user = new UserModel(id, "TestUser", 28);

        given(userRepository.findById(id)).willReturn(Optional.of(user));

        mockMvc.perform(get("/api/users/{id}", id))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("TestUser"))
                .andExpect(jsonPath("$.age").value(28));

    }

    @Test
    public void testCreateUser() throws Exception {
        UserModel userToCreate = new UserModel(null, "NewUser", 22);
        UserModel createdUser = new UserModel(1L, "NewUser", 22);

        given(userRepository.save(any(UserModel.class))).willReturn(createdUser);

        mockMvc.perform(post("/api/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(userToCreate)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("NewUser"))
                .andExpect(jsonPath("$.age").value(22));
    }
    @Test
    public void testDeleteUser() throws Exception {
        Long id = 1L;

        given(userRepository.existsById(id)).willReturn(true);

        mockMvc.perform(delete("/api/users/{id}", id))
                .andExpect(status().isNoContent());
    }

    private String asJsonString(final Object obj) throws Exception {
        return new ObjectMapper().writeValueAsString(obj);
    }

}