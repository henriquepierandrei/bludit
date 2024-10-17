package com.pierandrei.bludit.Model.Community;

import com.pierandrei.bludit.Model.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Data
public class Community {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Size(max = 50, message = "Maximum 50 characters!")
    @Column(unique = true, nullable = false)
    private String name;

    @Size(max = 300, message = "Maximum 300 characters!")
    @Column(unique = true, nullable = false)
    private String description;

    @OneToMany
    private List<Posts> posts;

    @OneToOne
    private User owner;

    @OneToMany
    private List<User> moderators;

    private int likes;

    private int dislikes;

    private LocalDateTime createdAt;

    private List<String> categories;

    private boolean isPublic;

    @OneToMany
    private List<User> listMembers;

    @OneToMany
    private List<User> listOfRequests;
}
