package com.common.undead.dto;


import com.common.undead.model.Article;
import com.common.undead.model.Comment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class AddArticleRequest {
    private String title;

    private String content;

    private String author;

    private List<Comment> comment;

    private LocalDateTime createdAt=LocalDateTime.now();

    private LocalDateTime updatedAt=LocalDateTime.now();

    public Article toArticle() {
        return Article.builder()
                .title(title)//model의 컬럼명(dto에서 선언한 변수)
                .content(content)
                .author(author)
                .comment(comment)
                .createdAt(createdAt)
                .updatedAt(updatedAt)
                .build();
    }
}
