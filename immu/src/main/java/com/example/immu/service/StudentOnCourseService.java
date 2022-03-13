package com.example.immu.service;


import com.example.immu.data.Courses;
import com.example.immu.data.Students;
import com.example.immu.data.StudentsOnCourses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class StudentOnCourseService {

    @Autowired
    StudentFileService myStudentFileService = new StudentFileService();

    private List<StudentsOnCourses> SOC = new ArrayList<>();


    //Kun StudentOnCourseService olio luodaan springiin, niin haetaan kurssi tiedot filestä
    public StudentOnCourseService(){
        //myStudentFileService= new StudentFileService();
        try {
            SOC = myStudentFileService.readSOCFromFile();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (NullPointerException f){
            System.out.println(f.getMessage());
            f.printStackTrace();
        }
    }


    //Studenttin lisäys kurssille ja kirjotettaan filuun
    public void addStudentOnCourse(StudentsOnCourses studentsoncourse) {
            SOC.add(studentsoncourse);
        try {
            myStudentFileService.writeSOCToFile(SOC,true);
        } catch (IOException e) {
            e.printStackTrace();
        }
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

    //Palauttaa opiskelijat tietyltä kurssilta,  annetaan parametrinä
    public List<StudentsOnCourses> getSOCbyCourseId(int id){
        List<StudentsOnCourses> foundCourses = new ArrayList<>();

        for (StudentsOnCourses s : SOC) {
            if(s.getCourseId()==id) {
                foundCourses.add(s);
            }
        }
        return foundCourses;
    }
}
