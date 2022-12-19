package com.mathewexp.crud.student.web;

import com.mathewexp.crud.student.dto.UserDto;
import com.mathewexp.crud.student.exception.UserNotFoundException;
import com.mathewexp.crud.student.service.UserDtoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Locale;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
public class UserController {

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private UserDtoService service;
    @GetMapping("/users")
    public List<UserDto> retriveAllUsers()
    {
        return service.findAll();
    }

    @GetMapping("/users/{id}")
    public UserDto retriveUser(@PathVariable int id)
    {
        return service.findOne(id);
    }


    @GetMapping("/users/hate/{id}")
    public EntityModel<UserDto> retriveUserWithHateosLink(@PathVariable int id)
    {
        UserDto user= service.findOne(id);

//retrieveAllUsers
        EntityModel<UserDto> entityModel = EntityModel.of(user); //constructor of Resource class
//add link to retrieve all the users
        WebMvcLinkBuilder linkTo=linkTo(methodOn(this.getClass()).retriveAllUsers());
        entityModel.add(linkTo.withRel("all-users"));
        return entityModel;
    }

    //method that posts a new user detail
    @PostMapping("/users")
    public ResponseEntity<Object> createUser(@Valid @RequestBody UserDto user)
    {
        UserDto sevedUser=service.save(user);
        URI location= ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(sevedUser.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    //method that delete a user resource
//if the user deleted successfully it returns status 200 OK otherwise 404 Not Found
    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id)
    {
        UserDto user= service.deleteById(id);
    }


    //internationalization
    @GetMapping(path="/hello-world-internationalized")
    public String helloWorldInternationalized(@RequestHeader(name="Accept-Language", required=false) Locale locale)
    {
        return messageSource.getMessage("good.morning.message", null, locale);
    }
}
