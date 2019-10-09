package com.project.Trainer.controller;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.project.Trainer.Dao.NotificationDao;
import com.project.Trainer.Dao.TrainerDao;
import com.project.Trainer.Dao.TrainersDao;
import com.project.Trainer.Dto.EnrollForCourceDTO;
import com.project.Trainer.model.Notification;
import com.project.Trainer.model.Skills;
import com.project.Trainer.model.Trainer;
import com.project.Trainer.model.Trainers;

@CrossOrigin("*")
@RestController
public class TrainerController {
	
	@Autowired
	NotificationDao notificationDao;
	
	@Autowired
	TrainerDao trainerDao;
	
	@Autowired
	TrainersDao trainersDao;
	
	@Autowired
	RestTemplate restTemplate;
	
	@PostMapping("/updateNotification")
	public ResponseEntity<String> updateNotification( @RequestBody Notification notification) {
			if(notification.getIsAccepted()) {
				HttpHeaders headers = new HttpHeaders();
				headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
				HttpEntity<EnrollForCourceDTO> entity = new HttpEntity<EnrollForCourceDTO>(new EnrollForCourceDTO(notification.getCourceId(), notification.getByUserId()),headers);
				System.out.println(restTemplate.exchange(
				         "http://localhost:8084/enrollForCource/", HttpMethod.POST, entity, String.class).getBody());
				
				HttpEntity<Notification> sendEntity = new HttpEntity<Notification>(notification, headers);
				System.out.println(restTemplate.exchange(
				         "http://localhost:8081/updateNotification/", HttpMethod.POST, sendEntity, String.class).getBody());
			} else {
				notificationDao.save(notification);
			}
		return ResponseEntity.ok("Notification Updated");
	}
	
	@GetMapping("/getTrainerById/{id}")
	public ResponseEntity<Trainer> getTrainerById(@PathVariable long id) {
		List<Skills> al = new ArrayList<Skills>();
		al.add(new Skills(1, "Java"));
		trainerDao.save(new Trainer(1, "shubham", "abc", al));
		Trainer tempTrainer = new Trainer();
		trainerDao.findById(id).ifPresent(data -> {
			tempTrainer.setId(data.getId());
			tempTrainer.setName(data.getName());
			tempTrainer.setEmail(data.getEmail());
			tempTrainer.setSkills(data.getSkills());
		});
		return ResponseEntity.ok(tempTrainer);
	}
	
	@GetMapping("/getTrainers")
	public List<Trainers> getTrainers() {
		return trainersDao.findAll();
	}
	
	@GetMapping("/getTrainersById/{id}")
	public Trainers getTrainersById(@PathVariable Long id) {
		Trainers trainer = new Trainers();
		trainersDao.findById(id).ifPresent(data -> {
			trainer.setId(data.getId());
			trainer.setAddress(data.getAddress());
			trainer.setCity(data.getCity());
			trainer.setEmail(data.getEmail());
			trainer.setFee(data.getFee());
			trainer.setName(data.getName());
			trainer.setSkills(data.getSkills());
			trainer.setState(data.getState());
		});
		return trainer;
	}
}
