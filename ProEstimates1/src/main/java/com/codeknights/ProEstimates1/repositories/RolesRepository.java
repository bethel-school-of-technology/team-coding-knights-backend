package com.codeknights.ProEstimates1.repositories;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;


import com.codeknights.ProEstimates1.models.Roles;

@Repository
public interface RolesRepository extends JpaRepository<Roles, Integer>{

}
