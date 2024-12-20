package com.reimbursementsystem.employeereimbursementsystem.repository;
import com.reimbursementsystem.employeereimbursementsystem.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface RoleRepository extends JpaRepository<Role,Integer> {
    @Autowired
    public Role findByEmployeeStatus(String employeeStatus);

    @Autowired
    public Role findById(int id);
    

}
