package com.pjwstk.springboot.controller;

import com.pjwstk.springboot.domain.Actor;
import com.pjwstk.springboot.domain.Film;
import com.pjwstk.springboot.domain.FilmComment;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.pjwstk.springboot.service.FilmService;

@RestController
@RequestMapping("/filmweb")
public class FilmController {

    @Autowired
    FilmService filmService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> getAll() {
        return new ResponseEntity(filmService.getAll(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> addFilm(@RequestBody Film film) {
        return new ResponseEntity(filmService.addFilm(film), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity<?> getFilm(@PathVariable("id") int id) {
        Film film = filmService.getFilm(id);
        if (film == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        filmService.getFilm(id);
        return new ResponseEntity(filmService.getFilm(id), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public ResponseEntity<?> deleteFilm(@PathVariable("id") int id) {
        Film film = filmService.getFilm(id);
        if (film == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        filmService.deleteFilm(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
    public ResponseEntity<?> updateFilm(@PathVariable("id") int id, @RequestBody Film film) {
        Film f = filmService.getFilm(id);
        if (f == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        filmService.updateFilm(f, film);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/{id}/comments")
    public ResponseEntity<?> addComment(@PathVariable("id") int id, @RequestBody FilmComment comment) {
        Film film = filmService.getFilm(id);
        if (film == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        filmService.addFilmComment(comment, film);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}/comments")
    public ResponseEntity<?> getComments(@PathVariable("id") int id) {
        Film film = filmService.getFilm(id);
        if (film == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(film.getComments(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{idM}/comments/{idC}")
    public ResponseEntity<?> deleteComments(@PathVariable("idM") int idM,@PathVariable("idC") int idC) {
        Film film = filmService.getFilm(idM);
        if (film == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        filmService.deleteComments(idC,film);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/{id}/rating")
    public ResponseEntity<?> addRating(@PathVariable("id") int id, @RequestBody String json) throws JSONException {
        Film film = filmService.getFilm(id);
        if (film == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        JSONObject jsonObject = new JSONObject(json);
        filmService.updateRating(film, jsonObject.getInt("rating"));

        return new ResponseEntity(film, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/{id}/actors")
    public ResponseEntity<?> addActors(@PathVariable("id") int id, @RequestBody Actor actor) {
        Film film = filmService.getFilm(id);
        if (film == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        filmService.addActors(actor, film);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}/actors")
    public ResponseEntity<?> getActors(@PathVariable("id") int id) {
        Film film = filmService.getFilm(id);
        if (film == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(film.getActors(), HttpStatus.OK);
    }

}