package com.example.STUDENT.controller;

import com.example.STUDENT.entity.Student;
import com.example.STUDENT.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;


    @GetMapping("/home")
    public String home() {

        return "home";
    }

    @GetMapping("/stuForm")
    public String stuForm(Model model) {
        model.addAttribute("student", new Student());
        return "addstudent";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Student student) {

        studentService.save(student);
        return "redirect:/";

    }

    @GetMapping("")
    public String getAllStudent(Model model) {
        List<Student> list = studentService.getAll();
        model.addAttribute("list", list);
        return "home";

    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        Student student = studentService.getById(id);
        model.addAttribute("student", student);
        return "addstudent";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        studentService.delete(id);
        return "redirect:/";
    }


}
