package Entities;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
public class SubID implements Serializable
{
    @Column(name = "student_id")
    public int studentId;

    @Column(name = "course_id")
    public int courseId;


    public SubID(Integer studentId, Integer courseId) {
        this.studentId = studentId;
        this.courseId = courseId;
    }

    public SubID() {}


    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String toString() {return studentId + " " + courseId;}
}
