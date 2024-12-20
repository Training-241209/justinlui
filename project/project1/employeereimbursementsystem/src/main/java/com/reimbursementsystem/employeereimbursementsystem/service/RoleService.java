package com.reimbursementsystem.employeereimbursementsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.reimbursementsystem.employeereimbursementsystem.entity.Role;
import com.reimbursementsystem.employeereimbursementsystem.repository.RoleRepository;

@Service
@Transactional
public class RoleService{
    @Autowired
    RoleRepository roleRepository;

    public Role getRoleByName(String roleName){
        return this.roleRepository.findByEmployeeStatus(roleName);
    }
    public Role createRole(String roleName){
        Role existingRole = getRoleByName(roleName);
        if (existingRole != null) {
            return existingRole; 
        }
        Role newlyRole = new Role(roleName);
        return this.roleRepository.save(newlyRole);
    }
    public Role deleteRole(Role role){
        this.roleRepository.delete(role);
        return role;
          
    }

    public Role updateRole(Role role,String newRole){
        Role pulledRole = getRoleByName(role.getRoleName());
        pulledRole.setRole(newRole);
        return pulledRole;
    }
}