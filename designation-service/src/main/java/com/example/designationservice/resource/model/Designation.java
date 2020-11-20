package com.example.designationservice.resource.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Entity;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Designation {

    @Id
    @GeneratedValue
    int id;

    String designation;

    String startDate;

    String endDate;

    int empId;

}
