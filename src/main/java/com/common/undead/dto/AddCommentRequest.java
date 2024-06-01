package com.common.undead.dto;

import com.common.undead.model.Article;
import com.common.undead.model.Comment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class AddCommentRequest {
    private String author;

    private String comment;

    private Article article;

    private Long originComment;

    private LocalDateTime createdAt=LocalDateTime.now();

    private LocalDateTime updatedAt=LocalDateTime.now();

    public Comment toComment(){
        return Comment.builder()
                .author(author)
                .comment(comment)
                .article(article)
                .originComment(originComment)
                .createdAt(createdAt)
                .updatedAt(updatedAt)
                .build();
    }


}
