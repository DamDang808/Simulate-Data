package com.simulate_data.service;

import com.simulate_data.repository.FilmRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class FilmService {

    @Autowired
    private FilmRepository filmRepository;

    public List<Integer> getRecommendationFilms(int user_id, int profile_id, int limit, int offset) {
        String string = filmRepository.findRecommendationByUserIDAndProfileID(user_id, profile_id);
        log.info(string);
        String[] ids = string.split(",");
        int end = Math.min(offset + limit, ids.length);
        return Arrays.asList(ids).subList(offset, end).stream()
                .map(Integer::valueOf)
                .collect(Collectors.toList());
    }

    public List<Integer> getRelatedFilms(int film_id, int limit, int offset) {
        String genre = filmRepository.findById(film_id).get().getGenre();
        return filmRepository.findByTagLimitOffset(genre, limit, offset);
    }
}
