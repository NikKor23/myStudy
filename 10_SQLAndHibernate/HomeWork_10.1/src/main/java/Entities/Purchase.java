package Entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "purchaselist")
public class Purchase
{
    @EmbeddedId
    private PLID id;

    private int price;

    @Column(name = "subscription_date")
    private Date subscriptionDate;


    public PLID getId() {
        return id;
    }

    public void setId(PLID id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getSubscriptionDate() {
        return subscriptionDate;
    }

    public void setSubscriptionDate(Date subscriptionDate) {
        this.subscriptionDate = subscriptionDate;
    }

    public String toString() { return id + " " + price + " " + subscriptionDate;}

}


