package group.project.api.security;

import group.project.api.entities.User;

import group.project.api.exceptions.AuthenticationException;
import group.project.api.exceptions.ManagerException;
import group.project.api.repositories.UserRepository;
import group.project.api.utils.constants.ExceptionConstants;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        // find user by email
        group.project.api.entities.User businessUser = userRepository.findByEmail(email).orElseThrow(()  -> new AuthenticationException(ExceptionConstants.userNotFound()));

        // load user roles for spring security
        List<GrantedAuthority> roles = new ArrayList<>();
        if(businessUser != null) {
            businessUser.getRoles().forEach(role -> {
                roles.add(new SimpleGrantedAuthority(role.getName()));
            });
        }

        return new org.springframework.security.core.userdetails.User(
                businessUser.getEmail(),
                businessUser.getPassword(),
                roles
        );

    }

}
