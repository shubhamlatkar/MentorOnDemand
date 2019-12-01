package com.project.Training.controller;

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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.project.Training.Dao.StudentDao;
import com.project.Training.Dao.TrainingDao;
import com.project.Training.Dto.AllTrainingDTO;
import com.project.Training.Dto.EnrollForCourceDTO;
import com.project.Training.Dto.TrainingDto;
import com.project.Training.model.Student;
import com.project.Training.model.Trainer;
import com.project.Training.model.Training;

@CrossOrigin("*")
@RestController
@RequestMapping("/training")
public class TrainingController {
	
	@Autowired
	TrainingDao trainingDao;
	
	@Autowired
	StudentDao studentDao;
	
	@Autowired
	RestTemplate restTemplate;
	
	@GetMapping(value = "/getCources")
	public ResponseEntity<List<TrainingDto>> getAll() {
		List<TrainingDto> trainings = new ArrayList<TrainingDto>();
		trainingDao.findAll().forEach(data -> {
			HttpHeaders headers = new HttpHeaders();
			headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
			HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
			Trainer trainer = restTemplate.exchange(
			         "http://localhost:8082/getTrainerById/"+data.getMentorId(), HttpMethod.GET, entity, Trainer.class).getBody();
			trainings.add(new TrainingDto(data.getId(), data.getName(), trainer.getId(), trainer.getName(), data.isCompleted(), trainer.getSkills()));
		});
		return ResponseEntity.ok(trainings);
	}
	
	@PostMapping("/enrollForCource")
	public ResponseEntity<String> enrollForCource(@RequestBody EnrollForCourceDTO enrollObj) {
		trainingDao.findById(enrollObj.getCourceId()).ifPresent(data -> {
			List<Student> studentIdForThis = data.getStudents();
			studentDao.findById(enrollObj.getStudentId()).ifPresent(temData -> {
				studentIdForThis.add(temData);
			});
			data.setStudents(studentIdForThis);
			trainingDao.save(data);
		});
		return ResponseEntity.ok("Sucessfully Enrolled");
	}
	
	@GetMapping("/getAllTrainings")
	public ResponseEntity<List<Training>> getAllTrainings() {
		return ResponseEntity.ok(trainingDao.findAll());
	}
}
