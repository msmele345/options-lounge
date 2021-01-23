package com.mitchmele.optionslounge.option.post;

import com.mitchmele.optionslounge.option.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> { }
