package com.reimbursementsystem.employeereimbursementsystem.controller;

import com.reimbursementsystem.employeereimbursementsystem.entity.Role;
import com.reimbursementsystem.employeereimbursementsystem.service.RoleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    RoleService roleService;

    
}
