package com.bridge.User.Service;

import com.bridge.User.Data.JoinRequest;
import com.bridge.User.Data.LoginRequest;

public interface UserService {
    String joinUser(JoinRequest joinRequest);

    String login(String userId, String password);
}
