package com.andymartinez1.sms.mapper;

import com.andymartinez1.sms.dto.StudentDTO;
import com.andymartinez1.sms.entity.Student;

public class StudentMapper {
    public static StudentDTO mapToStudentDTO(Student student){
        StudentDTO studentDTO = new StudentDTO(
                student.getId(),
                student.getFirstName(),
                student.getLastName(),
                student.getEmail()
        );
        return studentDTO;
    }

    public static Student mapToStudent(StudentDTO studentDTO){
        Student student = new Student(
                studentDTO.getId(),
                studentDTO.getFirstName(),
                studentDTO.getLastName(),
                studentDTO.getEmail()
        );
        return student;
    }
}
