package com.matheushtz.workshop.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.matheushtz.workshop.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {


}
