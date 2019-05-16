package com.daniel.workshopmongodb.config;

import com.daniel.workshopmongodb.domain.Post;
import com.daniel.workshopmongodb.domain.User;
import com.daniel.workshopmongodb.repository.PostRepository;
import com.daniel.workshopmongodb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {
        userRepository.deleteAll();

        SimpleDateFormat sd= new SimpleDateFormat("dd/MM/yyyy");
        sd.setTimeZone(TimeZone.getTimeZone("GMT"));

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        Post post1= new Post(null, sd.parse("21/08/2018"), "Partiu Viagem",
                "Vou viajar para São Paulo abraços!",maria);

        Post post2=new Post(null, sd.parse("23/08/2018"), "Bom dia",
                "Acordei feliz hoje!",maria);


        userRepository.saveAll(Arrays.asList(maria,alex,bob));
        postRepository.saveAll(Arrays.asList(post1,post2));
    }
}
