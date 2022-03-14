package group.project.api.managers;

import group.project.api.entities.User;
import group.project.api.exceptions.ManagerException;
import group.project.api.repositories.UserRepository;
import group.project.api.utils.constants.ExceptionConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserManager implements IManager<Integer, User> {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public User find(Integer id) throws ManagerException {
        return userRepository.findById(id).orElseThrow(() -> new ManagerException(ExceptionConstants.userNotFound()));
    }

    public User find(String email) throws ManagerException {
        return userRepository.findByEmail(email).orElseThrow(() -> new ManagerException(ExceptionConstants.userNotFound()));
    }

    @Override
    public void create(User user) throws ManagerException {
        // TODO : add business rules
        User userToCreate = new User();
        userToCreate.setEmail(user.getEmail());
        userToCreate.setPassword(passwordEncoder.encode(user.getPassword()));
        userToCreate.setCreationDate(LocalDateTime.now());

        userRepository.save(user);
    }

    @Override
    public void update(User object) throws ManagerException {
        // TODO : add business rules

    }

    @Override
    public void delete(Integer id) throws ManagerException {
        // TODO : add business rules
        User user = userRepository.findById(id).orElseThrow(() -> new ManagerException(ExceptionConstants.userNotFound()));
        userRepository.delete(user);
    }
}
