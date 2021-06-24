package com.be.architectureseries_roomdatabasetutorial.Room;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.Room;
@Entity
public class Student {
    @PrimaryKey  (autoGenerate = true)
        public int std_id;
    private String std_firstname;
    private String std_lastname;
    private String std_class;

    public String getStd_firstname() {
        return std_firstname;
    }

    public void setStd_firstname(String std_firstname) {
        this.std_firstname = std_firstname;
    }

    public String getStd_lastname() {
        return std_lastname;
    }

    public void setStd_lastname(String std_lastname) {
        this.std_lastname = std_lastname;
    }

    public String getStd_class() {
        return std_class;
    }

    public void setStd_class(String std_class) {
        this.std_class = std_class;
    }

    public Student(String std_firstname, String std_lastname, String std_class) {
        this.std_firstname = std_firstname;
        this.std_lastname = std_lastname;
        this.std_class = std_class;
    }
}
