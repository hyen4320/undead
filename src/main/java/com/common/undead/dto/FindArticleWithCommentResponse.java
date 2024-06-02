package com.common.undead.dto;

import com.common.undead.model.Article;
import lombok.AllArgsConstructor;
import lombok.Getter;
import com.common.undead.model.Comment;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@AllArgsConstructor
public class FindArticleWithCommentResponse {
    private Long id;
    private String title;
    private String content;
    private String author;
    private List<Comment> comments;
    public FindArticleWithCommentResponse(Article article) {
        this.id = article.getId();
        this.title = article.getTitle();
        this.content = article.getContent();
        this.author = article.getAuthor();
        this.comments = article.getComment();
    }
}
