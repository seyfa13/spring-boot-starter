package group.project.api.repositories;

import group.project.api.entities.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    int userId;

    @BeforeEach
    public void before() {
        User user = new User("Test", "Test", LocalDateTime.now());
        userRepository.save(user);
        userId = user.getId();
        System.err.println("userId " + userId);
    }

    @AfterEach
    public void after() {
        User user = userRepository.findById(userId).orElse(null);
        if(user != null) {
            userRepository.delete(userRepository.findById(userId).get());
        }
    }

    @Test
    public void ok() {
        assertNotNull(userRepository);
    }


}
