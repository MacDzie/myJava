package com.pjwstk.springboot.repository;

import com.pjwstk.springboot.domain.Actor;
import com.pjwstk.springboot.domain.Film;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ActorRepositoryList {

    private static List<Actor> db = new ArrayList<Actor>();
    private static int currentId = 1;

    public List<Actor> getAll() {
        return db;
    }

    public void addActor(Actor actor) {
        actor.setId(currentId++);
        db.add(actor);
    }

    public Actor getActor(int id) {
        for (Actor actor : db) {
            if (actor.getId() == id) {
                return actor;
            }
        }
        return null;
    }

    public void deleteActor(int id) {
        db.remove(getActor(id));
    }

    public Actor updateActor(Actor a, Actor actor) {
        a.setName(actor.getName());
        a.setSurname(actor.getSurname());
        a.setFilms(actor.getFilms());
        return a;
    }

    public void addFilm(Film film, Actor actor) {
        actor.getFilms().add(film);
    }
}