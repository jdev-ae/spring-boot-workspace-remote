package com.suru.springboot.sampledataapp.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.data.annotation.CreatedDate;

@Entity
public class Post {
	@Id
	@GeneratedValue
	private Long id;
	private String title;
	private String postData;
	@CreatedDate
	private Date postedOn;

	@ManyToOne
	private Author author;

	public Post() {
	}

	public Post(Long id, String title, String postData, Date postedOn, Author author) {
		super();
		this.id = id;
		this.title = title;
		this.postData = postData;
		this.postedOn = postedOn;
		this.author = author;
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

	public String getPostData() {
		return postData;
	}

	public void setPostData(String postData) {
		this.postData = postData;
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
		return "Post [id=" + id + ", title=" + title + ", postData=" + postData + ", postedOn=" + postedOn + ", author="
				+ author + "]";
	}

}
