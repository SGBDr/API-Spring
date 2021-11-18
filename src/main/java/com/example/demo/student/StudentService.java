package com.example.demo.student;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudent() {
		return studentRepository.findAll();
	}

    public void PostStudent(Student student){
        Optional<Student> st = studentRepository.findStudentByEmail(student.getEmail());
        if(st.isPresent()){
            throw new IllegalStateException("Email aldready token");
        }
        studentRepository.save(student);
    }

    public void DeleteStudent(Long id){
        if(!studentRepository.existsById(id)){
            throw new IllegalStateException(String.format("Student with id %s does not exists", id));
        }
        studentRepository.deleteById(id);
    }

    public void UpdateStudent(Long id, String name, String email){
        if(!studentRepository.existsById(id)){
            throw new IllegalStateException(String.format("Student with id %s does not exists", id));
        }
        studentRepository.updateStudent(id, name, email);
    }
}
