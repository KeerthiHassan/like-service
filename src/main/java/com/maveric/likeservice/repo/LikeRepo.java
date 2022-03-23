package com.maveric.likeservice.repo;

import com.maveric.likeservice.model.Like;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface LikeRepo extends MongoRepository<Like,String> {
    List<Like> findBypostorcommentId(String postOrCommentId);
    Like findBylikeId(String likeId);
}
