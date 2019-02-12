package com.redditnew.demoredditnew.Controllers;

import com.redditnew.demoredditnew.Exceptions.BadInputException;
import com.redditnew.demoredditnew.Models.Post;
import com.redditnew.demoredditnew.Services.PostService;
import com.redditnew.demoredditnew.Services.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
public class RedditController {
    PostService postService;
    UserService userService;

    @Autowired
    public RedditController(PostService postService, UserService userService) {
        this.postService = postService;
        this.userService = userService;
    }

    @GetMapping("/")
    public String listAllPosts(Model model){
        model.addAttribute("posts", postService.findAll());
        return "index";
    }

    @GetMapping({"/submit", "/submit/{id}"})
    public String addNewPost(Model model, @PathVariable(name = "id", required = false) Long id){
        if (id == null){
            model.addAttribute("post", new Post());
            model.addAttribute("users", userService.listAllUser());
            return "addnewpost";
        }
        model.addAttribute("post", postService.findById(id));
        model.addAttribute("users", userService.listAllUser());
        return "addnewpost";
    }

    @PostMapping("/submit/{id}")
    public String savePost(Model model, @ModelAttribute Post post, @PathVariable ("id") Long id) throws BadInputException {
        Post post2 = post;
        post2.setId(id);
        postService.addNewPost(post2);
        return "redirect:/";
    }

    @GetMapping("/incrementLikeCounter/{id}")
    String incrementLikeCounter(@PathVariable("id") Long id) throws BadInputException {
       postService.addNewPost(postService.incrementLikeCounter(id));
        return "redirect:/";
    }

    @GetMapping("/decrementLikeCounter/{id}")
    String decrementLikeCounter(@PathVariable("id") Long id) throws BadInputException {
      postService.addNewPost(postService.decrementLikeCounter(id));
        return "redirect:/";
    }

    @ExceptionHandler(BadInputException.class)
    public String error(){
        return "error";
    }
}
