package cl.duocuc.userservice.controller;

import cl.duocuc.userservice.controller.response.MessageResponse;
import cl.duocuc.userservice.model.User;
import cl.duocuc.userservice.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.ok(UserService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable String id) {
        User user = userService.findById(id);
        if (user != null) {
            return ResponseEntity.ok(user);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<MessageResponse> createUser(@RequestBody User request) {
        boolean created = userService.addUser(request);
        if (created) {
            return ResponseEntity.status(HttpStatus.CREATED).body(new MessageResponse("Usuario creado"));
        }
        return ResponseEntity.status(HttpStatus.CONFLICT).body(new MessageResponse("Error: usuario ya existe"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MessageResponse> deleteUser(@PathVariable String id) {
        boolean deleted = userService.removeUser(id);
        if (deleted) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(new MessageResponse("Usuario eliminado"));
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<MessageResponse> replaceUser(@PathVariable String id, @RequestBody User request) {
        boolean updated = userService.updateUser(id, request);
        if (updated) {
            return ResponseEntity.ok(new MessageResponse("Usuario actualizado"));
        }
        return ResponseEntity.notFound().build();
    }

    @PatchMapping("/{id}/desactivate")
    public ResponseEntity<MessageResponse> desactivateUser(@PathVariable String id) {
        boolean deactivated = userService.desactivateUser(id);
        if (deactivated) {
            return ResponseEntity.ok(new MessageResponse("Usuario desactivado"));
        }
        return ResponseEntity.notFound().build();
    }
}

