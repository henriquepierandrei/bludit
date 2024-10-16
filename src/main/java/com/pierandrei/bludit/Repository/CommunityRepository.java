package com.pierandrei.bludit.Repository;

import com.pierandrei.bludit.Model.Community;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommunityRepository extends JpaRepository<Community, Long> {
}
