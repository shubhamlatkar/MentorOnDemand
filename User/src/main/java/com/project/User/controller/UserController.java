package com.project.User.controller;

import java.util.Arrays;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.project.User.Dao.NotificationDao;
import com.project.User.Dao.UserDao;
import com.project.User.Dto.EnrollForCourceDTO;
import com.project.User.Dto.RequestDto;
import com.project.User.model.Notification;
import com.project.User.model.User;

@RestController
public class UserController {
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private NotificationDao notificationDao;
	
	@PostMapping(value = "/add")
	public ResponseEntity<String> addUser(@RequestBody User user) {
		userDao.save(user);
		return ResponseEntity.ok("Inserted Sucessfully");
	}
	
	@GetMapping(value = "/getOneUser/{id}") 
	public ResponseEntity<Optional<User>> getOneUser(@PathVariable long id) {
			Optional<User> user = userDao.findById(id);
		return ResponseEntity.ok(user);
	}
	
	 @PutMapping("/update/{Id}")
	 public ResponseEntity<String> updateUser(@PathVariable long Id, @RequestBody User user)
	 {
		 Optional<User> tempUser = userDao.findById(Id);
		 tempUser.ifPresent(data -> {
			 data.setEmail(user.getEmail());
			 data.setAge(user.getAge());
			 data.setUsername(user.getUsername());
			 userDao.save(data);
		 });
		 return ResponseEntity.ok("Sucessfulley Updated");
	 }
	 
	 @PostMapping("/updateNotification")
	 public ResponseEntity<String>  requestTrainer(@RequestBody Notification notification) {
		 System.out.println(notification);
		 Notification noti = notificationDao.findByForTrainerId(notification.getForTrainerId());
		 noti.setAccepted(true);
		 notificationDao.save(noti);
		 return ResponseEntity.ok("Requested");
	 }
	
}
