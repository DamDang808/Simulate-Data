package com.simulate_data.controller;

import com.simulate_data.service.FilmService;
import com.simulate_data.service.VideoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/")
public class Controller {
    @Autowired
    private FilmService filmService;

    @Autowired
    private VideoService videoService;

    @GetMapping("/recommendation/film/{userId}")
    public List<Integer> getRecommendationFilms(@PathVariable final int userId, @RequestParam final int profileId, @RequestParam final int limit, @RequestParam final int offset) {
        return filmService.getRecommendationFilms(userId, profileId, limit, offset);
    }

    @GetMapping("/recommendation/video/{userId}")
    public List<Integer> getRecommendationVideos(@PathVariable final int userId, @RequestParam final int profileId, @RequestParam final int limit, @RequestParam final int offset) {
        return videoService.getRecommendationVideos(userId, profileId, limit, offset);
    }

    @GetMapping("/related/film/{filmId}")
    public List<Integer> getRelatedFilms(@PathVariable final int filmId, @RequestParam final int limit, @RequestParam final int offset) {
        return filmService.getRelatedFilms(filmId, limit, offset);
    }

    @GetMapping("/related/video/{videoId}")
    public List<Integer> getRelatedVideos(@PathVariable final int videoId, @RequestParam final int limit, @RequestParam final int offset) {
        return videoService.getRelatedVideos(videoId, limit, offset);
    }
}
