package com.mod.user_service.service;

import com.mod.user_service.document.Admin;
import com.mod.user_service.document.User;
import com.mod.user_service.repository.AdminRepository;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    private final AdminRepository adminRepository;

    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    public void post(Admin admin) {
        if (!adminRepository.existsByUsername(admin.getUsername()))
            adminRepository.save(admin);
    }

    public Admin put(Admin admin) {
        Admin found = adminRepository.findByUsername(admin.getUsername()).orElse(null);
        if (found != null) {
            if (admin.getEmail() != null) found.setEmail(admin.getEmail());
            if (admin.getMobile() != null) found.setMobile(admin.getMobile());
            if (admin.getFullName() != null) found.setFullName(admin.getFullName());
            if(admin.getAddress() != null) found.setAddress(admin.getAddress());
            found = adminRepository.save(found);
        }
        return found;
    }

    public Admin get(String username) {
        return adminRepository.findByUsername(username).orElse(null);
    }

    public void delete(String username) {
        adminRepository.findByUsername(username).ifPresent(adminRepository::delete);
    }

}
