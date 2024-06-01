package com.common.undead.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String author;//나중에 User로 바꿀 것임

    private String comment;
    @ManyToOne
    @JoinColumn(name = "article_id")
    private Article article;//

    private Long originComment;
    @JsonFormat(pattern = "yyyy.MM.dd.HH:mm",timezone = "Asia/Seoul")
    @Builder.Default
    private LocalDateTime createdAt=LocalDateTime.now();

    @JsonFormat(pattern = "yyyy.MM.dd.HH:mm",timezone = "Asia/Seoul")
    @Builder.Default
    private LocalDateTime updatedAt=LocalDateTime.now();
}
