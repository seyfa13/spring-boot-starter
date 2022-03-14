package group.project.api.controllers;

import group.project.api.entities.AuthRequest;
import group.project.api.entities.User;
import group.project.api.managers.UserManager;
import group.project.api.services.jwt.JwtManager;
import group.project.api.utils.response.BindingResultWrapper;
import group.project.api.utils.response.ResponseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    JwtManager jwtManager;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserManager userManager;

    @PostMapping("/in")
    public ResponseEntity<Map<String, Object>> authenticate(@Valid @RequestBody AuthRequest authRequest, BindingResult bindingResult) {
        Map result = ResponseObject.map();

        BindingResultWrapper.checkFormErrors(bindingResult);

        // validate user Using AuthenticationManger
        // it uses CustomUserDetailsServvice whic load
        // a user according to username and check password
        UsernamePasswordAuthenticationToken username = new UsernamePasswordAuthenticationToken(authRequest.getEmail(), authRequest.getPassword());
        authenticationManager.authenticate(username);

        // once authentified, create token
        final String token = jwtManager.generateToken(authRequest.getEmail());

        // and fetch bd User
        User user = userManager.find(authRequest.getEmail());

        result.put("authToken", token);
        result.put("user", user);

        return ResponseEntity.ok(result);
    }


}
