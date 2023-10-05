package pl.maja.service;


import org.springframework.stereotype.Service;
import pl.maja.model.Student;
import pl.maja.repository.StudentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {


    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void saveStudent(Student student) {
        studentRepository.save(student);
    }

    public Optional<Student> getStudentById(int id) {
        return  studentRepository.findById(id);
    }

    public List<Student> listAll() {
        return studentRepository.findAll();
    }

    public void deleteStudentById(int id) {
        studentRepository.deleteById(id);
    }


    public void updateStudentById(int id, Student updatedStudent) throws StudentNotFoundException {
        Optional<Student> existingStudent = getStudentById(id);

        if (existingStudent.isPresent()) {
           Student student = existingStudent.get();

           student.setCourse(updatedStudent.getCourse());
           student.setFinalGrade(updatedStudent.getFinalGrade());
           student.setStudent_name(updatedStudent.getStudent_name());

           studentRepository.save(student);
        } else {
            throw new StudentNotFoundException();
        }
    }



    public void updateStudentByIdPatch(int id, Student updatedStudent) throws StudentNotFoundException {
        Optional<Student> existingStudent = getStudentById(id);

        if (existingStudent.isPresent()) {
            Student student = existingStudent.get();

            if (updatedStudent.getCourse() != null) {
                student.setCourse(updatedStudent.getCourse());
            }

            if (updatedStudent.getFinalGrade() != 0) {
                student.setFinalGrade(updatedStudent.getFinalGrade());
            }
            if (updatedStudent.getStudent_name() != null) {
                student.setStudent_name(updatedStudent.getStudent_name());
            }

            studentRepository.save(student);
        } else {
            throw new StudentNotFoundException();
        }
    }

}
