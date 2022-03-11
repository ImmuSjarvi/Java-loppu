package com.example.immu.service;

import com.example.immu.data.Students;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Service
public class StudentFileService {


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
}
