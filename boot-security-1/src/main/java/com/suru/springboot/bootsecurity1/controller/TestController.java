package com.suru.springboot.bootsecurity1.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/posts")
public class TestController {

	@RequestMapping("/all")
	public String getAllPosts() {
		return "getAllPosts";
	}

	@RequestMapping("/drafts")
	public String getDraftPosts() {
		return "getDraftPosts";
	}

	@RequestMapping("/add")
	public String addPosts() {
		return "addPosts";
	}

}
