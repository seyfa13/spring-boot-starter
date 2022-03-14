package group.project.api.controllers.admins;

import group.project.api.utils.response.ResponseObject;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RestController
@Secured({"ROLE_USER_ADMIN"})
@RequestMapping("admin/users")
public class UserAdminController {

    // TODO: A enlever ci nimou gueun gawé
    @GetMapping("")
    public ResponseEntity<Map<String, Object>> findAll() {
        Map result = ResponseObject.map();

        return ResponseEntity.ok(result);
    }

}
