package com.pjwstk.springboot.service;

import com.pjwstk.springboot.domain.Actor;
import com.pjwstk.springboot.domain.Film;
import com.pjwstk.springboot.domain.FilmComment;
import com.pjwstk.springboot.repository.FilmRepositoryList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class FilmService {

    @Autowired
    FilmRepositoryList repository;

    public List<Film> getAll() {
        return repository.getAll();
    }

    public Film addFilm(Film film) {
        film.setActors(new ArrayList<>());
        film.setComments(new ArrayList<>());
        repository.addFilm(film);
        return film;
    }

    public Film getFilm(int id) {
        return repository.getFilm(id);
    }

    public Film updateFilm(Film f, Film film) {
        return repository.updateFilm(f, film);
    }

    public void deleteFilm(int id){
        repository.deleteFilm(id);
    }

    public void addFilmComment(FilmComment comment, Film film) {
        repository.addFilmComment(comment, film);
    }

    public void updateRating(Film film, int rating) {
        double newRating = (film.getRating() * film.getCountRating() + rating) / (film.getCountRating() + 1);
        film.setCountRating(film.getCountRating() + 1);
        film.setRating(newRating);
    }

    public void addActors(Film film, Actor actor) {
        repository.addActor(film, actor);
    }

    public void deleteComments(int id, Film film) {
        repository.deleteComment(id, film);
    }
}