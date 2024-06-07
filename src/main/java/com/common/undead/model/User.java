package com.common.undead.model;

import jakarta.persistence.*;
import lombok.*;
import com.common.undead.model.Article;
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private String session;
//    @ManyToOne
//    @JoinColumn(name = "article_id")
//    private Article article;


}
