package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Article;
import com.example.demo.repository.ArticleRepo;
import com.example.demo.service.ArticleService;

@RestController
public class ArticleRepository {

	@Autowired
	private ArticleService articleService;
	
	@GetMapping("/articles")
	Page<Article> employeesPageable(Pageable pageable) {
		return articleService.getAllArticle(pageable);

	}
	
	
	@PostMapping("/articles")
	public ResponseEntity<String> addArticle(@RequestBody Article article){
		articleService.saveArticle(article);
		return  ResponseEntity.status(HttpStatus.CREATED).body("new article created");
	}
	
	
	
}
