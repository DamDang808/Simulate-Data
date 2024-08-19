package com.simulate_data.repository;

import com.simulate_data.model.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VideoRepository extends JpaRepository<Video, Integer> {

    @Query(value = "SELECT id FROM media WHERE tag = ?1 and type = 'VOD' LIMIT ?2 OFFSET ?3", nativeQuery = true)
    List<Integer> findByTagLimitOffset(String tag, long limit, long offset);

    @Query(value = "select video_id from recommendation where user_id = ?1 and profile_id = ?2", nativeQuery = true)
    String findRecommendationByUserIDAndProfileID(long userId, long profileId);
}
