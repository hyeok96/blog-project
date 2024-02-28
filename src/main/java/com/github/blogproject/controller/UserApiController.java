package com.github.blogproject.controller;

import com.github.blogproject.dto.AddUserRequest;
import com.github.blogproject.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Controller
public class UserApiController {

    private final UserService userService;

    @PostMapping("/user")
    public String signup (AddUserRequest request) {
        userService.save(request);
        return "redirect:/login";
    }
}
