package com.example.demo.student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {
    
    private final StudentService stuService;

    @Autowired
    public StudentController(StudentService stuService){
        this.stuService = stuService;
    }

    @GetMapping
	public List<Student> getStudent() {
		return stuService.getStudent();
	}

    @PostMapping
    public void PostStudent(@RequestBody Student student){
        stuService.PostStudent(student);
    }

    @DeleteMapping(path = "{studentId}")
    public void deletStudent(@PathVariable("studentId") Long studentId){
        System.out.println(studentId + " ************");
        stuService.DeleteStudent(studentId);
    }

    @GetMapping(path = "{id, nName, nEmail}")
    public void UpdateStudent(@PathVariable("id") Long id, @PathVariable("nName") String name, @PathVariable("nEmail") String email){
        stuService.UpdateStudent(id, name, email);
    }
}
