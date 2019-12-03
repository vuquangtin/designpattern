package com.designpatterns.structural.facade.student;

import java.util.LinkedList;

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 *
 */
public class Team {
	private String name;
	private LinkedList<Student> students = new LinkedList<Student>();
	private Course course;

	public Team(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setCourse(Course c) {
		course = c;
	}

	public Course getCourse() {
		return course;
	}

	public void addStudent(Student s) {
		students.add(s);
	}

	public LinkedList<Student> getStudents() {
		return students;
	}
}