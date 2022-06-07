package com.bridge.User.Service;

import com.bridge.User.Data.JoinRequest;
import com.bridge.User.Data.UserEntity;
import com.bridge.User.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;


public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;
    @Transactional
    @Override
    public void joinUser(JoinRequest joinRequest) {
        BCryptPasswordEncoder pwEncoder = new BCryptPasswordEncoder();
        UserEntity userEntity = new UserEntity(joinRequest.getEmail(), "");
        userEntity.setPassword(pwEncoder.encode(joinRequest.getPw()));
        userRepository.save(userEntity);
    }
}
