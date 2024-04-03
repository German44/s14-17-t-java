package com.domain.user;

import java.util.List;

import com.dto.UserModel;

public interface UserService {

    UserModel createUser(UserModel UserModel);
    UserModel updateUser(Long id, UserModel UserModel);

    UserModel getUserById(Long id);
    UserModel getUserByUsername(String username);

    List<UserModel> getAllUsers();
    List<UserModel> getAllUserByEnable(String enable);

    void deleteUser(Long id);
}
