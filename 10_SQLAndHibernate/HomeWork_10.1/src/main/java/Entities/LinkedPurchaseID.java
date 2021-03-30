package Entities;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
public class LinkedPurchaseID implements Serializable
{
    @Column(name = "student_id")
    private int studentId;

    @Column(name = "course_id")
    private int courseId;

    public LinkedPurchaseID() {}
    public LinkedPurchaseID(int studentId, int courseId) {
        this.studentId = studentId;
        this.courseId = courseId;
    }


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
}
