package yte.intern.springapplication.student.service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import yte.intern.springapplication.common.response.MessageResponse;
import yte.intern.springapplication.common.response.MessageType;
import yte.intern.springapplication.student.controller.request.StudentUpdateRequest;
import yte.intern.springapplication.student.entity.Student;
import yte.intern.springapplication.student.repository.StudentRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;
    public MessageResponse addStudent(Student student){
        studentRepository.save(student);
        return new MessageResponse("Student has been added successfully", MessageType.SUCCESS);
    }

    public Student getStudentById(Long id){
        return studentRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }

    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    public MessageResponse deleteStudent(Long id){
        if(!studentRepository.existsById(id)) {
            return new MessageResponse("Student can't be found", MessageType.WARNING);
        }
        studentRepository.deleteById(id);
        return new MessageResponse("Student has been deleted successfly",MessageType.SUCCESS);
    }
    @Transactional
    public MessageResponse updateStudent(Long id, StudentUpdateRequest studentUpdateRequest){
        Student student = studentRepository.findById(id).orElseThrow(EntityNotFoundException::new );
        student.update(studentUpdateRequest);
        studentRepository.save(student);
        return new MessageResponse("Student has been updated", MessageType.SUCCESS);
    }
}
