package com.starter.demo.controller;

import com.starter.demo.entity.Student;
import com.starter.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @InitBinder
    protected void initBinder(ServletRequestDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, null, new CustomDateEditor(dateFormat, false));
    }

    @GetMapping("/greet")
    public String hello(){
        return "greeting from student controller";
    }

    @GetMapping("/count")
    public String count(){
        return "there are many students";
    }

    @PostMapping("/create")
    public String createStudent(HttpServletRequest request, @RequestBody Student student){
        student = studentRepository.save(student);
        if (student.getStudentId() != null) {
            return "saved successfully";
        } else return "something error";
    }
}
