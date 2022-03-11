package com.example.immu.service;

import com.example.immu.data.Students;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Service
public class StudentFileService {
    int i = 0;

    public void writeStudentsToFile(List<Students> students, boolean b) throws IOException {
        FileWriter fw = new FileWriter( new File("students.txt"), true);

        //Kirjoita studentit tiedostoon

            fw.write(students.get(i).getFname());
            fw.write("---");
            fw.write(students.get(i).getLname());
            fw.write("---");
            fw.write(students.get(i).getAge() + System.lineSeparator());
            fw.close();
            i++;

    }

    public List<Students> readStudentsFromFile() throws FileNotFoundException {
        Scanner sc = new Scanner(new File("students.txt"));
        List<Students> students = new ArrayList<>();
        //Lue tiedostosta esim rivi kerrallaan ja luo oliot
        // ja lisää uuteen listaan


        while(sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] info = line.split("---");
            System.out.println(info[0]);
            Students s = new Students(info[0], info[1], Integer.parseInt(info[2]));
            students.add(s);
        }

        return students;
    }
}
