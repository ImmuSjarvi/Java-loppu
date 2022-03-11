package com.example.immu.service;

import com.example.immu.data.Courses;
import com.example.immu.data.Students;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Service
public class StudentFileService {

    //Kirjoitetaan luodut studentit tiedostoon
    public void writeStudentsToFile(List<Students> students, boolean b) throws IOException {
        FileWriter fw = new FileWriter( "students.txt");

        for (Students s: students) {
            System.out.println("testi");
            fw.write(s.getFname());
            System.out.println(s.getFname());
            fw.write("---");
            fw.write(s.getLname());
            fw.write("---");
            fw.write(s.getAge()+ System.lineSeparator());
        }
        fw.close();

    }

    //Luetaan studentit tiedostosta ja lisätään students listaan
    public List<Students> readStudentsFromFile() throws FileNotFoundException {
        Scanner sc = new Scanner(new File("students.txt"));
        List<Students> students = new ArrayList<>();


        while(sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] info = line.split("---");
            System.out.println(info[0]);
            Students s = new Students(info[0], info[1], Integer.parseInt(info[2]));
            students.add(s);
        }
        sc.close();
        return students;
    }

    //Kirjoitetaan luodut kurssit tiedostoon
    //Jos koitti intin (c.getCredits) tallettaa toisena, ei tallettanu tietoja oikein. En tierä miksi
    public void writeCoursesToFile(List<Courses> courses, boolean b) throws IOException {
        FileWriter fw1 = new FileWriter( "courses.txt");

        for (Courses c: courses) {
            fw1.write(c.getcName());
            fw1.write("---");
            fw1.write(c.getTeacher());
            System.out.println(c.getCredits());
            fw1.write("---");
            fw1.write(c.getCredits()+ System.lineSeparator());
        }
        fw1.close();

    }

    //Luetaan kurssi tiedostosta ja lisätään kurssi listaan
    public List<Courses> readCoursesFromFile() throws FileNotFoundException {
        Scanner sc = new Scanner(new File("courses.txt"));
        List<Courses> courses = new ArrayList<>();


        while(sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] info = line.split("---");
            System.out.println(info[0]);
            Courses c = new Courses(info[0], info[1], Integer.parseInt(info[2]));
            courses.add(c);
        }
        sc.close();
        return courses;
    }
}
