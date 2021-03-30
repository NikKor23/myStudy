package Entities;

import javax.persistence.*;

@Entity
@Table(name = "LinkedPurchaseList")
public class LinkedPurchase
{
    @EmbeddedId
    private LinkedPurchaseID id;

    public LinkedPurchase(LinkedPurchaseID id) {
        this.id = id;
    }

    public LinkedPurchase() {}

    public LinkedPurchaseID getId() {
        return id;
    }

    public void setId(LinkedPurchaseID id) {
        this.id = id;
    }

    public String toString() {return id.getStudentId() + " " + id.getCourseId();}
}
