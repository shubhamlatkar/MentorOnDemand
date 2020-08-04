package com.mod.user_service.service;

import com.mod.user_service.document.Trainer;
import com.mod.user_service.repository.TrainerRepository;
import org.springframework.stereotype.Service;

@Service
public class TrainerService {

    private final TrainerRepository trainerRepository;

    public TrainerService(TrainerRepository trainerRepository) {
        this.trainerRepository = trainerRepository;
    }

    public Trainer post(Trainer trainer) {
        if (!trainerRepository.existsByUsername(trainer.getUsername()))
            return trainerRepository.save(trainer);
        return trainerRepository.findByUsername(trainer.getUsername()).orElse(null);
    }

    public Trainer put(Trainer trainer) {
        Trainer found = trainerRepository.findByUsername(trainer.getUsername()).orElse(null);
        if (!trainerRepository.existsByUsername(trainer.getUsername()) && found != null) {
            found.setCompany(trainer.getCompany());
            found.setDescription(trainer.getDescription());
            found.setEmail(trainer.getEmail());
            found.setExperties(trainer.getExperties());
            found.setFullName(trainer.getFullName());
            found.setPhone(trainer.getPhone());
            found.setPosition(trainer.getPosition());
            return trainerRepository.save(found);
        }
        return trainerRepository.save(trainer);
    }

    public Trainer getTrainer(String username) {
        return trainerRepository.findByUsername(username).orElse(null);
    }
}
