package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.model.Article;
import com.example.demo.repository.ArticleRepo;

@Service
public class ArticleService {

	@Autowired
	private ArticleRepo articleRepo;
	
	
	public void saveArticle(Article article) {
		articleRepo.save(article);
	}
	
	public Page<Article> getAllArticle(Pageable pageable){
		return articleRepo.findAll(pageable);
	}
}
