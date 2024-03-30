package com.domain.usuario;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import com.dto.UsuarioModel;

@Service
public class UsuarioServiceImpl implements UsuarioService{

    private final ModelMapper modelMapper;
    private final UsuarioRepository usuarioRepository;
    // private final BCryptPasswordEncoder bcryptPasswordEncoder;

    public UsuarioServiceImpl(
        ModelMapper modelMapper,
        UsuarioRepository usuarioRepository
        // BCryptPasswordEncoder bcryptPasswordEncoder
    ) {
        this.modelMapper = modelMapper;
        this.usuarioRepository = usuarioRepository;
        // this.bcryptPasswordEncoder = bcryptPasswordEncoder;
    }

    @Transactional
    @Override
    public UsuarioModel createUsuario(UsuarioModel usuarioModel) {
        
        if (usuarioRepository.existsByUsername(usuarioModel.getUsername())) {
            throw new ResponseStatusException(
                HttpStatus.CONFLICT,
                "Ya existe un usuario con el nombre de usuario proporcionado."
            );
        }

        // usuarioModel.setPassword( this.bcryptPasswordEncoder.encode(usuarioModel.getPassword()) );

        Usuario usuario = modelMapper.map(usuarioModel, Usuario.class);
        usuario = usuarioRepository.save(usuario);
        usuarioModel.setId(usuario.getId());
        return modelMapper.map(usuario, UsuarioModel.class);
    }

    @Transactional
    @Override
    public UsuarioModel updateUsuario(Long id, UsuarioModel usuarioModel) {

        if (usuarioRepository.existsById(id)) {
            Usuario usuarioActualizado = modelMapper.map(usuarioModel, Usuario.class);
            usuarioRepository.save(usuarioActualizado);
            return usuarioModel;
        }
        throw new ResponseStatusException(
            HttpStatus.NOT_FOUND, 
            "Usuario no encontrado para actualizar."
        );
    }

    @Override
    public UsuarioModel getUsuarioById(Long id) {

        Usuario usuario = usuarioRepository.findById(id).orElse(null);
        if (usuario == null) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, 
                "Usuario no encontrado."
            );
        }
        return modelMapper.map(usuario, UsuarioModel.class);
    }

    @Override
    public UsuarioModel getUsuarioByUsername(String username) {

        Usuario usuario = usuarioRepository.findByUsername(username);
        if (usuario == null) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, 
                "Usuario no encontrado."
            );
        }
        return modelMapper.map(usuario, UsuarioModel.class);
    }

    @Override
    public List<UsuarioModel> getAllUsuarios() {

        List<Usuario> entity = usuarioRepository.findAll();
        return entity.stream()
            .map(aux -> modelMapper.map(aux, UsuarioModel.class))
            .collect(Collectors.toList());
    }

    @Override
    public List<UsuarioModel> getAllUsuarioByEnable(String enable) {

        List<Usuario> entity = usuarioRepository.findByEnable(enable);
        return entity.stream()
            .map(aux -> modelMapper.map(aux, UsuarioModel.class))
            .collect(Collectors.toList());
    }

    @Override
    public void deleteUsuario(Long id) {

        if (usuarioRepository.existsById(id)) {
            usuarioRepository.deleteById(id);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario no encontrada para eliminar.");
        }
    }
}
