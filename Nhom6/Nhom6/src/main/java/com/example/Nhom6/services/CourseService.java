package com.example.Nhom6.services;

import com.example.Nhom6.models.Course;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {

    private List<Course> listCourse = new ArrayList<>();

    public void add(Course newProduct) {
        listCourse.add(newProduct);
    }

    public List<Course> getAll() {
        return listCourse;
    }
}

