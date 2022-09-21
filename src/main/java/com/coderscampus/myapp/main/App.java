package com.coderscampus.myapp.main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class App {


	public static void main(String[] args) throws IOException {

		try (BufferedReader reader = new BufferedReader(new FileReader("student-master-list.csv"))) {
			String line = null;

			List<Student> compSci = new ArrayList<Student>();
			List<Student> Stats = new ArrayList<Student>();
			List<Student> apMath = new ArrayList<Student>();

			// scrape and group
			while ((line = reader.readLine()) != null) {
				if (line.contains("COMPSCI")) {
					int id = Integer.parseInt(line.split(",")[0]);
					String name = line.split(",")[1];
					String course = line.split(",")[2];
					int grade = Integer.parseInt(line.split(",")[3]);
					compSci.add(new Student(id, name, course, grade));
					Collections.sort(compSci, new Student(id, name, course, grade));
				}
				if (line.contains("STAT")) {
					int id = Integer.parseInt(line.split(",")[0]);
					String name = line.split(",")[1];
					String course = line.split(",")[2];
					int grade = Integer.parseInt(line.split(",")[3]);
					Stats.add(new Student(id, name, course, grade));
					Collections.sort(Stats, new Student(id, name, course, grade));
				}
				if (line.contains("APMTH")) {
					int id = Integer.parseInt(line.split(",")[0]);
					String name = line.split(",")[1];
					String course = line.split(",")[2];
					int grade = Integer.parseInt(line.split(",")[3]);
					apMath.add(new Student(id, name, course, grade));
					Collections.sort(apMath, new Student(id, name, course, grade));
				}
			}

			
			
			
			try (FileWriter writer = new FileWriter("course1.csv")) {
				writer.write("Student ID, STudent Name, Course, Grade \n");
				for (int i = 0; i < compSci.size(); i++) {
					writer.write(getOutput(compSci.get(i)));
				}

			}
			
			try (FileWriter writer = new FileWriter("course2.csv")) {
				writer.write("Student ID, STudent Name, Course, Grade \n");
				for (int i = 0; i < Stats.size(); i++) {
					writer.write(getOutput(Stats.get(i)));
				}
			}
			
			try (FileWriter writer = new FileWriter("course3.csv")) {
				writer.write("Student ID, STudent Name, Course, Grade \n");
				for (int i = 0; i < apMath.size(); i++) {
					writer.write(getOutput(apMath.get(i)));
				}
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
	}

	public static String getOutput(Student student) throws IOException {
		String output = student.getID() + "," + student.getName() + "," + student.getCourse() + "," + student.getGrade()
				+ "\n";
		return output;
	}
}
