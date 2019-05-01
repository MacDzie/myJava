package com.pjwstk.springboot.repository;

import com.pjwstk.springboot.domain.Actor;
import com.pjwstk.springboot.domain.Film;
import com.pjwstk.springboot.domain.FilmComment;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class FilmRepositoryList {

    private static List<Film> db = new ArrayList<Film>();
    private static int currentId = 1;
    private static int commentId = 1;

    public List<Film> getAll() {
        return db;
    }

    public void addFilm(Film film) {
        film.setId(currentId++);
        db.add(film);
    }

    public Film getFilm(int id) {
        for (Film film : db) {
            if (film.getId() == id) {
                return film;
            }
        }
        return null;
    }

    public void deleteFilm(int id) {
        db.remove(getFilm(id));
    }

    public Film updateFilm(Film f, Film film) {
        f.setTitle(film.getTitle());
        return f;
    }

    public void addFilmComment(FilmComment comment, Film film) {
        comment.setId(commentId++);
        film.getComments().add(comment);
    }

    public void deleteComment(int id, Film film) {
        for (FilmComment comment : film.getComments()) {
            if(comment.getId() == id) {
                film.getComments().remove(comment);
            }
        }
    }

    public void addActor (Film film, Actor actor) {
        film.getActors().add(actor);
    }
}