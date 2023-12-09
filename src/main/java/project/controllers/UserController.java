package project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import project.models.UserModel;
import project.repository.UserRepository;

import java.util.List;

@RestController
@RequestMapping
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<UserModel> getAllUsers() {
        return userRepository.findAll();
    }
@GetMapping("/{id}")
    public UserModel getUserById(@PathVariable Long id){
        return userRepository.findById(id).orElse(null);
    }
@PostMapping
    public UserModel createUser(@RequestBody UserModel userModel){
        return userRepository.save(userModel);
    }
@PutMapping("/{id}")
    public UserModel updateUser(@PathVariable Long id, @RequestBody UserModel updateUser){
        UserModel existingUser =  userRepository.findById(id).orElse(null);
        if (existingUser != null){
            existingUser.setName(updateUser.getName());
            existingUser.setAge(updateUser.getAge());
            return userRepository.save(existingUser);
        }
        return null;
    }
@DeleteMapping
    public void deleteUser(@PathVariable Long id){
        userRepository.deleteById(id);
    }
}
