package com.domain.rol;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import com.dto.RolModel;

@Service
public class RolServiceImpl implements RolService{

    private final ModelMapper modelMapper;
    private final RolRepository rolRepository;

    public RolServiceImpl(
        ModelMapper modelMapper,
        RolRepository rolRepository
    ) {
        this.modelMapper = modelMapper;
        this.rolRepository = rolRepository;
    }

    @Transactional
    @Override
    public RolModel createRol(RolModel rolModel) {
        
        Rol rol = modelMapper.map(rolModel, Rol.class);
        rol = rolRepository.save(rol);
        rolModel.setId(rol.getId());
        return modelMapper.map(rol, RolModel.class);
    }

    @Transactional
    @Override
    public RolModel updateRol(Long id, RolModel rolModel) {

        if (rolRepository.existsById(id)) {
            Rol rolActualizado = modelMapper.map(rolModel, Rol.class);
            rolRepository.save(rolActualizado);
            return rolModel;
        }
        throw new ResponseStatusException(
            HttpStatus.NOT_FOUND,
            "Rol no encontrado para actualizar."
        );
    }

    @Override
    public RolModel getRolById(Long id) {

        Rol rol = rolRepository.findById(id).orElse(null);
        if (rol == null) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, 
                "Rol no encontrado."
            );
        }
        return modelMapper.map(rol, RolModel.class);
    }

    @Override
    public List<RolModel> getAllRols() {

        List<Rol> entity = rolRepository.findAll();
        return entity.stream()
            .map(aux -> modelMapper.map(aux, RolModel.class))
            .collect(Collectors.toList());
    }

    @Override
    public void deleteRol(Long id) {
        if (rolRepository.existsById(id)) {
            rolRepository.deleteById(id);
        } else {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, 
                "Rol no encontrada para eliminar."
            );
        }
    }
}
