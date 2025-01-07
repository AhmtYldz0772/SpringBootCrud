package com.yildiz.java34springboothello.controller;


import com.yildiz.java34springboothello.model.Student;
import com.yildiz.java34springboothello.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//@Controller bunu eskiden kulanıyorduk şimdi restController daha aktif kullanılır
// lochalhost: 8080
@RestController
@RequestMapping("/api/v1")
public class StudentController {
    // IoC --> bütün kontrolü spring boot kontrol edecek
    // Dı  --> bütün bağımlıkların bir biri ile olan enjoksiyonlarını sağlayacak

    /* önce ki sürümde servic ile controll bir biri ile anlaşır
    @Autowired
    StudentService studentService;
    */

     private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    @GetMapping("/hello1")
    String hello() {
        return "hello";
    }

    @GetMapping("/hello2")
    String hello2() {
        return "hello spring boot ";
    }

    //   JAVA - RESTful  - SQL
    //  READ  - GET  - SELECT     // Servise git.  git öğrencileri al gel.

    // http://localhost:9090/api/v1/student/all
    @GetMapping("/student/all")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }


    //   JAVA - RESTful  - SQL
    //   READ  - GET    - SELECT WHERE      // Servise git. Idsi verilen öğrenciyi al gel.

    // http://localhost:9090/api/v1/student/1
    @GetMapping("/student/{id}")
    public Student getStudent( @PathVariable(name = "id") Long id) {
        return studentService.getStudent(id);
    }



    //   JAVA - RESTful  - SQL
    //   CREATE   - POST - INSERT      // Servise git öğrenciyi ekle.

    // http://localhost:9090/api/v1/student
    @PostMapping("/student")
    public Student addStudent(@RequestBody Student student) {
        return studentService.addStudent(student);
    }

    //   JAVA - RESTful  - SQL
    //   UPDATE - PUT - UPDATE        // Servise git. Gelen yeni bilgiyle eski bilgiyi değiştir.


    // http://localhost:9090/api/v1/student
    @PutMapping("/student")
    public Optional<Student> updateStudent(@RequestBody Student student) {
        return studentService.updateStudent(student);
    }

/*
    // http://localhost:9090/api/v1/student/1
    @PutMapping("/student/{id}")
    public Optional<Student> updateStudent(@PathVariable (name = "id") Long id,
                                           @RequestBody Student student) {
        return studentService.updateStudent(id, student);
    }
*/


    //   JAVA  - RESTful  - SQL
    //   DELETE - DELETE - DELETE       // Servise git. Gelen id veritabanında var mı yok mu?
    // http://localhost:9090/api/v1/student/1
    @DeleteMapping("/student/{id}")
    public String deleteStudent( @PathVariable (name = "id")   Long id) {

        return studentService.deleteStudent(id);
    }
}
