package pl.maja.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.maja.model.Student;
import pl.maja.service.StudentNotFoundException;
import pl.maja.service.StudentService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/students")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<Student> cerateStudent(@RequestBody Student student) {
        studentService.saveStudent(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(student);
    }

    @GetMapping("/{id}")
    public Optional<Student> getStudent(@PathVariable int id) {
        return studentService.getStudentById(id);
    }

    @GetMapping
    public List<Student> getAll() {
        return studentService.listAll();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable int id) {
        studentService.deleteStudentById(id);
        return ResponseEntity.noContent().build();
    }


    @PutMapping("/{id}")
    public ResponseEntity<Void> updateStudent(@PathVariable int id, @RequestBody Student student) {
        try {
            studentService.updateStudentById(id, student);
            return ResponseEntity.noContent().build();
        } catch (StudentNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> updateOnlyPart(@PathVariable int id, @RequestBody Student student) {
        try {
            studentService.updateStudentByIdPatch(id, student);
            return ResponseEntity.noContent().build();
        } catch (StudentNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }


}
