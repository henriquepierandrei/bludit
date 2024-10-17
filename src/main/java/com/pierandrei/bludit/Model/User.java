package com.pierandrei.bludit.Model;

import com.pierandrei.bludit.Enum.Roles;
import com.pierandrei.bludit.Model.Community.Community;
import com.pierandrei.bludit.Model.Community.Posts;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Email
    @Column(unique = true, nullable = false)
    private String email;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(unique = true, nullable = false)
    private String phone;

    @Column(nullable = false)
    private LocalDateTime dateBorn;

    @OneToMany(mappedBy = "ownerUser", cascade = CascadeType.ALL)
    private List<Posts> posts;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Community> communities;

    private String biography;

    private String profilePhotoUrl;

    private Roles roles;
}
