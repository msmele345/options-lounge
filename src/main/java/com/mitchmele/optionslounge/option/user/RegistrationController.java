package com.mitchmele.optionslounge.option.user;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class RegistrationController {

    private final UserRegistrationService userRegistrationService;

    @PostMapping("/users")
    @CrossOrigin
    public void createOLoungeUser(@RequestBody UserRegistrationRequest request) {
        //service that saves to a db table
        //service sends token in email after success registration
        //tokens are saved in spring security userdetails for preauth userDetails service
        userRegistrationService.registerUser(request);
    }
}
