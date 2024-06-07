package com.common.undead.dto;

import com.common.undead.model.Article;
import com.common.undead.model.Comment;
import com.common.undead.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class AddCommentRequest {
    private User author;

    private String comment;

    private Article article;

    private Long originComment;

    private LocalDateTime createdAt=LocalDateTime.now();

    private LocalDateTime updatedAt=LocalDateTime.now();

    public Comment toComment(){//DTO를 Entity로 Comment객체를 생성해서 setTitle을 빌더로 씀
        //Setter보다는 Builder가 좋음
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
