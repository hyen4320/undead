package com.common.undead.dto;

import com.common.undead.model.Article;
import com.common.undead.model.User;
import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class LikePlusRequest {

    private Article article;
    private User user;
    private boolean Likestatus;

}
