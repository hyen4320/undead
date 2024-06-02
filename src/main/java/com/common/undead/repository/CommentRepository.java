package com.common.undead.repository;

import com.common.undead.dto.CommentDTO;
import com.common.undead.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByArticleId(Long articleid);
}
