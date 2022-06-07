package com.bridge.User.Controller;

import com.bridge.User.Data.JoinRequest;
import com.bridge.User.Service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
@Slf4j
public class UserController {
    private final UserService userService;

    @PostMapping("join")
    public String join(JoinRequest joinRequest){
        userService.joinUser(joinRequest);
        return "redirect:/login";
    }
}
