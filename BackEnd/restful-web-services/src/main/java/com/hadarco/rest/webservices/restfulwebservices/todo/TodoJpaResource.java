package com.hadarco.rest.webservices.restfulwebservices.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class TodoJpaResource
{
    //service
    @Autowired
    private TodoHardCodedService todoService;

    //service
    @Autowired
    private TodoJpaRepository todoJpaRepository;

    @GetMapping("/jpa/users/{username}/todos")
    public List<Todo> getAllTodos(@PathVariable String username)
    {
        return todoJpaRepository.findByUsername(username);
    }

    @GetMapping("/jpa/users/{username}/todos/{id}")
    public Todo getTodo(@PathVariable String username, @PathVariable long id)
    {
        return todoJpaRepository.findById(id).get(); //findById(id) returns optional back thats why we add .get()
    }

    //DELETE - return noContent when it's successful or notFound when failed
    @DeleteMapping("/jpa/users/{username}/todos/{id}")
    //ResponseEntity helps us build specific requests with specific status
    public ResponseEntity<Void> deleteTodo(@PathVariable String username, @PathVariable long id)
    {
        //Todo todo = todoService.deleteById(id);
        todoJpaRepository.deleteById(id);
        return ResponseEntity.noContent().build();
        //return ResponseEntity.notFound().build();
    }

    //EDIT Update a TODOO - PUT - will return a status of ok with the content of the updated resource
    @PutMapping("/jpa/users/{username}/todos/{id}")
    public ResponseEntity<Todo> updateTodo(
            @PathVariable String username, @PathVariable long id, @RequestBody Todo todo)
    {
        Todo todoUpdated = todoJpaRepository.save(todo);
        return new ResponseEntity<Todo>(todo, HttpStatus.OK);
    }

    //Create Update a TODOO - Post - will return a status of ok with the content
    //of the created resource-todoo and the uri of the created resource
    @PostMapping("/jpa/users/{username}/todos")
    public ResponseEntity<Void> createTodo(
            @PathVariable String username,@RequestBody Todo todo)
    {
        todo.setUsername(username);
        Todo createdTodo = todoJpaRepository.save(todo);

        //Location
        //Get current resource url
        //we will append to it the id and then send it
        //the id of the created todoo will be the {id}
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(createdTodo.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }


}
