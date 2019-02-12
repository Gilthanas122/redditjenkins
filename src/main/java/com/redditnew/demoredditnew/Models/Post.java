package com.redditnew.demoredditnew.Models;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Post {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String title;
    private String url;
    private Integer likeCounter;
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @ManyToOne
    private RedditUser redditUser;



    public Post() {
        likeCounter = 0;
        date = new Date();
    }

    public Post(String title, String url) {
        this.title = title;
        this.url = url;
        likeCounter = 0;
        date = new Date();
        this.redditUser = redditUser;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getLikeCounter() {
        return likeCounter;
    }

    public void setLikeCounter(Integer likeCounter) {
        this.likeCounter = likeCounter;
    }

    public void incrementLikeCounter(){
       this.likeCounter++;
    }

    public void decrementLikeCounter() {
        this.likeCounter--;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public RedditUser getRedditUser() {
        return redditUser;
    }

    public void setRedditUser(RedditUser redditUser) {
        this.redditUser = redditUser;
    }


}
