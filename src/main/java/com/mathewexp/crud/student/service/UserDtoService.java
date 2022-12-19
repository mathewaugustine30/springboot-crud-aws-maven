package com.mathewexp.crud.student.service;

import com.mathewexp.crud.student.dto.UserDto;
import com.mathewexp.crud.student.exception.UserNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Component
public class UserDtoService {

    public static int usersCount=5;
    //creating an instance of ArrayList
    private static List<UserDto> users=new ArrayList<>();

    //static block
    static
    {
//adding users to the list
        users.add(new UserDto(1, "John", new Date()));
        users.add(new UserDto(2, "Robert", new Date()));
        users.add(new UserDto(3, "Adam", new Date()));
        users.add(new UserDto(4, "Andrew", new Date()));
        users.add(new UserDto(5, "Jack", new Date()));
    }

    //method that retrieve all users from the list
    public List<UserDto> findAll()
    {
        return users;
    }
    //method that add the user in the list
    public UserDto save(UserDto user)
    {
        if(user.getId()==null)
        {
//increments the user id
            user.setId(++usersCount);
        }
        users.add(user);
        return user;
    }
    //method that find a particular user from the list
    public UserDto findOne(int id)
    {
        for(UserDto user:users)
        {
            if(user.getId()==id)
                return user;
        }
        throw new UserNotFoundException("No user exist for "+id);
    }


    public UserDto deleteById(int id)
    {
        Iterator<UserDto> iterator = users.iterator();
        while(iterator.hasNext())
        {
            UserDto user=iterator.next();
            if(user.getId()==id)
            {
                iterator.remove();
                return user; //returns the deleted resource back
            }
        }
        throw new UserNotFoundException("Unable to delete as no user exist for "+id);
    }
}
