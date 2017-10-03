package com.suru.springboot.bootrest.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Course {
	@Id
	@GeneratedValue
	private Long id;
	private String code;
	private String name;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(joinColumns = { @JoinColumn(name = "student") }, inverseJoinColumns = { @JoinColumn(name = "course") })
	private Set<Student> students = new HashSet<>();

	public Course() {
	}

	public Course(Long id, String code, String name) {
		this.id = id;
		this.code = code;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", code=" + code + ", name=" + name + "]";
	}

}
