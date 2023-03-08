package it.infobasic.usermanager.controllers;

import it.infobasic.usermanager.model.User;
import it.infobasic.usermanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/all")
    public ResponseEntity<List<User>> getAll(){
        List<User> userList = userService.getAll();
        return new ResponseEntity<>(userList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getById(@PathVariable(required = true) long id){
        Optional<User> user = userService.getById(id);
        if (user.get() != null){
            return new ResponseEntity<>(user.get(), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<User> addUser(@RequestBody User newUser){
        User user = userService.save(newUser);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PutMapping("/edit")
    public ResponseEntity<User> editUser(@RequestBody User newUser){
        Optional<User> user = userService.getById(newUser.getId());
        if (user.get() == null){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        Optional<User> modifiedUser = userService.updateById(newUser.getId(), newUser);
        return new ResponseEntity<>(modifiedUser.get(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable(required = true) long id){
        userService.deleteById(id);
        return;
    }
}
