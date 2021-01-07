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
        if (found != null) {
            if (trainer.getCompany() != null) found.setCompany(trainer.getCompany());
            if (trainer.getDescription() != null) found.setDescription(trainer.getDescription());
            if (trainer.getEmail() != null) found.setEmail(trainer.getEmail());
            if (trainer.getExpertise() != null) found.setExpertise(trainer.getExpertise());
            if (trainer.getFullName() != null) found.setFullName(trainer.getFullName());
            if (trainer.getMobile() != null) found.setMobile(trainer.getMobile());
            if (trainer.getPosition() != null) found.setPosition(trainer.getPosition());
            return trainerRepository.save(found);
        }
        return trainer;
    }

    public Trainer getTrainer(String username) {
        return trainerRepository.findByUsername(username).orElse(null);
    }

    public void delete(String username) {
        trainerRepository.findByUsername(username).ifPresent(trainerRepository::delete);
    }
}
