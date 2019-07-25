package com.apside.prono.model;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "player")
public class Player {

    //@Temporal(TemporalType.TIMESTAMP)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;
    private String firstName;
    private String lastName;
    private String mail;
    private Date subscriptionDate;


    public Player() {
        super();
    }


    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMail() {
        return mail;
    }

    public Date getSubscriptionDate() {
        return subscriptionDate;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", mail='" + mail + '\'' +
                ", subscriptionDate=" + subscriptionDate +
                '}';
    }
}
