package com.fakedata.repository;

import com.fakedata.model.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilmRepository extends JpaRepository<Film, Long> {
    @Query(value = "SELECT id FROM film WHERE genre = ?1 LIMIT ?2 OFFSET ?3", nativeQuery = true)
    List<Integer> findByGenreLimitOffset(String genre, long limit, long offset);

    @Query(value = "select film_id from recommendation where user_id = ?1 and profile_id = ?2", nativeQuery = true)
    String findRecommendationByUserIDAndProfileID(long userId, long profileId);
}
