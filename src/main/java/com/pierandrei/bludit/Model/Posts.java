package com.pierandrei.bludit.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Data
public class Posts {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Size(max = 100, message = "Maximum 100 characters!")
    private String title;

    @Size(max = 5000, message = "Maximum 5000 characters!")
    private String content;

    private int likes;

    private int dislikes;

    private boolean isApproved;

    private String category;

    private LocalDateTime postedAt;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User ownerUser;

    @OneToMany(mappedBy = "comments", cascade = CascadeType.ALL)
    private List<Comment> comments;

    @ManyToOne
    private Community communityHosted;
}
