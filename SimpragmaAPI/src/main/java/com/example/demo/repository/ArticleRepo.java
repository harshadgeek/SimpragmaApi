package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Article;

public interface ArticleRepo extends JpaRepository<Article, Long> {

}
