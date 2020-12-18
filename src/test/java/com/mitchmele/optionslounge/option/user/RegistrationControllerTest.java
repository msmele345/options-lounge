package com.mitchmele.optionslounge.option.user;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class RegistrationControllerTest {

    @Mock
    private UserRegistrationService service;

    @InjectMocks
    private RegistrationController registrationController;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(registrationController).build();
    }

    @Test
    void createOLoungeUser_takesRequestBodyAndSendsToService() throws Exception {

        UserRegistrationRequest request = UserRegistrationRequest.builder()
                .email("mm")
                .username("bby")
                .password("aay")
                .build();

        ObjectMapper mapper = new ObjectMapper();

        mockMvc.perform(post("/api/v1/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(request)))
                .andExpect(status().isOk());

        verify(service).registerUser(request);
    }
}