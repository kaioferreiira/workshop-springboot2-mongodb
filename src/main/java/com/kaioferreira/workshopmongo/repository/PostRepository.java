package com.kaioferreira.workshopmongo.repository;

import com.kaioferreira.workshopmongo.dto.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository <Post, String > {

}
