package com.mitchmele.optionslounge.option.user;

import com.mitchmele.optionslounge.option.user.model.OLoungeUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserRegistrationService {

    private final UserRepository userRepository;

    public void registerUser(UserRegistrationRequest request) {

        OLoungeUser newUser = OLoungeUser.builder()
                .username(request.getUsername())
                .password(request.getPassword())
                .email(request.getEmail())
                .build();

        userRepository.save(newUser);
    }
}
