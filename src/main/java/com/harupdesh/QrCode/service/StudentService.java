package com.harupdesh.QrCode.service;

import com.harupdesh.QrCode.entity.Student;
import com.harupdesh.QrCode.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    public Student addStudent(Student student){
        return studentRepository.save(student);
    }

    public Student findById(Long id){
        return studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Student not found"));
    }

}
