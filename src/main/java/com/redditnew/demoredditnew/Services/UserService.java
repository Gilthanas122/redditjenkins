package com.redditnew.demoredditnew.Services;

import com.redditnew.demoredditnew.Models.RedditUser;
import com.redditnew.demoredditnew.Repositories.UserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
        userRepository.save(new RedditUser("Kelemen"));
        userRepository.save(new RedditUser("Nintendo"));
        userRepository.save(new RedditUser(null));
    }

    public List<RedditUser> listAllUser() {
        return userRepository.findAll();
    }
}
