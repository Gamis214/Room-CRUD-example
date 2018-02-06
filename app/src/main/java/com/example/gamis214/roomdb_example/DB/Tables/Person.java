package com.example.gamis214.roomdb_example.DB.Tables;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by gamis214 on 18/01/18.
 */
@Entity
public class Person {
    @PrimaryKey (autoGenerate = true)
    public int id;
    public String name;
    public String lastName;
    public String birthDay;
    public String ages;

    public Person(String name, String lastName, String birthDay, String ages) {
        this.name = name;
        this.lastName = lastName;
        this.birthDay = birthDay;
        this.ages = ages;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getAges() {
        return ages;
    }

    public void setAges(String ages) {
        this.ages = ages;
    }
}
