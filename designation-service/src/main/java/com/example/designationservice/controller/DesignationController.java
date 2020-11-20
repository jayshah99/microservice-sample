package com.example.designationservice.controller;

import com.example.designationservice.resource.model.Designation;
import com.example.designationservice.resource.pojo.Response;
import com.example.designationservice.service.DesignationService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/designations")
public class DesignationController {

        final DesignationService designationService;

        public DesignationController(DesignationService designationService) {
            this.designationService = designationService;
        }

        @GetMapping
        public List<Designation> getAll() {
            return designationService.getAll();
        }

        @ResponseStatus(HttpStatus.CREATED)
        @PostMapping
        public Designation addDesignation(@RequestBody Designation designation) {
            return designationService.addDesignation(designation);
        }

        @DeleteMapping("/{id}")
        public Response delete(@PathVariable(value = "id") int id) {
            return designationService.delete(id);
        }

        @PutMapping("/{id}")
        public Designation updateById(@RequestBody Designation designation, @PathVariable("id") int id) {
            return designationService.updateById(designation, id);
        }
}


