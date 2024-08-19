package com.simulate_data.service;

import com.simulate_data.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VideoService {

    @Autowired
    private VideoRepository videoRepository;

    public List<Integer> getRecommendationVideos(int user_id, int profile_id, int limit, int offset) {
        String string = videoRepository.findRecommendationByUserIDAndProfileID(user_id, profile_id);
        String[] ids = string.split(", ");
        int end = Math.min(offset + limit, ids.length);
        return Arrays.asList(ids).subList(offset, end - 1).stream()
                .map(Integer::valueOf)
                .collect(Collectors.toList());
    }

    public List<Integer> getRelatedVideos(int videoId, int limit, int offset) {
        String category = videoRepository.findById(videoId).get().getCategory();
        return videoRepository.findByTagLimitOffset(category, limit, offset);
    }
}
