package com.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioModel {
    
    private Long id;
    private String username;
    private String password;
    private String enable;
    private RolModel rol;
    private String name;
    private String surname;
}
