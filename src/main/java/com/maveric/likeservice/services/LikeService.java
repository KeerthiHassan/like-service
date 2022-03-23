package com.maveric.likeservice.services;

import com.maveric.likeservice.model.Like;

import java.util.List;

public interface LikeService {
    List<Like> getLikes(String postOrCommentId);

    Integer getLikesCount(String postOrCommentId);
    Like getLikeDetails(String postOrCommentId,String likeId);

}
