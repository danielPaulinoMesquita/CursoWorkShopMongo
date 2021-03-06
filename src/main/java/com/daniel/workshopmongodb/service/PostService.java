package com.daniel.workshopmongodb.service;

import com.daniel.workshopmongodb.domain.Post;
import com.daniel.workshopmongodb.domain.User;
import com.daniel.workshopmongodb.dto.UserDTO;
import com.daniel.workshopmongodb.repository.PostRepository;
import com.daniel.workshopmongodb.repository.UserRepository;
import com.daniel.workshopmongodb.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository repo;

    public Post findById(String id){
        Optional<Post> post= repo.findById(id);
        return post.orElseThrow(() -> new ObjectNotFoundException("Posts não encontrado"));
    }

    public List<Post> findByTitle(String text){
        return repo.searchTitle(text);
    }

    public List<Post> fullSearch(String text, Date minDate, Date maxDate){
        maxDate= new Date(maxDate.getTime()+24*60*60*1000);
        return repo.fullSearch(text,minDate,maxDate);
    }

}
