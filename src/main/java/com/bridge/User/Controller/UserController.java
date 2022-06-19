package com.bridge.User.Controller;

import com.bridge.User.Data.UserRequest;
import com.bridge.User.Service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@Slf4j
@ResponseBody
@RestController("/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/join")
    public String join(@RequestBody UserRequest userRequest){
        log.info("userId = {} userName = {} password = {}",
                userRequest.getUserid(),
                userRequest.getName(),
                userRequest.getPw());
        return userService.joinUser(userRequest);
    }

    @PostMapping("login")
    public String login(@RequestBody UserRequest userRequest){
        log.info("userId = {} password = {}",
                userRequest.getUserid(),
                userRequest.getPw());
        return userService.login(userRequest.getUserid(), userRequest.getPw());
    }
}
