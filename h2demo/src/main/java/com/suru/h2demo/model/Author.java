package com.suru.h2demo.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Author {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String email;

    @OneToMany(mappedBy = "author")
    private List<Post> posts;

    public Author() {
    }

    public Author(Long id, String name, String email, List<Post> posts) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.posts = posts;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", posts=" + posts +
                '}';
    }
}
