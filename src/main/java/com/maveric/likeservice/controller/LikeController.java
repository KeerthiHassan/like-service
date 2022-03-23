package com.maveric.likeservice.controller;

import com.maveric.likeservice.model.Like;
import com.maveric.likeservice.services.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class LikeController {

    @Autowired
    LikeService likeService;

    @GetMapping("/postOrCommentId/{postOrCommentId}/likes")
    public ResponseEntity<List<Like>> getLikes(@PathVariable("postOrCommentId") String postOrCommentId)
    {
        return new ResponseEntity<List<Like>>(likeService.getLikes(postOrCommentId), HttpStatus.OK);
    }


    @GetMapping("/postOrCommentId/{postOrCommentId}/likes/count")
    public ResponseEntity<Integer> getLikesCount(@PathVariable("postOrCommentId") String postOrCommentId)
    {

        return new ResponseEntity<Integer>(likeService.getLikesCount(postOrCommentId), HttpStatus.OK);
    }

    @GetMapping("/postOrCommentId/{postOrCommentId}/likes/{likeId}")
    public ResponseEntity<Like> getLikeDetails(@PathVariable("postOrCommentId") String postOrCommentId,@PathVariable("likeId") String likeId)
    {
        return new ResponseEntity<Like>(likeService.getLikeDetails(postOrCommentId,likeId), HttpStatus.OK);
    }

    @PostMapping("/postOrCommentId/{postOrCommentId}/likes")
    public ResponseEntity<Like> createLike(@PathVariable("postOrCommentId") String postOrCommentId,@RequestBody Like like)
    {
        return new ResponseEntity<Like>(likeService.createLike(postOrCommentId,like), HttpStatus.OK);
    }

    @DeleteMapping("/postOrCommentId/{postOrCommentId}/likes/{likeId}")
    public ResponseEntity<String> removeLike(@PathVariable("postOrCommentId") String postOrCommentId,@PathVariable("likeId") String likeId)
    {
        return new ResponseEntity<String>(likeService.removeLike(postOrCommentId,likeId), HttpStatus.OK);
    }
    }


