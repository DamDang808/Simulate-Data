package com.simulate_data.repository;

import com.simulate_data.model.Media;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MediaRepository extends JpaRepository<Media, Integer> {
    @Query(value = "SELECT id FROM media WHERE tag = ?1 and type = ?2 LIMIT ?3 OFFSET ?4", nativeQuery = true)
    List<Integer> findByTagLimitOffset(String tag, String type, long limit, long offset);

    @Query(value = "select film_id from recommendation where user_id = ?1 and profile_id = ?2", nativeQuery = true)
    String findFilmRecommendationByUserIDAndProfileID(long userId, long profileId);

    @Query(value = "select video_id from recommendation where user_id = ?1 and profile_id = ?2", nativeQuery = true)
    String findVideoRecommendationByUserIDAndProfileID(long userId, long profileId);
}
