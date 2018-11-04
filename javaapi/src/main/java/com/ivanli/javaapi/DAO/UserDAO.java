package com.ivanli.javaapi.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ivanli.javaapi.model.User;
import com.ivanli.javaapi.repository.UserRepository;

@Service
public class UserDAO {
	
	@Autowired
	UserRepository userRepo;
	
	// Return a list of all Users
	public List<User> getAll(){
		return userRepo.findAll();
	}
	
	// Save a User
	public User saveUser(User u) {
		return userRepo.save(u);
	}
	
	// Looks up a User by the user id
	public User getUser(Integer uId) {
		return userRepo.findOne(uId);
	}

	
	// Delete a User
	public void deleteUser(User u) {
		userRepo.delete(u);
	}
	
}
