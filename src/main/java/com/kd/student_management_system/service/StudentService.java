package com.kd.student_management_system.service;

import com.kd.student_management_system.dto.Studentdto;

import java.util.List;

public interface StudentService {
    List<Studentdto> getAllStudent();

    void creatyeStudent(Studentdto student);

    Studentdto getStudentById(Long studentId);

    void updateStudent(Studentdto studentdto);

    void deleteStudent(Long studentId);
}
