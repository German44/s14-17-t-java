package com.domain.usuario;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    
    boolean existsByUsername(String username);
    Usuario findByUsername(String username);
    List<Usuario> findByEnable(String enable);
}
