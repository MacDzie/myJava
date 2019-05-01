package com.pjwstk.springboot.controller;

import com.pjwstk.springboot.domain.Actor;
import com.pjwstk.springboot.domain.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.pjwstk.springboot.service.ActorService;
import com.pjwstk.springboot.service.FilmService;

@RestController
@RequestMapping("/filmweb/actor")
public class ActorController {

    @Autowired
    ActorService actorService;
    @Autowired
    FilmService filmService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> getAll() {
        return new ResponseEntity(actorService.getAll(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> addActor(@RequestBody Actor actor) {
        return new ResponseEntity(actorService.addActor(actor), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity<?> getActor(@PathVariable("id") int id) {
        Actor actor = actorService.getActor(id);
        if (actor == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        actorService.getActor(id);
        return new ResponseEntity(actorService.getActor(id), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public ResponseEntity<?> deleteActor(@PathVariable("id") int id) {
        Actor actor = actorService.getActor(id);
        if (actor == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        actorService.deleteActor(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
    public ResponseEntity<?> updateActor(@PathVariable("id") int id, @RequestBody Actor actor) {
        Actor a = actorService.getActor(id);
        if (a == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        actorService.updateActor(a, actor);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/{id}/film")
    public ResponseEntity<?> addFilm(@PathVariable("id") int id, @RequestBody Film filmio) {
        Actor actor = actorService.getActor(id);

        if (actor == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        actorService.addFilms(filmio, actor);
        Film film = filmService.getFilm(id);
        filmService.addActors(film, actor);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}/film")
    public ResponseEntity<?> getFilm(@PathVariable("id") int id) {
        Actor actor = actorService.getActor(id);
        if (actor == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(actor.getFilms(), HttpStatus.OK);
    }
}