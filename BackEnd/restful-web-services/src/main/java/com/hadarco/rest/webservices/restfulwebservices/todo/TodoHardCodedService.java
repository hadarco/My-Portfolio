package com.hadarco.rest.webservices.restfulwebservices.todo;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TodoHardCodedService
{
    //we want static list of todos (todos will act as db for now)
    private static List<Todo> todos = new ArrayList();
    private static long idCounter = 0;
    static
    {
        todos.add(new Todo(++idCounter, "Hadar", "Learn about Dockers", new Date(), false));
        todos.add(new Todo(++idCounter, "Hadar", "Make a cheesecake", new Date(), false));
        todos.add(new Todo(++idCounter, "Hadar", "Finish the course", new Date(), false));
    }

    public List<Todo> findAll()
    {
        return todos;
    }

    public Todo save(Todo todo)
    {
        if(todo.getId()==-1 || todo.getId()==0)//if it didn't exist, set its id and add it.
        {
            todo.setId(++idCounter);
            todos.add(todo);
        }
        else//when I want to update it, delete it first and then add it
        {
            deleteById(todo.getId());
            todos.add(todo);
        }
        return todo;
    }


    public Todo deleteById(long id)
    {
        Todo todo = findById(id);
        if(todos.remove(todo))
            return todo;
        return null;
    }

    public Todo findById(long id)
    {
        for(Todo todo:todos)
        {
            if(todo.getId()==id)
                return todo;
        }
        return null;
    }

}
