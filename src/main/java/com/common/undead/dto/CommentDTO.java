package com.common.undead.dto;

import com.common.undead.model.Article;
import com.common.undead.model.Comment;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CommentDTO {
    private Long id;
    private String comment;
    private String author;
    private Long postNo;
    private Long originComment;

    public CommentDTO(Comment comment) {
        this.id = comment.getId();
        this.comment = comment.getComment();
        this.author = comment.getAuthor();
        this.originComment = getOriginComment();
    }

}
