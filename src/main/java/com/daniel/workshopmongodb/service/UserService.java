package com.daniel.workshopmongodb.service;

import com.daniel.workshopmongodb.domain.User;
import com.daniel.workshopmongodb.dto.UserDTO;
import com.daniel.workshopmongodb.repository.UserRepository;
import com.daniel.workshopmongodb.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService  {

    @Autowired
    private UserRepository repo;

    public List<User> findAll(){
        return repo.findAll();
    }

    public User findById(String id){
        Optional<User> user= repo.findById(id);
        return user.orElseThrow(() -> new ObjectNotFoundException("Usuário não encontrado"));
    }

    public User insert(UserDTO obj){
        return repo.insert(userFromDTO(obj));
    }

    public void delete(String id){
        findById(id);
        repo.deleteById(id);
    }

    public User update(UserDTO obj){
        User newObj= findById(obj.getId());
        updateData(newObj, userFromDTO(obj));
        return repo.save(newObj);
    }

    private void updateData(User newObj, User obj) {
        newObj.setName(obj.getName());
        newObj.setEmail(obj.getEmail());
    }
    private User userFromDTO(UserDTO obj){
        return new User(obj.getId(),obj.getName(), obj.getEmail());
    }
}
