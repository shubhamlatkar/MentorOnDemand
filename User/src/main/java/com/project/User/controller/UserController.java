package com.project.User.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.project.User.Dao.NotificationDao;
import com.project.User.Dao.NotificationsDao;
import com.project.User.Dao.PaymentsDao;
import com.project.User.Dao.UserDao;
import com.project.User.model.Notification;
import com.project.User.model.Notifications;
import com.project.User.model.Payments;
import com.project.User.model.User;

@CrossOrigin("*")
@RestController
public class UserController {
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	NotificationsDao  notificationsDao;
	
	@Autowired
	private NotificationDao notificationDao;
	
	@Autowired
	PaymentsDao paymentDao;
	
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
			 userDao.save(user);
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
	@GetMapping("/getNotifications")
	public List<Notifications> getNotifications() {
		return notificationsDao.findAll();
	}
	
	@GetMapping("/getNotificationsById/{id}")
	public List<Notifications> getNotificationsById(@PathVariable long id) {
		return notificationsDao.findAllByStudentId(id);
	}	
	
	@GetMapping("/getUserById/{id}")
	public Optional<User> getUserById(@PathVariable long id) {
		return userDao.findById(id);
	}
	
	@GetMapping("/getPayments")
	public List<Payments> getPayments() {
		return paymentDao.findAll();
    }
    
    @GetMapping("/users")
    public List<User> getUsers() {
        return userDao.findAll();
    }
}   
