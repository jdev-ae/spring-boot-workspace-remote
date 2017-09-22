package com.suru.h2demo.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Post {
    @Id
    @GeneratedValue
    private Long id;
    private String post;
    private Date postedOn;
    @ManyToOne
    private Author author;

    public Post() {
    }

    public Post(Long id, String post, Date postedOn, Author author) {
        this.id = id;
        this.post = post;
        this.postedOn = postedOn;
        this.author = author;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public Date getPostedOn() {
        return postedOn;
    }

    public void setPostedOn(Date postedOn) {
        this.postedOn = postedOn;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", post='" + post + '\'' +
                ", postedOn=" + postedOn +
                ", author=" + author +
                '}';
    }
}
