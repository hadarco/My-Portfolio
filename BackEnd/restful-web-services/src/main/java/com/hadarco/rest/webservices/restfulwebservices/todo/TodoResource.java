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
public class TodoResource
{
    //service
    @Autowired
    private TodoHardCodedService todoService;

    @GetMapping("/users/{username}/todos")
    public List<Todo> getAllTodos(@PathVariable String username)
    {
        return todoService.findAll();
    }

    @GetMapping("/users/{username}/todos/{id}")
    public Todo getTodo(@PathVariable String username, @PathVariable long id)
    {
        return todoService.findById(id);
    }

    //DELETE - return noContent when it's successful or notFound when failed
    @DeleteMapping("/users/{username}/todos/{id}")
    //ResponseEntity helps us build specific requests with specific status
    public ResponseEntity<Void> deleteTodo(@PathVariable String username, @PathVariable long id)
    {
        Todo todo = todoService.deleteById(id);
        if(todo!=null)
            return ResponseEntity.noContent().build();
        return ResponseEntity.notFound().build();
    }

    //EDIT Update a TODOO - PUT - will return a status of ok with the content of the updated resource
    @PutMapping("/users/{username}/todos/{id}")
    public ResponseEntity<Todo> updateTodo(
            @PathVariable String username, @PathVariable long id, @RequestBody Todo todo)
    {
        Todo todoUpdated = todoService.save(todo);
        return new ResponseEntity<Todo>(todo, HttpStatus.OK);
    }

    //Create Update a TODOO - Post - will return a status of ok with the content
    //of the created resource-todoo and the uri of the created resource
    @PostMapping("/users/{username}/todos")
    public ResponseEntity<Void> updateTodo(
            @PathVariable String username,@RequestBody Todo todo)
    {
        Todo createdTodo = todoService.save(todo);

        //Location
        //Get current resource url
        //we will append to it the id and then send it
        //the id of the created todoo will be the {id}
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(createdTodo.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }


}
