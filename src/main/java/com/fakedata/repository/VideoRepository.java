package com.fakedata.repository;

import com.fakedata.model.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VideoRepository extends JpaRepository<Video, Long> {

    @Query(value = "SELECT id FROM video WHERE category = ?1 LIMIT ?2 OFFSET ?3", nativeQuery = true)
    List<Integer> findByCategoryLimitOffset(String category, long limit, long offset);

    @Query(value = "select video_id from recommendation where user_id = ?1 and profile_id = ?2", nativeQuery = true)
    String findRecommendationByUserIDAndProfileID(long userId, long profileId);
}
