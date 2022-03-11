package com.example.immu.data;

public class Courses {
    private String cName;
    private int credits;
    private String teacher;
    private int CourseId;

    //Staattinen muuttuja uniikkia ID:tä varten
    private static int count = 0;

    //Alustin
    public Courses(String cName, int credits, String teacher) {
        this.cName = cName;
        this.credits = credits;
        this.teacher = teacher;
        this.CourseId = count++;
    }

    //****
    //Getterit ja setterit alkaa

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public int getCourseId() {
        return CourseId;
    }
    //Getterit ja setterit loppuu
    //***
}
