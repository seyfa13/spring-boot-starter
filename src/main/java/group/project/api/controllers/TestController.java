package group.project.api.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("test")
public class TestController {

    @GetMapping("/starter")
    public ResponseEntity<Map<String, Object>> testStarter() {
        Map result = new HashMap();

        result.put("message", "App Starter is working");

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
