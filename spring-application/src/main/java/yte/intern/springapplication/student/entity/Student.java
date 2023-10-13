package yte.intern.springapplication.student.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import yte.intern.springapplication.common.BaseEntity;
import yte.intern.springapplication.student.controller.request.StudentUpdateRequest;

@Entity
@NoArgsConstructor
@Getter
public class Student extends BaseEntity {
    private String name;
    private String surname;
    private String email;
    private String studentNumber;
    private String tcKimlikNo;

    public Student(String name, String surname, String email, String studentNumber, String tcKimlikNo) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.studentNumber = studentNumber;
        this.tcKimlikNo = tcKimlikNo;
    }

    public void updateStudentInformationForDepartmenChange(String email,String studentNumber){
        this.email=email;
        this.studentNumber=studentNumber;
    }

    public void update(StudentUpdateRequest studentUpdateRequest){
        this.name = studentUpdateRequest.name();
        this.surname = studentUpdateRequest.surname();
        this.email = studentUpdateRequest.email();
        this.studentNumber = studentUpdateRequest.studentNumber();
    }
}
