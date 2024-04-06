package com.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GroupUserModel {
    
    private Long id;

    private String role;

    private UserModel user;
    private GroupModel group;
}
