package Entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "subscriptions")
public class Subscription implements Serializable
{
    @EmbeddedId
    private SubID id;

    @Column(name = "subscription_date")
    private Date subscriptionDate;

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "student_id", insertable=false, updatable=false)
    private Student student;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "course_id", insertable = false, updatable=false)
    private Course course;



    public SubID getId() {
        return id;
    }

    public void setId(SubID id) {
        this.id = id;
    }

    public Date getSubscriptionDate() {
        return subscriptionDate;
    }

    public void setSubscriptionDate(Date subscriptionDate) {
        this.subscriptionDate = subscriptionDate;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public String toString() {return id + " " + subscriptionDate;}
}

