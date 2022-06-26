package com.starter.demo.controller;

import com.starter.demo.entity.Department;
import com.starter.demo.repository.DeptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dept")
public class DeptController {

    @Autowired
    private DeptRepository deptRepository;

    @GetMapping("/greet")
    public String hello(){
        return "greeting from dept controller";
    }

    @PostMapping("/create")
    public String createDept(@RequestBody Department department) {

        department = deptRepository.save(department);

        if (department.getDepartmentId() != null) {
            return "saved successfully";
        } else return "something error";
    }
}
