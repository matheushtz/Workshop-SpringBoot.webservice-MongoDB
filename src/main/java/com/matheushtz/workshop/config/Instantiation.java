package com.matheushtz.workshop.config;

//java
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.Date;

//spring
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

//project
import com.matheushtz.workshop.repository.UserRepository;
import com.matheushtz.workshop.domain.User;
import com.matheushtz.workshop.repository.PostRepository;
import com.matheushtz.workshop.domain.Post;

@Configuration
public class Instantiation implements CommandLineRunner{
    
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {
        userRepository.deleteAll();

        User u1 = new User(null, "Marcela", "marcela@gmail.com");
        User u2 = new User(null, "Tatiana", "tatiana@gmail.com");
        User u3 = new User(null, "Claudio", "claudio@gmail.com");

        userRepository.saveAll(Arrays.asList(u1, u2, u3));

        postRepository.deleteAll();

        Date now = Date.from(ZonedDateTime.now(ZoneId.of("America/Sao_Paulo")).toInstant());
        Post p1 = new Post(null, now, "Congresso de Esparta", "blah blah 1", u1);
        Post p2 = new Post(null, now, "Suco em promoção", "blah blah 2", u2);
        Post p3 = new Post(null, now, "Evento especial", "blah blah 3", u3);

        postRepository.saveAll(Arrays.asList(p1, p2, p3));
    }

}
