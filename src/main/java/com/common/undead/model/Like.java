package com.common.undead.model;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Getter
@Builder
@NoArgsConstructor
public class Like {
    @OneToOne(cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(name="article_id")
    private Article article;

    private Long like;

    private Long dislike;
}
