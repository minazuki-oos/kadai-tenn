package com.minazuki.kadai;

import java.util.Optional;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserMapper userMapper;

    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public User findUser(int id) {
        Optional<User> user = this.userMapper.findById(id);
        // Optional.get()は値が存在しない場合例外を発⽣させる
        if (user.isPresent()) {
            return user.get();
        } else {
            throw new UserNotFoundException("user not found");
        }
    }
}


