package group.project.api.controllers;

import group.project.api.entities.User;
import group.project.api.managers.UserManager;
import group.project.api.utils.response.BindingResultWrapper;
import group.project.api.utils.response.ResponseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("account")
public class AccountController {

    @Autowired
    UserManager userManager;

    @PostMapping("/create")
    public ResponseEntity<Map<String, Object>> createAccuont(@Valid @RequestBody User user, BindingResult bindingResult) {
        Map result = ResponseObject.map();
        BindingResultWrapper.checkFormErrors(bindingResult);

        userManager.create(user);

        result.put("message", "Account created");
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/delete/{userId}")
    public ResponseEntity<Map<String, Object>> testStarter(@PathVariable int userId) {
        Map result = new HashMap();

        userManager.delete(userId);

        result.put("message", "App Starter is working");
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
