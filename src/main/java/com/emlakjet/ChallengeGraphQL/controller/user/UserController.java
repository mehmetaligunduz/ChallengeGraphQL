package com.emlakjet.ChallengeGraphQL.controller.user;

import com.emlakjet.ChallengeGraphQL.service.user.UserService;
import com.emlakjet.ChallengeGraphQL.service.user.UserServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {
    private final UserServiceInterface userServiceInterface;

    @PostMapping
    public ResponseEntity<UserResponse> create(@RequestBody UserRequest userRequest){
        UserService userService = userRequest.toUser();
        Long id = userServiceInterface.create(userService);
        UserResponse userResponse = UserResponse.valueOf(id);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(userResponse);
    }
}
