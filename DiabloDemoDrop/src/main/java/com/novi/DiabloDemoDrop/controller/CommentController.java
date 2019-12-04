/**
 * @author wouterverveer 
 */
package com.novi.DiabloDemoDrop.controller;

import com.novi.DiabloDemoDrop.model.Comment;
import com.novi.DiabloDemoDrop.repository.CommentRepository;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api/comment")
@RestController
public class CommentController {
    
    //Directs to the CommentRepository to use the CRUD from Jpa
    private final CommentRepository repo;

    public CommentController(CommentRepository repo) {
        this.repo = repo;
    }
   
    
    
    //CRUD
    @GetMapping
    public List findAll(){
        return repo.findAll();
    }
    
    @PostMapping
    public Comment create(@RequestBody Comment comment){
        return repo.save(comment);
    }
 
    @GetMapping(path = {"/{id}"})
    public ResponseEntity<Comment> findById(@PathVariable long id){
        return repo.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }
    
    @PutMapping(value="/{id}")
    public ResponseEntity<Comment> update(@PathVariable("id") long id, @RequestBody Comment comment){
       return repo.findById(id)
                .map(record -> {
                    record.setComment(comment.getComment());
                    
                    Comment updated = repo.save(record);
                    return ResponseEntity.ok().body(updated);
                }).orElse(ResponseEntity.notFound().build());
  
    }

    @DeleteMapping(path ={"/{id}"})
    public ResponseEntity<?> delete(@PathVariable("id") long id) {
        return repo.findById(id)
                .map(record -> {
                    repo.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }
    
    

}
