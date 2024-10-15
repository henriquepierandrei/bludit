package com.pierandrei.bludit.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne
    private Posts posts;

    private LocalDateTime commentedAt;

    private String content;

    private int likes;

    private int dislikes;

    @ManyToOne
    private User owner;

    private boolean isVisible;
}
