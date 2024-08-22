package com.andymartinez1.sms.repository;

import com.andymartinez1.sms.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
