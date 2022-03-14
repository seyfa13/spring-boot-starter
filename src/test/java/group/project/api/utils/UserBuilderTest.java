package group.project.api.utils;

import group.project.api.entities.User;
import group.project.api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;

public class UserBuilderTest {

    public static User create(UserRepository userRepository, String email, String password) {
        User user = new User(email, password, LocalDateTime.now());

        userRepository.save(user);
        System.err.println("Created user " + user);
        return user;
    }

    public static void delete(int userId, UserRepository userRepository) {
        User user = userRepository.findById(userId).orElse(null);
        if(user != null) {
            userRepository.delete(userRepository.findById(userId).get());
            System.err.println("Deleted user " + userId);
        } else {
            System.err.println("Deleted user " + userId);
        }
    }

}
