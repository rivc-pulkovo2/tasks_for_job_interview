package ru.rivc.pojo;

import java.time.LocalDate;

public class Child extends Human {

    Education education;

    public Child(int id, String name, LocalDate birthday) {
        super(id, name, birthday);
    }

    public Child(int id, String name, LocalDate birthday, Nationality nationality, Education education) {
        super(id, name, birthday);
        this.nationality = nationality;
        this.education = education;
    }

    @Override
    public String toString() {
        return "Child human with " +
                "education=" + education +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", birthday=" + birthday +
                ", nationality=" + nationality +
                '}';
    }
}
