package com.pjwstk.springboot.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

public class Actor {

    private int id;
    private String name;
    private String surname;
    @JsonIgnore
    private List<Film> films;

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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public List<Film> getFilms() {
        return films;
    }

    public void setFilms(List<Film> films) {
        this.films = films;
    }
}