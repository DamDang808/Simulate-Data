package com.fakedata.controller;

import com.fakedata.model.Film;
import com.fakedata.service.FilmService;
import com.fakedata.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class Controller {
    @Autowired
    private Environment env;

    @Autowired
    private FilmService filmService;

    @Autowired
    private VideoService videoService;

    @RequestMapping("/")
    public String home() {
        // This is useful for debugging
        // When having multiple instance of image service running at different ports.
        // We load balance among them, and display which instance received the request.
        return "Hello from Film Service running at port: " + env.getProperty("local.server.port");
    }

    @GetMapping("/recommendation/film/{userId}")
    public List<Integer> getRecommendationFilms(@PathVariable final int userId, @RequestParam final int profileId, @RequestParam final int limit, @RequestParam final int offset) {
        return filmService.getRecommendationFilms(userId, profileId, limit, offset);
    }

    @GetMapping("/recommendation/video/{userId}")
    public List<Integer> getRecommendationVideos(@PathVariable final int userId, @RequestParam final int profileId, @RequestParam final int limit, @RequestParam final int offset) {
        return videoService.getRecommendationVideos(userId, profileId, limit, offset);
    }

    @GetMapping("/related/film/{filmId}")
    public List<Integer> getRelatedFilms(@PathVariable final long filmId, @RequestParam final long limit, @RequestParam final long offset) {
        return filmService.getRelatedFilms(filmId, limit, offset);
    }

    @GetMapping("/related/video/{videoId}")
    public List<Integer> getRelatedVideos(@PathVariable final long videoId, @RequestParam final long limit, @RequestParam final long offset) {
        return videoService.getRelatedVideos(videoId, limit, offset);
    }
}
