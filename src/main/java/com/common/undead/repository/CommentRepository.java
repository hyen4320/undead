package com.common.undead.repository;

import com.common.undead.dto.CommentDTO;
import com.common.undead.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findAllByArticleId(Long articleId);//All이어야 다 땡겨옴 없으면 하나만
    //Jpa<Comment>랑 List<Comment>랑 타입이 같아야 함
}
