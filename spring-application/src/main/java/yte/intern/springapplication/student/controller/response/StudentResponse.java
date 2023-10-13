package yte.intern.springapplication.student.controller.response;

import yte.intern.springapplication.student.entity.Student;

public record StudentResponse(
        String name,
        String surname,
        String email,
        String studentNumber,
        String tcKimlikNo
) {
    public StudentResponse(Student student){
        this(student.getName(),student.getSurname(),student.getEmail(),student.getStudentNumber(),student.getTcKimlikNo());
    }
}
