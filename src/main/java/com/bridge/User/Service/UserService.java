package com.bridge.User.Service;

import com.bridge.User.Data.UserRequest;

public interface UserService {
    String joinUser(UserRequest userRequest);

    String login(String userId, String password);
}
