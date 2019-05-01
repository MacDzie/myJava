package com.pjwstk.springboot.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

public class Film {

    private int id;
    private String title;
    private double rating;
    private int countRating;
    private List<FilmComment> comments;
    @JsonIgnore
    private List<Actor> actors;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getCountRating() {
        return countRating;
    }

    public void setCountRating(int countRating) {
        this.countRating = countRating;
    }

    public List<FilmComment> getComments() {
        return comments;
    }

    public void setComments(List<FilmComment> comments) {
        this.comments = comments;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }
}
