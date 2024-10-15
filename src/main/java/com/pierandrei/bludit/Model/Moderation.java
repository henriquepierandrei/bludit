package com.pierandrei.bludit.Model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Data
public class Moderation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    // Relacionamento com a Community
    @ManyToOne
    @JoinColumn(name = "community_id", nullable = false)
    private Community community;

    @OneToMany(mappedBy = "moderation", cascade = CascadeType.ALL)
    private List<CommentModeration> moderationCommentList;

    @OneToMany(mappedBy = "moderation", cascade = CascadeType.ALL)
    private List<PostModeration> moderationPostList;

    @OneToMany(mappedBy = "moderation", cascade = CascadeType.ALL)
    private List<AnswersModeration> moderationAnswerList;

    private LocalDateTime moderatedAt;
}

// Sub-entidade CommentModeration
@Entity
@Data
class CommentModeration {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "comment_id")
    private Comment comment;

    @ManyToOne
    @JoinColumn(name = "moderation_id")
    private Moderation moderation;

    @ManyToOne
    private User moderator;

    private String reason;

    private LocalDateTime moderatedAt;
}


@Entity
@Data
class PostModeration {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Posts post;

    @ManyToOne
    @JoinColumn(name = "moderation_id")
    private Moderation moderation;

    @ManyToOne
    private User moderator;

    private String reason;

    private LocalDateTime moderatedAt;
}


@Entity
@Data
class AnswersModeration {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "answer_id")
    private Answer answer;

    @ManyToOne
    @JoinColumn(name = "moderation_id")
    private Moderation moderation;

    @ManyToOne
    private User moderator;

    private String reason;

    private LocalDateTime moderatedAt;
}
