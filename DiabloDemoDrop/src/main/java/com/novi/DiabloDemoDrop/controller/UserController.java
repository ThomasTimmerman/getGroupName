/**
 * @author wouterverveer 
 */
package com.novi.DiabloDemoDrop.controller;

import com.novi.DiabloDemoDrop.model.User;
import com.novi.DiabloDemoDrop.repository.UserRepository;
import com.novi.DiabloDemoDrop.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("api/user")
@RestController
public class UserController {

    private final UserRepository repo;
    private final UserService service;

    @Autowired
    public UserController(UserRepository repo, UserService service) {
        this.repo = repo;
        this.service = service;
    }

    // CRUD methods here
    @GetMapping
    public List findAll(){
        return repo.findAll();
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<User> findById(@PathVariable long id){
        return repo.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }
    
    
    @PostMapping
    public User create(@RequestBody User user){     
        return repo.save(user);
    }
    
    
    @PutMapping(value="/{id}")
    public ResponseEntity<User> update(@PathVariable("id") long id,
                                          @RequestBody User user){
        return repo.findById(id)
                .map(record -> {
                    record.setName(user.getName());                   
                    record.setEmail(user.getEmail());
                    record.setActive(user.isActive());
                    User updated = repo.save(record);
                    return ResponseEntity.ok().body(updated);
                }).orElse(ResponseEntity.notFound().build());
        
    }
    
    
    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping(path ={"/{id}"})
    public ResponseEntity<?> delete(@PathVariable("id") long id) {
        return repo.findById(id)
                .map(record -> {
                    repo.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }

}
