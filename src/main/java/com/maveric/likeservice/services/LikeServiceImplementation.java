package com.maveric.likeservice.services;


import com.maveric.likeservice.model.Like;
import com.maveric.likeservice.repo.LikeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class LikeServiceImplementation implements LikeService{

    @Autowired
    LikeRepo likeRepo;

    @Override
    public List<Like> getLikes(String postOrCommentId) {
        return likeRepo.findBypostorcommentId(postOrCommentId);
    }

    @Override
    public Like createLike(String postOrCommentId, Like like) {
        like.setCreatedAt(LocalDate.now());
        return likeRepo.save(like);
    }
    @Override
    public Integer getLikesCount(String postOrCommentId) {
         List<Like> likeList=(likeRepo.findBypostorcommentId(postOrCommentId));
        Integer count=likeList.size();
        return count;
    }

    @Override
    public Like getLikeDetails(String postOrCommentId,String likeId) {
        return likeRepo.findBylikeId(likeId);

    }


}
