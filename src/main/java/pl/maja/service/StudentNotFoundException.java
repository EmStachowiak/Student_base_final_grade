package pl.maja.service;

public class StudentNotFoundException extends  Exception{

    public StudentNotFoundException() {
        super("Student not found");
    }
}
