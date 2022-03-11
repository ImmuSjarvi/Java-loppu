package com.example.immu.service;


import com.example.immu.data.Courses;
import com.example.immu.data.Students;
import com.example.immu.data.StudentsOnCourses;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentOnCourseService {

    private List<StudentsOnCourses> SOC = new ArrayList<>();

    //Studenttin lisäys kurssille
    public void addStudentOnCourse(StudentsOnCourses studentsoncourse) {
        SOC.add(studentsoncourse);
    }

    //Palauttaa listan
    public List<StudentsOnCourses> getStudentsOnCourses(){
        return new ArrayList<>(SOC);
    }

    //Palauttaa kurssit joilla opiskelija on,  annetaan parametrinä
    public List<StudentsOnCourses> getSOCbyStudentId(int id){
        List<StudentsOnCourses> foundCourses = new ArrayList<>();

        for (StudentsOnCourses s : SOC) {
            if(s.getStudentId()==id) {
                foundCourses.add(s);
            }
        }
        return foundCourses;
    }
}
