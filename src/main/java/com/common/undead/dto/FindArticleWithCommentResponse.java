package com.common.undead.dto;

import com.common.undead.model.Article;
import com.common.undead.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import com.common.undead.model.Comment;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@AllArgsConstructor//20행 코드 자동으로 써줌 생성자 자동으로 만들어줌
public class FindArticleWithCommentResponse {
    private Long id;
    private String title;
    private String content;
    private User author;
    private List<CommentDTO> comments;
//    public FindArticleWithCommentResponse(Article article) {
//        this.id = article.getId();
//        this.title = article.getTitle();
//        this.content = article.getContent();
//        this.author = article.getAuthor();
//        this.comments = article.getComment().stream().map(CommentDTO::new).collect(Collectors.toList());
//    }
}
