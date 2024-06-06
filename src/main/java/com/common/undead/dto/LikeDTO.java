package com.common.undead.dto;

import com.common.undead.model.Article;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class LikeDTO {
    private Long article;

    private Long like;

    private Long dislike;

//    public LikeDTO(Article article, Long like, Long dislike) {
//        this.article = article.getId();
//        this.like = like;
//        this.dislike = dislike;
//    }

}
