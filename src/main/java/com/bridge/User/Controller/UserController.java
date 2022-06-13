package com.bridge.User.Controller;

import com.bridge.User.Data.JoinRequest;
import com.bridge.User.Data.LoginRequest;
import com.bridge.User.Service.UserService;
import com.sun.tools.javac.util.Log;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/join")
    public String join(@RequestBody JoinRequest joinRequest){
        log.info(joinRequest.getUserid(), joinRequest.getName(), joinRequest.getPw());
        if(userService.joinUser(joinRequest).equals("success")){
            return "redirect:/login";

        }

        // 실패 사유 리턴 추가하기
        return "회원가입 실패";
    }

    @PostMapping("login")
    public ResponseEntity login(@RequestBody LoginRequest loginRequest){


        if(userService.login(loginRequest.getUserid(), loginRequest.getPw()).equals("success")){
            return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }
}
