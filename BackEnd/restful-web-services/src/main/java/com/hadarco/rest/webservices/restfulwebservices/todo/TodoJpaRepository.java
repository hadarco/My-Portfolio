package com.hadarco.rest.webservices.restfulwebservices.todo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//Long is the pk of Ttodo
@Repository
public interface TodoJpaRepository extends JpaRepository<Todo, Long>
{
    List<Todo> findByUsername(String username);
}
