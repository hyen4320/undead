package com.common.undead.model;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@Getter
@Builder
@NoArgsConstructor
public class Like {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @OneToOne(cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(name="article_id")
    private Article article;//외래키를 기본키로 사용
    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;
    private boolean likeStatus;

    public void update(Article article, User user, boolean likeStatus) {
        this.article = article;
        this.user = user;
        this.likeStatus = likeStatus;
    }
}
