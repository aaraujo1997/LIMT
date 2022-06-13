package com.limtapp.limt_app.model;

import com.limtapp.limt_app.web.DTO.NewUserDto;
import com.sun.istack.NotNull;

import java.util.*;
import javax.persistence.*;

@Entity
@Table(name = "user",uniqueConstraints = @UniqueConstraint(columnNames = "email"))


public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    @NotNull
    private String firstName;

    @Column(name = "last_name")
    @NotNull
    private String lastName;
    @NotNull
    private String email;
    @NotNull
    private String password;

    @ElementCollection
    private List<Double> weight_log;

    @ElementCollection
    private List<Integer> calories_log;

    @ElementCollection
    private List<Date> date_log;

    private int goalWeight;

    private int estimatedTDEE;

    public User() {
    }

    public User(String firstName, String lastName, String email, String password) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.weight_log = new ArrayList<Double>();
        this.calories_log = new ArrayList<Integer>();
        this.date_log = new ArrayList<Date>();
        this.goalWeight = 0;
        this.estimatedTDEE = 0;
    }

    public User(NewUserDto newUserDTO)
    {
        this.firstName = newUserDTO.getFirstName();
        this.lastName = newUserDTO.getLastName();
        this.email = newUserDTO.getEmail();
        this.password = newUserDTO.getPassword();
        this.weight_log = new ArrayList<Double>();
        this.calories_log = new ArrayList<Integer>();
        this.date_log = new ArrayList<Date>();
        this.goalWeight = 0;
        this.estimatedTDEE = 0;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Double> getWeight_log() {
        return weight_log;
    }

    public void setWeight_log(List<Double> weight_log) {
        this.weight_log = weight_log;
    }

    public List<Integer> getCalories_log() {
        return calories_log;
    }

    public void setCalories_log(List<Integer> calories_log) {
        this.calories_log = calories_log;
    }

    public List<Date> getDate_log() {
        return date_log;
    }

    public void setDate_log(List<Date> date_log) {
        this.date_log = date_log;
    }

    public void addWeight(double weight)
    {
        this.weight_log.add(weight);
    }

    public void addCalories(int calories)
    {
        this.calories_log.add(calories);
    }

    public void addDate(Date date)
    {
        this.date_log.add(date);
    }

    public int getGoalWeight() {
        return goalWeight;
    }

    public void setGoalWeight(int goalWeight) {
        this.goalWeight = goalWeight;
    }

    public int getEstimatedTDEE() {
        return estimatedTDEE;
    }

    public void setEstimatedTDEE(int estimatedTDEE) {
        this.estimatedTDEE = estimatedTDEE;
    }
}
