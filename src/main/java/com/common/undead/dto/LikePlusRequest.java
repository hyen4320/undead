package com.common.undead.dto;

import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
@NoArgsConstructor

@Getter
public class LikePlusRequest {

    private Long article;
    private Long request;
    private Long likeCount;

    private Long dislikeCount;
    public LikePlusRequest(Long like, Long dislike) {
        this.likeCount = like;
        this.dislikeCount = dislike;
    }

}
