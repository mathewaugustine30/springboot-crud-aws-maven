package com.mathewexp.crud.student.service;

import com.mathewexp.crud.student.entity.User;
import com.mathewexp.crud.student.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User update(User user) {
        return userRepository.save(user);
    }

    @Override
    public User get(Long id) {
        Optional<User> byId = userRepository.findById(id);
        return byId.get();
    }

    @Override
    public void delete(Long id) {
        Optional<User> byId = Optional.ofNullable(userRepository.findById(id).orElseThrow(() -> new RuntimeException("Invalid userId: " + id)));
        userRepository.delete(byId.get());
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
