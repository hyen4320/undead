package com.common.undead.repository;

import com.common.undead.model.Like;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeRepository extends JpaRepository<Like, Long> {
}
