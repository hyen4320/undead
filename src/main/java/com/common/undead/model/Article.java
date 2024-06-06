package com.common.undead.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Builder
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String content;

    private String author;
    @OneToMany(mappedBy = "article")
    private List<Comment> comment;
    @JsonFormat(pattern = "yyyy.MM.dd.HH:mm",timezone = "Asia/Seoul")
    @Builder.Default
    private LocalDateTime createdAt=LocalDateTime.now();

    @JsonFormat(pattern = "yyyy.Mm.dd.HH:mm",timezone = "Asia/Seoul")
    @Builder.Default//특정 필드값 초기화
    private LocalDateTime updatedAt=LocalDateTime.now();
}
