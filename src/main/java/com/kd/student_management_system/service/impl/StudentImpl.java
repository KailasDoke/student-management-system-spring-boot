package com.kd.student_management_system.service.impl;

import com.kd.student_management_system.dto.Studentdto;
import com.kd.student_management_system.entity.Student;
import com.kd.student_management_system.mapper.StudentMapper;
import com.kd.student_management_system.repository.StudentRepository;
import com.kd.student_management_system.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentImpl implements StudentService {

    private StudentRepository studentRepository;


    public StudentImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Studentdto> getAllStudent() {
        List<Student> students = studentRepository.findAll();
        List<Studentdto> studentdto = students.stream()
                .map((student)-> StudentMapper.mapToStudentDto(student))
                .collect(Collectors.toList());
        return studentdto;
    }

    @Override
    public void creatyeStudent(Studentdto studentDto) {
        Student student = StudentMapper.mapToStudent(studentDto);
        studentRepository.save(student);
    }

    @Override
    public Studentdto getStudentById(Long studentId) {
        Student student = studentRepository.findById(studentId).get();
        Studentdto studentDto = StudentMapper.mapToStudentDto(student);

        return studentDto;
    }

    @Override
    public void updateStudent(Studentdto studentdto) {
        studentRepository.save(StudentMapper.mapToStudent(studentdto));
    }

    @Override
    public void deleteStudent(Long studentId) {
        studentRepository.deleteById(studentId);
    }
}
