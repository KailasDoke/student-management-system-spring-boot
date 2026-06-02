package com.kd.student_management_system.mapper;

import com.kd.student_management_system.dto.Studentdto;
import com.kd.student_management_system.entity.Student;

public class StudentMapper {

    public static Studentdto mapToStudentDto(Student student){
            Studentdto studentdto = new Studentdto(
            student.getId(),
            student.getFirstname(),
            student.getLastname(),
            student.getEmail()
            );
            return studentdto;
    }

    public static Student mapToStudent(Studentdto studentdto){
            Student student = new Student(
                    studentdto.getId(),
                    studentdto.getFirstname(),
                    studentdto.getLastname(),
                    studentdto.getEmail()
            );
            return  student;
    }
}
