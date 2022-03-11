package com.example.immu.service;

import com.example.immu.data.Courses;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {
    private List<Courses> courses = new ArrayList<>();

    //Kurssin lisäys listaan
    public void addCourse(Courses course){
        courses.add(course);
    }

    //Palauttaa kurssilistan
    public List<Courses> getCourses(){
        return new ArrayList<>(courses);
    }

    //Palauttaa kaikki kurssit, joilla on sama opettaja. opettaja annetaan parametrinä
    public List<Courses> getCoursesByTeacher(String teacher){
        List<Courses> foundCourses = new ArrayList<>();

        for (Courses c : courses) {
            if(c.getTeacher().equals(teacher)) {
                foundCourses.add(c);
            }
        }
        return foundCourses;
    }
}
