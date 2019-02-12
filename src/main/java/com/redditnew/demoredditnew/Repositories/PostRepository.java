package com.redditnew.demoredditnew.Repositories;

import com.redditnew.demoredditnew.Models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    Post findByIdContains(Long id);
}
