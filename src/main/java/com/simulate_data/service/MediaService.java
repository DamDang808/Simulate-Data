package com.simulate_data.service;

import com.simulate_data.repository.MediaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class MediaService {

    @Autowired
    private MediaRepository mediaRepository;

    public List<Integer> getRecommendationMedia(String type, int user_id, int profile_id, int limit, int offset) {
        String string = type.equalsIgnoreCase("Film") ?
                mediaRepository.findFilmRecommendationByUserIDAndProfileID(user_id, profile_id) :
                mediaRepository.findVideoRecommendationByUserIDAndProfileID(user_id, profile_id);
        String[] ids = string.split(",");
        int end = Math.min(offset + limit, ids.length);
        return Arrays.asList(ids).subList(offset, end).stream()
                .map(Integer::valueOf)
                .collect(Collectors.toList());
    }

    public List<Integer> getRelatedMedia(int id, String type, int limit, int offset) {
        String tag = mediaRepository.findById(id).get().getTag();
        return mediaRepository.findByTagLimitOffset(tag, type, limit, offset);
    }
}
