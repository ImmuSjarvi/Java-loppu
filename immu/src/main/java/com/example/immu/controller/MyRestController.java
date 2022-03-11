package com.example.immu.controller;

import com.example.immu.data.Courses;
import com.example.immu.data.Students;
import com.example.immu.service.CourseService;
import com.example.immu.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class MyRestController {

    @Autowired
    StudentService myStudentService;
    @Autowired
    CourseService myCourseService;

    //Luetaan kaikki opiskelijat
    @GetMapping("students")
    public List<Students> getStudents(){
        return myStudentService.getStudents();
    }

    //opiskelija Id:llä haku
    @GetMapping("students/{id}")
    public List<Students> getStudentById(@PathVariable int id){
        return myStudentService.getStudentById(id);
    }

    //Lisätään opiskelija
    @PostMapping("addstudent")
    public String addStudent(@RequestBody Students student){
        myStudentService.addStudent(student);
        return "Lisätty";
    }


    //Haetaan kaikki kurssit
    @GetMapping("courses")
    public List<Courses> getCourses(){
        return myCourseService.getCourses();
    }

    //Haetaan kaikki kurssit, joilla sama opettaja
    @GetMapping("courses/{teacher}")
    public List<Courses> getTeacherCourses(@PathVariable String teacher){
        return myCourseService.getCoursesByTeacher(teacher);
    }

    //Lisätään kurssi
    @PostMapping("addcourse")
    public String addCourse(@RequestBody Courses course){
        myCourseService.addCourse(course);
        return "Kurssi lisätty";
    }

}
