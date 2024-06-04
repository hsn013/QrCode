package com.harupdesh.QrCode.controller;

import com.google.zxing.WriterException;
import com.harupdesh.QrCode.Qr.QrCodeGenerated;
import com.harupdesh.QrCode.entity.Student;
import com.harupdesh.QrCode.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private final StudentService studentService;

    @GetMapping
    public ResponseEntity<List<Student>> getStudents() throws IOException, WriterException {
        List<Student> students = studentService.getStudents();
        if (students.size()!=0){
            for (Student student:students){
                QrCodeGenerated.generatedQrCode(student);
            }
        }
        return ResponseEntity.ok(studentService.getStudents());
    }

    @PostMapping
    public Student addStudent(@RequestBody Student student){
        return studentService.addStudent(student);
    }

    @GetMapping("/{id}")
    public Student findById(@PathVariable("id") long id){
        return studentService.findById(id);
    }

}
