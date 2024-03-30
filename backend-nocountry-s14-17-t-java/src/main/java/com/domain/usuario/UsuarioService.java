package com.domain.usuario;

import java.util.List;

import com.dto.UsuarioModel;

public interface UsuarioService {

    UsuarioModel createUsuario(UsuarioModel usuarioModel);
    UsuarioModel updateUsuario(Long id, UsuarioModel usuarioModel);

    UsuarioModel getUsuarioById(Long id);
    UsuarioModel getUsuarioByUsername(String username);

    List<UsuarioModel> getAllUsuarios();
    List<UsuarioModel> getAllUsuarioByEnable(String enable);

    void deleteUsuario(Long id);
}
