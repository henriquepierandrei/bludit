package com.pierandrei.bludit.Model.Community;

import Comment;
import com.pierandrei.bludit.Model.User;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;


    @ManyToOne
    private Comment comment;

    private LocalDateTime answeredAt;

    private String content;

    private int likes;

    private int dislikes;


    @ManyToOne
    private User owner;
}
