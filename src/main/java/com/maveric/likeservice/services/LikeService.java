package com.maveric.likeservice.services;

import com.maveric.likeservice.dto.LikeResponse;
import com.maveric.likeservice.dto.Likedto;
import com.maveric.likeservice.model.Like;

import java.util.List;

public interface LikeService {

    List<LikeResponse> getLikes(String postOrCommentId);
    LikeResponse createLike(String postOrCommentId, Likedto likedto);
    Integer getLikesCount(String postOrCommentId);
    LikeResponse getLikeDetails(String postOrCommentId,String likeId);
    List<Like> getLikes(String postOrCommentId);
    Like createLike(String postOrCommentId,Like like);
    Integer getLikesCount(String postOrCommentId);
    Like getLikeDetails(String postOrCommentId,String likeId);
    String removeLike(String postOrCommentId,String likeId);
}
