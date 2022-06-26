package com.starter.demo;

import com.starter.demo.entity.Department;
import com.starter.demo.entity.Student;
import com.starter.demo.repository.DeptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

import java.util.ArrayList;
import java.util.Arrays;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class DemoApplication implements CommandLineRunner {

	@Autowired
	private DeptRepository deptRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Department dept1 = new Department(null, "CSE",
				Arrays.asList(new Student(null, "A"),
						new Student(null, "B"),
						new Student(null, "C")));
		Department dept2 = new Department(null, "EEE",
				Arrays.asList(new Student(null, "D"),
						new Student(null, "E")));
		Department dept3 = new Department(null, "CE", null);
		deptRepository.saveAll(Arrays.asList(dept1, dept2, dept3));
	}
}
