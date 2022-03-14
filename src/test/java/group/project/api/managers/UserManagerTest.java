package group.project.api.managers;

import group.project.api.entities.User;
import group.project.api.exceptions.ManagerException;
import group.project.api.repositories.UserRepository;
import group.project.api.utils.UserBuilderTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class UserManagerTest {

    @Autowired
    UserManager userManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    int userId;
    String email = "test@api.fr", password = "password";

    @BeforeEach
    public void before() {
        userId = UserBuilderTest.create(userRepository, email, passwordEncoder.encode(password)).getId();
    }

    @AfterEach
    public void after() {
        UserBuilderTest.delete(userId, userRepository);
    }

    @Test
    public void findByEmail() {
        assertNotNull(userManager.find(email));
    }

    @Test
    public void findByEmailNull() {
        assertThrows(ManagerException.class, () -> {
            userManager.find("teszrétt@api.fr");
        });
    }


}
