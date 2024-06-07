package com.common.undead.Service;

import com.common.undead.dto.*;
import com.common.undead.model.Article;
import com.common.undead.model.Comment;
import com.common.undead.model.Like;
import com.common.undead.repository.ArticleRepository;
import com.common.undead.repository.CommentRepository;
import com.common.undead.repository.LikeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class BlogService {
    private final CommentRepository commentRepository;
    private final ArticleRepository articleRepository;
    private final LikeRepository likeRepository;
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
        List<Comment> comments= commentRepository.findAllByArticleId(articleId);

        List<CommentDTO> commentDTOS= new ArrayList<>();
        //comment-->commentDTO로 service에서 바꿔야 함
        for (Comment comment:comments){
            commentDTOS.add(new CommentDTO(comment));//모델
        }
        return new FindArticleWithCommentResponse(
                article.getId(),
                article.getTitle(),
                article.getContent(),
                article.getAuthor(),
                commentDTOS
        );
    }
    @Transactional//트랙잭션으로 동작하는 어노테이션
    public LikePlusRequest LikeUp(Long articleId,Long request){
        Article article= articleRepository.findById(articleId).orElseThrow(()->new IllegalArgumentException("Not found"));
        Long id = article.getId();
        Like like=likeRepository.findById(id).orElseThrow(()->new IllegalArgumentException("Not found"));
        if(request==0){
            LikePlusRequest likes=new LikePlusRequest(like.getLikeCount()+1, like.getDislikeCount());
            likeRepository.save(like);
            return likes;
        }
        else{
            LikePlusRequest likes=new LikePlusRequest(like.getLikeCount(), like.getDislikeCount()+1);
            likeRepository.save(like);
            return likes;
        }
    }

}
