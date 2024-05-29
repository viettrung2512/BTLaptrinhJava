package com.example.Nhom6.controller;


import com.example.Nhom6.models.Course;
import com.example.Nhom6.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

public class CourseController {
    @Autowired
    private CourseService courseService;
    @GetMapping("/create")
    public String create(Model model)
    {
        model.addAttribute( "course", new Course());
        return "create";
    }
    @PostMapping("/create")
    public String create(Course newCourse, Model model)
    {
        courseService.add(newCourse);
        return "redirect:/home";
    }

}

