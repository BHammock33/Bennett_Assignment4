package com.coderscampus.myapp.main;

import java.util.Comparator;

public class Student implements Comparator<Student> {

	private int id;
	private String studentName;
	private String studentCourse;
	private int studentGrade;

	
	public Student(int id, String name, String course, int grade) {
		super();
		this.id = id;
		studentName = name;
		studentCourse = course;
		studentGrade = grade;
	}


	public int getID() {
		return id;
	}


	public void setID(int id) {
		this.id = id;
	}


	public String getName() {
		return studentName;
	}


	public void setName(String name) {
		studentName = name;
	}


	public String getCourse() {
		return studentCourse;
	}


	public void setCourse(String course) {
		studentCourse = course;
	}


	public int getGrade() {
		return studentGrade;
	}


	public void setGrade(int grade) {
		studentGrade = grade;
	}

	public String toString() {
		return "Student [id=" + id +", Name ="+ studentName + ", Course= "+ studentCourse +", Grade="+ studentGrade +"]";
	}
	
	//descending order comparator 
	@Override
	public int compare(Student o1, Student o2) {
		if(o1.studentGrade == o2.studentGrade) {
			return 0;
		}else if (o1.studentGrade > o2.studentGrade) {
			return -1;
		}else {
			return 1;
		}
	
	}

}
