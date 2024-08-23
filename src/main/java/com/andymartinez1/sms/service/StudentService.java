package com.andymartinez1.sms.service;

import com.andymartinez1.sms.dto.StudentDTO;

import java.util.List;

public interface StudentService {
    List<StudentDTO> getAllStudents();

    void createStudent(StudentDTO student);
}
