package com.redditnew.demoredditnew.Repositories;

import com.redditnew.demoredditnew.Models.RedditUser;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository <RedditUser, Long> {
}
