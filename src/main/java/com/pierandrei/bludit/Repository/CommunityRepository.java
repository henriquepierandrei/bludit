package com.pierandrei.bludit.Repository;

import com.pierandrei.bludit.Model.Community.Community;
import com.pierandrei.bludit.Model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CommunityRepository extends JpaRepository<Community, UUID> {
    Page<User> findListMembersByCommunity(Community community, Pageable pageable);
}
