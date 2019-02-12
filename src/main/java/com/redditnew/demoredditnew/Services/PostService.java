package com.redditnew.demoredditnew.Services;

import com.redditnew.demoredditnew.Exceptions.BadInputException;
import com.redditnew.demoredditnew.Models.Post;
import com.redditnew.demoredditnew.Repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    PostRepository postRepository;

    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<Post> findAll() {
       return postRepository.findAll();
    }

    public void addNewPost(Post post) throws BadInputException {
        if(!IsValid(post)){
            throw new BadInputException();
        }
        postRepository.save(post);
    }

    private boolean IsValid(Post post) {
        return post.getTitle()!= null || post.getUrl() != null || !post.getTitle().isEmpty() || !post.getUrl().isEmpty();
    }

    public Post findById(Long id) {
        return postRepository.findById(id).get();
    }

    public Post decrementLikeCounter(Long id) {
        postRepository.findById(id).get().decrementLikeCounter();
        return postRepository.findById(id).get();
    }

    public Post incrementLikeCounter(Long id) {
        postRepository.findById(id).get().incrementLikeCounter();
        return postRepository.findById(id).get();
    }
}
