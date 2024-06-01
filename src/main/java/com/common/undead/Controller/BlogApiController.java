package com.common.undead.Controller;

import com.common.undead.Service.BlogService;
import com.common.undead.dto.*;
import com.common.undead.model.Article;
import com.common.undead.model.Comment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class BlogApiController {
    private final BlogService blogService;

    public BlogApiController(BlogService blogService) {
        this.blogService = blogService;
    }

    @PostMapping("/api/posting")
    public ResponseEntity<Article> addArticle(@RequestBody AddArticleRequest request) {
        Article addArticle = blogService.saveArticle(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(addArticle);
    }
    @PostMapping("/api/comment")
    public ResponseEntity<Comment> addComment(@RequestBody AddCommentRequest request) {
        Comment addComment = blogService.saveComment(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(addComment);
    }
    @GetMapping("/api/find")
    public ResponseEntity<List<FindArticleResponse>> findArticle() {
        List<FindArticleResponse> article = blogService.findAllArticle()
                .stream()
                .map(FindArticleResponse::new)
                .toList();
        return ResponseEntity.status(HttpStatus.CREATED).body(article);
    }
    @GetMapping("/api/find/{id}")
    public ResponseEntity<FindArticleWithCommentResponse> findArticleWithComments(@PathVariable Long id) {
        FindArticleWithCommentResponse response= blogService.getArticleWithComments(id);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
