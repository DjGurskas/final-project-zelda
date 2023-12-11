//package project.zelda.controllers;
//
//import org.apache.catalina.User;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//public class GatewayController {
//
//    @Autowired
//    private UserController userController;
//
//    @Autowired
//    private ZeldaController zeldaController;
//
//    @GetMapping("/users")
//    public ResponseEntity<List<UserModel>> getAllUsers() {
//        return userController.getAllUsers();
//    }
//
//    @GetMapping("/users/{id}")
//    public ResponseEntity<UserModel> getUserById(@PathVariable Long id) {
//        return userController.getUserById(id);
//    }
//
//    @PostMapping("/users")
//    public ResponseEntity<UserModel> createUser(@RequestBody UserModel userModel) {
//        return userController.createUser(userModel);
//    }
//
//    @PutMapping("/users/{id}")
//    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody UserModel userModel) {
//        return userController.updateUser(id, userModel);
//    }
//
//    @DeleteMapping("/users/{id}")
//    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
//        return userController.deleteUser(id);
//    }
//
//    @GetMapping("/zelda")
//    public ResponseEntity<String> getZeldaData() {
//        return zeldaController.getZeldaData();
//    }
//}
