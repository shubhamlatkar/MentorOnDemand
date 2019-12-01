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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.project.Trainer.Dao.NotificationDao;
import com.project.Trainer.Dao.SkillsDao;
import com.project.Trainer.Dao.TrainerDao;
import com.project.Trainer.Dto.EnrollForCourceDTO;
import com.project.Trainer.Dto.TrainerDto;
import com.project.Trainer.model.Notification;
import com.project.Trainer.model.Skills;
import com.project.Trainer.model.Trainer;

@RestController
public class TrainerController {
	
	@Autowired
	NotificationDao notificationDao;
	
	@Autowired
	SkillsDao skillsDao;
	
	@Autowired
	TrainerDao trainerDao;
	
	@Autowired
	RestTemplate restTemplate;
	
	@PutMapping("/updateTrainer")
	public ResponseEntity<String> updateTrainer(@RequestBody TrainerDto trainer ){
		skillsDao.findById()
		return ResponseEntity.ok("Trainer Updated");
	}
	
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
}
