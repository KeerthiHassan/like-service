package com.maveric.likeservice.services;


import com.maveric.likeservice.UserFeign.UserFeign;
import com.maveric.likeservice.dto.LikeResponse;
import com.maveric.likeservice.dto.Likedto;
import com.maveric.likeservice.dto.UserResponse;
import com.maveric.likeservice.exception.LikeDetailsNotFound;
import com.maveric.likeservice.model.Like;
import com.maveric.likeservice.repo.LikeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class LikeServiceImplementation implements LikeService{

    @Autowired
    LikeRepo likeRepo;
    @Autowired
   UserFeign userFeign;

    @Override
    public List<LikeResponse> getLikes(String postOrCommentId) {
        List<Like> likeList=likeRepo.findBypostorcommentId(postOrCommentId);
        List<LikeResponse> likeResponses=new ArrayList<>();
        for(Like like:likeList)
        {
            likeResponses.add(new LikeResponse(like.getLikeId(),like.getPostorcommentId(),
                    userFeign.getUsersById(like.getLikedBy()).getBody(),like.getCreatedAt()));
        }
        return likeResponses;
    }

    @Override
    public LikeResponse createLike(String postOrCommentId, Likedto likedto) {
        Like like=new Like();
        like.setPostorcommentId(postOrCommentId);
        like.setCreatedAt(LocalDate.now());
        like.setLikedBy(likedto.getLikedBy());
        Like likes=likeRepo.save(like);
        UserResponse userResponse=userFeign.getUsersById(likedto.getLikedBy()).getBody();
        return new LikeResponse(like.getLikeId(),like.getPostorcommentId(),userResponse,like.getCreatedAt());
    }

    @Override
    public Integer getLikesCount(String postOrCommentId) {
         List<Like> likeList=(likeRepo.findBypostorcommentId(postOrCommentId));
        Integer count=likeList.size();
        return count;
    }

    @Override
    public LikeResponse getLikeDetails(String postOrCommentId,String likeId) {
        Like like=likeRepo.findBylikeId(likeId);
        if(like==null)
            throw new LikeDetailsNotFound("Like Details Does't exist with id :"+likeId);

        return new LikeResponse(like.getLikeId(),like.getPostorcommentId(),userFeign.getUsersById(like.getLikedBy()).getBody(),like.getCreatedAt());
    }

    @Override
    public String removeLike(String postOrCommentId,String likeId) {
         likeRepo.deleteById(likeId);
        return "Like has been successfully removed";
    }
}
