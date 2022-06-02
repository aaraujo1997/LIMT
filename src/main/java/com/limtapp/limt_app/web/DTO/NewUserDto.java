package com.limtapp.limt_app.web.DTO;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class NewUserDto implements Serializable {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private List<Double> weight_log;
    private List<Integer> calories_log;
    private List<Date> date_log;

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setWeight_log(List<Double> weight_log) {
        this.weight_log = weight_log;
    }

    public void setCalories_log(List<Integer> calories_log) {
        this.calories_log = calories_log;
    }

    public void setDate_log(List<Date> date_log) {
        this.date_log = date_log;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public List<Double> getWeight_log() {
        return weight_log;
    }

    public List<Integer> getCalories_log() {
        return calories_log;
    }

    public List<Date> getDate_log() {
        return date_log;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NewUserDto entity = (NewUserDto) o;
        return Objects.equals(this.firstName, entity.firstName) &&
                Objects.equals(this.lastName, entity.lastName) &&
                Objects.equals(this.email, entity.email) &&
                Objects.equals(this.password, entity.password) &&
                Objects.equals(this.weight_log, entity.weight_log) &&
                Objects.equals(this.calories_log, entity.calories_log) &&
                Objects.equals(this.date_log, entity.date_log);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, email, password, weight_log, calories_log, date_log);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "firstName = " + firstName + ", " +
                "lastName = " + lastName + ", " +
                "email = " + email + ", " +
                "password = " + password + ", " +
                "weight_log = " + weight_log + ", " +
                "calories_log = " + calories_log + ", " +
                "date_log = " + date_log + ")";
    }
}
