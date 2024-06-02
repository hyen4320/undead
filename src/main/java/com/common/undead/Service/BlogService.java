package com.common.undead.Service;

import com.common.undead.dto.*;
import com.common.undead.model.Article;
import com.common.undead.model.Comment;
import com.common.undead.repository.ArticleRepository;
import com.common.undead.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class BlogService {
    private final CommentRepository commentRepository;
    private final ArticleRepository articleRepository;

    public Article saveArticle(AddArticleRequest request){
        return articleRepository.save(request.toArticle());//dto에서 만들었떤 toArticle
    }
    public Comment saveComment(AddCommentRequest request){
        return commentRepository.save(request.toComment());
    }

    public List<Article> findAllArticle(){
        return articleRepository.findAll();
    }
    public List<Comment> findAllComment(){
        return commentRepository.findAll();
    }
    public Article findArticleById(FindArticleResponse id){
        return articleRepository.findById(id.getId()).orElse(null);
    }
    @Transactional(readOnly = true)
    public FindArticleWithCommentResponse getArticleWithComments(Long articleId){
        Article article=articleRepository.findById(articleId)
                .orElseThrow(()->new IllegalArgumentException("Not found"));
        List<Comment> comments=commentRepository.findByArticleId(articleId);

        return new FindArticleWithCommentResponse(
                article.getId(),
                article.getTitle(),
                article.getContent(),
                article.getAuthor(),
                comments
        );
    }

}
