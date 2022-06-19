package com.bridge.User.Service;

import com.bridge.User.Data.UserRequest;
import com.bridge.User.Data.UserEntity;
import com.bridge.User.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    @Override
    public String joinUser(UserRequest userRequest) {


        userRepository.save(UserEntity.builder()
                .userId(userRequest.getUserid())
                .userName(userRequest.getName())
                .password(userRequest.getPw())
                .build());

        // 정상 저장 확인 로직 추가 필요
        return "succees";
    }

    @Override
    public String login(String userId, String password) {
        //BCryptPasswordEncoder pwEncoder = new BCryptPasswordEncoder();
        Optional<UserEntity> user = userRepository.findByUserId(userId);

        //if(user.get().getPassword().equals(pwEncoder.encode(password))){
        if(user.get().getPassword().equals(password)){
            // return : 나중에 친구리스트로 대체
            return "success";
        }
        return "Failed";
    }
}
