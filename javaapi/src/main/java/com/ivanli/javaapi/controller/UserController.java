package com.ivanli.javaapi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ivanli.javaapi.DAO.UserDAO;
import com.ivanli.javaapi.model.User;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserDAO userDAO;
	
	// Get all Users
	@ApiOperation(value = "Get all Users", notes = "Returns a list of all Users.")
	@ApiResponse(code = 200, message = "List of all Users")
	@GetMapping("")
	public ResponseEntity<List<User>> getAllUsers(){
		return ResponseEntity.ok().body(userDAO.getAll());
	}
	
	// Create a new User
	@ApiOperation(value = "Create new user", notes = "Creates a new User")
	@ApiImplicitParam(name="user", value="User data to add", required = true, dataType="User")
	@ApiResponses({
		@ApiResponse(code = 204, message = "User Created Successfully"),
		@ApiResponse(code = 480, message = "Unexpected Error")
	})
	@PostMapping("")
	public ResponseEntity<String> createUser(@Valid @RequestBody User user) {
		if(userDAO.saveUser(user) != null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		return ResponseEntity.status(480).build();
	}
	
	// Get a User by the user id
	@ApiOperation(value = "Get a user", notes = "Looks up a User by the user id")
	@ApiImplicitParam(name="id", value="User ID", required = true, dataType="int", paramType="path")
	@ApiResponses({
		@ApiResponse(code = 200, message = "Requested User's details"),
		@ApiResponse(code = 480, message = "Unexpected Error")
	})
	@GetMapping("/{id}")
	public ResponseEntity<User> getUserById(@PathVariable(value="id") Integer uId){
		User user = userDAO.getUser(uId);
		
		if(user!=null) {
			return ResponseEntity.ok().body(user);
		}
		return ResponseEntity.status(480).build();
	}
	
	// Update a User by user id
	@ApiOperation(value = "Update a user", notes = "Updates a User")
	@ApiImplicitParams({
		@ApiImplicitParam(name="id", value="User ID", required = true, dataType="int", paramType="path"),
		@ApiImplicitParam(name="user", value="User¡¯s update data", required = true, dataType="User")
	})
	@ApiResponses({
		@ApiResponse(code = 204, message = "User modified Successfully"),
		@ApiResponse(code = 480, message = "Unexpected Error")
	})
	@PutMapping("/{id}")
	public ResponseEntity<User> updateUserById(@PathVariable(value = "id") Integer uId, @Valid @RequestBody User user){
		User updatedUser = userDAO.getUser(uId);
		
		if(updatedUser!=null) {
			updatedUser.setId(uId);
			updatedUser.setName(user.getName());
			updatedUser.setEmail(user.getEmail());
			
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		
		return ResponseEntity.status(480).build();
	}
	
	// Delete a User
	@ApiOperation(value = "Delete a user", notes = "Deletes a user")
	@ApiImplicitParam(name="id", value="User ID", required = true, dataType="int", paramType="path")
	@ApiResponses({
		@ApiResponse(code = 204, message = "User deleted Successfully"),
		@ApiResponse(code = 480, message = "Unexpected Error")
	})
	@DeleteMapping("/{id}")
	public ResponseEntity<User> deleteUser(@PathVariable(value = "id") Integer uId){
		User user = userDAO.getUser(uId);
		
		if(user==null) {
			userDAO.deleteUser(user);
			
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		
		return ResponseEntity.status(480).build();
	}

}
