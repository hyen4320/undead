package com.common.undead.dto;

import com.common.undead.model.Article;
import com.common.undead.model.Comment;
import com.common.undead.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
//게시글이랑 댓글 전부 찾기
public class FindArticleResponse {
    private Long id;
    private User author;
    private String title;
    private String content;
    private List<Comment> comment;
    public FindArticleResponse(Article article) {
        this.id = article.getId();
        this.author = article.getAuthor();
        this.title = article.getTitle();
        this.content = article.getContent();//model에서 get가져오기
    }
}
