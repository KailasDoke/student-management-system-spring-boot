package com.kd.student_management_system.controller;

import com.kd.student_management_system.dto.Studentdto;
import com.kd.student_management_system.service.StudentService;
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
public class StudenController {
    private StudentService studentService;

    public StudenController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public String listStudent(Model model){
        List<Studentdto> students = studentService.getAllStudent();
        model.addAttribute("students" , students);
        return "students";

    }

    //Handaler method to handel new student request

    @GetMapping("/students/new")
    public String newStudent(Model model){
        //student model object here
        Studentdto studentdto = new Studentdto();
        model.addAttribute("student" , studentdto);
        return "create_student";
    }

    //handaler method to save the data into mysql
    @PostMapping("/students")
    public String savedetails(@Valid @ModelAttribute("student") Studentdto student,
                              BindingResult result,
                              Model model){

        if(result.hasErrors()){
            model.addAttribute("student",student);
            return "create_student";
        }
        studentService.creatyeStudent(student);
        return "redirect:/students";
    }

    //handlar method to handl edit sdtudent button
    @GetMapping("/students/{studentId}/edit")
    public String editstudent(@PathVariable("studentId") Long studentId,
                                Model model)    {
        Studentdto student = studentService.getStudentById(studentId);
        model.addAttribute("student",student);
        return "edit_student";
    }

    // handler handle the submit request of the  edit student

    @PostMapping("/students/{studentId}")
    public String updatstd(@PathVariable("studentId") Long studentId,
                           @ModelAttribute("student") Studentdto studentdto,
                           BindingResult result,
                           Model model){

        if (result.hasErrors()){
            model.addAttribute("student" , studentdto);
            return "edit_student";
        }
            studentdto.setId(studentId);
            studentService.updateStudent(studentdto);
            return "redirect:/students";
    }

    //handler to handle student delete request

    @GetMapping("/students/{studentId}/delete")
    public String deletestudent(@PathVariable("studentId") Long studentId){
            studentService.deleteStudent(studentId);
        return "redirect:/students";
    }

    @GetMapping("/students/{studentId}/View")
    public String viewbtn(@PathVariable("studentId") Long studentId
                            ,Model model){
        Studentdto studentdto = studentService.getStudentById(studentId);
        model.addAttribute("student" ,studentdto);
        return "view_student";
    }

}

