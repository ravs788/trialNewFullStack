package com.ravi.crudApp.backend.dtos;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GymRecordDto {

    @Id
    private Long id;
    private String exercise;
    private Integer weight;

}
