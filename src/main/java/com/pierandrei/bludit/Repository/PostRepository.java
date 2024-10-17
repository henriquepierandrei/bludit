package com.pierandrei.bludit.Repository;

import com.pierandrei.bludit.Model.Community.Posts;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PostRepository extends JpaRepository<Posts, UUID>{
}
