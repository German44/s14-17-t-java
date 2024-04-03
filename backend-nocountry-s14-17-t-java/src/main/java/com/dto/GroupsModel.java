package com.dto;

import lombok.Getter;
import lombok.Setter;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GroupsModel {
    
    private Long id;
    private String name;
    private String descripcion;
    private Integer status;

    private ProjectsModel projects;
}
