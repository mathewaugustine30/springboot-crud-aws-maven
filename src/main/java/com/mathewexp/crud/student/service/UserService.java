package com.mathewexp.crud.student.service;

import com.mathewexp.crud.student.entity.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserService {
	public User save(User user);
	public User update(User student);
	public User get(Long id);
	public void delete(Long id);
	public List<User> getAllUsers();
}