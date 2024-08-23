package com.andymartinez1.sms.controller;

import com.andymartinez1.sms.dto.StudentDTO;
import com.andymartinez1.sms.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // GET all students table
    @GetMapping("/students")
    public String listStudents(Model model){
        List<StudentDTO> students = studentService.getAllStudents();
        model.addAttribute("students", students);
        //Return view
        return "students";
    }

    // New student request
    @GetMapping("/students/new")
    public String newStudent(Model model){
        // Student form data
        StudentDTO studentDTO = new StudentDTO();
        model.addAttribute("student", studentDTO);
        // Return view
        return "create_student";
    }

    // Save student form submit request
    @PostMapping("/students")
    public String saveStudent(@Valid @ModelAttribute("student") StudentDTO student,
                              BindingResult result,
                              Model model){

        if(result.hasErrors()){
            model.addAttribute("student", student);
            return "create_student";
        }

        studentService.createStudent(student);
        // Return view
        return "redirect:/students";
    }

    // Edit student request
    @GetMapping("/students/{studentId}/edit")
    public String editStudent(@PathVariable("studentId") Long studentId, Model model){
        StudentDTO student = studentService.getStudentById(studentId);
        model.addAttribute("student", student);
        // Return view
        return "edit_student";
    }

    // Edit student form submit request
    @PostMapping("/students/{studentId}")
    public String updateStudent(@PathVariable("studentId") Long studentId,
                                @Valid @ModelAttribute("student") StudentDTO studentDTO,
                                BindingResult result,
                                Model model){
        if(result.hasErrors()){
            model.addAttribute("student", studentDTO);
            return "edit_student";
        }

        studentDTO.setId(studentId);
        studentService.updateStudent(studentDTO);
        return "redirect:/students";
    }

    // Delete student request
    @GetMapping("/students/{studentId}/delete")
    public  String deleteStudent(@PathVariable("studentId") Long studentId){
        studentService.deleteStudent(studentId);
        return "redirect:/students";
    }

    // View student request
    @GetMapping("/students/{studentId}/view")
    public String viewStudent(@PathVariable("studentId") Long studentId,
                              Model model){
        StudentDTO studentDTO = studentService.getStudentById(studentId);
        model.addAttribute("student", studentDTO);
        return "view_student";
    }
}
