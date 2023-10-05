package pl.maja.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Student {


    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private int id;
    private String course;
    private int finalGrade;
    private String student_name;

    public Student() {
    }

    public Student(String course, int finalGrade, String student_name) {
        this.course = course;
        this.finalGrade = finalGrade;
        this.student_name = student_name;
    }

    public int getId() {
        return id;
    }



    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public int getFinalGrade() {
        return finalGrade;
    }

    public void setFinalGrade(int finalGrade) {
        this.finalGrade = finalGrade;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", course='" + course + '\'' +
                ", final grade=" + finalGrade +
                ", student name='" + student_name + '\'' +
                '}';
    }
}
