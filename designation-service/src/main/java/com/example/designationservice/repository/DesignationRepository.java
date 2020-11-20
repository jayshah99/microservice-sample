package com.example.designationservice.repository;

import com.example.designationservice.resource.model.Designation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DesignationRepository extends JpaRepository<Designation,Integer> {
}
