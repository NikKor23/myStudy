package Entities;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
public class PLID implements Serializable {

    public PLID( String student, String course) {
        this.studentName = student;
        this.courseName =course;;
    }

    public PLID () {}

    @Column(name = "student_name")
    private String studentName;
    @Column(name = "course_name")
    private String courseName;

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String toString() {return studentName + " " + courseName;}
}
