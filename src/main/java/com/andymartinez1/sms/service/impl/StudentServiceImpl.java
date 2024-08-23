package com.andymartinez1.sms.service.impl;

import com.andymartinez1.sms.dto.StudentDTO;
import com.andymartinez1.sms.entity.Student;
import com.andymartinez1.sms.mapper.StudentMapper;
import com.andymartinez1.sms.repository.StudentRepository;
import com.andymartinez1.sms.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<StudentDTO> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        List<StudentDTO> studentDTOs = students.stream()
                .map(student -> StudentMapper.mapToStudentDTO(student))
                .collect(Collectors.toList());
        return studentDTOs;
    }

    @Override
    public void createStudent(StudentDTO studentDTO) {
        Student student = StudentMapper.mapToStudent(studentDTO);
        studentRepository.save(student);
    }
}
