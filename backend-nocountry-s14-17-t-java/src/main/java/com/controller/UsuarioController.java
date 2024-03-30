package com.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.dto.UsuarioModel;
import com.domain.usuario.UsuarioService;

@RestController
@CrossOrigin(origins={"*"})
@RequestMapping("/usuario")
public class UsuarioController {

    private UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("/create")
    public ResponseEntity<UsuarioModel> createUsuario(@RequestBody UsuarioModel usuarioModel) {
        return ResponseEntity.ok( this.usuarioService.createUsuario(usuarioModel) );
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioModel> updateUsuario(@PathVariable Long id, @RequestBody UsuarioModel usuarioModel) {
        return ResponseEntity.ok( this.usuarioService.updateUsuario(id, usuarioModel) );
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioModel> getUsuarioById(@PathVariable Long id) {
        return ResponseEntity.ok( this.usuarioService.getUsuarioById(id) );
    }

    @GetMapping("/username/{username}")
    public ResponseEntity<UsuarioModel> getUsuarioByUsername(@PathVariable String username) {
        return ResponseEntity.ok( this.usuarioService.getUsuarioByUsername(username) );
    }

    @GetMapping
    public ResponseEntity<List<UsuarioModel>> getAllUsuarios() {
        return ResponseEntity.ok( this.usuarioService.getAllUsuarios() );
    }

    @GetMapping("/enable/{enable}")
    public ResponseEntity<List<UsuarioModel>> getAllUsuarioByEnable(@PathVariable String enable) {
        return ResponseEntity.ok( this.usuarioService.getAllUsuarioByEnable(enable) );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUsuario(@PathVariable Long id) {
        usuarioService.deleteUsuario(id);
        return ResponseEntity.noContent().build();
    }
}
