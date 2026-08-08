package com.attendance.controller;

import com.attendance.entity.Admin;
import com.attendance.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    // Register Admin
    @PostMapping("/register")
    public Admin registerAdmin(@RequestBody Admin admin) {
        return adminService.registerAdmin(admin);
    }

    // Login Admin
    @PostMapping("/login")
    public Admin loginAdmin(@RequestParam String email,
                            @RequestParam String password) {

        return adminService.loginAdmin(email, password);

    }
    // Get Admin Details
    @GetMapping("/{id}")
    public Admin getAdmin(@PathVariable Long id) {
        return adminService.getAdminById(id);
    }

    // Update Admin
    @PutMapping("/update")
    public Admin updateAdmin(@RequestBody Admin admin) {
        return adminService.updateAdmin(admin);
    }
}