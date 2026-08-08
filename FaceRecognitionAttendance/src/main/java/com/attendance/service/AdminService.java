package com.attendance.service;

import com.attendance.entity.Admin;
import com.attendance.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    // Register Admin
    public Admin registerAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    // Login Admin
    public Admin loginAdmin(String email, String password) {
        Optional<Admin> admin = adminRepository.findByEmail(email);

        if (admin.isPresent() && admin.get().getPassword().equals(password)) {
            return admin.get();
        }

        return null;
    }

    // Get Admin by ID
    public Admin getAdminById(Long id) {
        return adminRepository.findById(id).orElse(null);
    }

    // Update Admin
    public Admin updateAdmin(Admin admin) {
        return adminRepository.save(admin);
    }
}