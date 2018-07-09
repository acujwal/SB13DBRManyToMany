package com.example.lesson13;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashSet;
import java.util.Set;

@Controller
public class HomeController {

    @Autowired
    ActorRepository actorRepository;

    @RequestMapping("/")
    public String index(Model model) {

        //First let's create an actor
        Actor actor = new Actor();
        actor.setName("Sandra Bullock");
        actor.setRealname("Sandra Mae Bullowiski");

        //** creat movie**//
        Movie movie = new Movie();
        movie.setTitle("Star War");
        movie.setYear(2017);
        movie.setDescription("All about Stars...");

        //** add movies to empty list ****//
        Set<Movie> movies = new HashSet<Movie>();
        movies.add(movie);

        //***add the list of movies to the actor movie list**//
        actor.setMovies(movies);

        //***save the actor to database ***//
        actorRepository.save(actor);


        //** Grab all the directors from DB & send them to template ****//
        model.addAttribute("actors", actorRepository.findAll());
        return "index";

    }
    }
