package com.mitchmele.optionslounge.option.user.service;

import com.mitchmele.optionslounge.option.user.UserRegistrationRequest;
import com.mitchmele.optionslounge.option.user.UserRegistrationService;
import com.mitchmele.optionslounge.option.user.UserRepository;
import com.mitchmele.optionslounge.option.user.model.OLoungeUser;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.verify;


@ExtendWith(MockitoExtension.class)
class UserRegistrationServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserRegistrationService userRegistrationService;


    @Test
    void registerUser_createsUserObjectAndSavesToDb() {

        UserRegistrationRequest request = UserRegistrationRequest.builder()
                .email("mm")
                .username("bby")
                .password("aay")
                .build();

        userRegistrationService.registerUser(request);

        OLoungeUser expectedUser = OLoungeUser.builder()
                .email("mm")
                .username("bby")
                .password("aay")
                .build();

        verify(userRepository).save(expectedUser);
    }
}