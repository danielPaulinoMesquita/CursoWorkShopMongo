package com.daniel.workshopmongodb.dto;

import com.daniel.workshopmongodb.domain.User;

import java.io.Serializable;
import java.util.Objects;

public class AuthorDTO implements Serializable {

    private String id;
    private String name;

    public AuthorDTO(){

    }

    public AuthorDTO(User obj){
        id=obj.getId();
        name=obj.getName();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuthorDTO authorDTO = (AuthorDTO) o;
        return Objects.equals(id, authorDTO.id) &&
                Objects.equals(name, authorDTO.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
