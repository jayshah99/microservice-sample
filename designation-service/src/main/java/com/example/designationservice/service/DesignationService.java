package com.example.designationservice.service;

import com.example.designationservice.repository.DesignationRepository;
import com.example.designationservice.resource.model.Designation;
import com.example.designationservice.resource.pojo.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DesignationService {

    @Autowired
    DesignationRepository designationRepository;

    public List<Designation> getAll() {
        return designationRepository.findAll();
    }


    public Designation addDesignation(Designation designation) {
        return designationRepository.save(designation);
    }

    public Response delete(int id) {
        Optional<Designation> designation = designationRepository.findById(id);
        if (designation.isPresent()) {
            designationRepository.deleteById(id);
            return new Response(false, String.format("Designation with id: %s Deleted Successfully", id));
        }

        return new Response(true, String.format("Designation with id: %s not found", id));
    }


    public Designation updateById(Designation designation, int id) {
        Designation designation1 = designationRepository.findById(id).get();
        designation1.setDesignation(designation.getDesignation());
        designation1.setEndDate(designation.getEndDate());
        designation1.setStartDate(designation.getStartDate());
        designation1.setEmpId(designation.getEmpId());
        return designationRepository.save(designation1);
    }
}


