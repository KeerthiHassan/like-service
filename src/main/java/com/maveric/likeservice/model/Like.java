package com.maveric.likeservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@Document(collection = "like")
@AllArgsConstructor
@NoArgsConstructor
public class Like {
    @Id
    private String likeId;
    private String postorcommentId;
    private String likedBy;
    private LocalDate createdAt;
}
