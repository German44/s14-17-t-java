package com.domain.fields;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import com.dto.fieldsModel;
import com.domain.fields.fields;
import com.domain.fields.fieldsRepository;
import com.domain.fields.fieldsService;

@Service
public class fieldsServiceImpl implements fieldsService{

    private final ModelMapper modelMapper;
    private final fieldsRepository fieldsRepository;

    public fieldsServiceImpl(
        ModelMapper modelMapper,
        fieldsRepository fieldsRepository
    ) {
        this.modelMapper = modelMapper;
        this.fieldsRepository = fieldsRepository;
    }

    @Transactional
    @Override
    public fieldsModel createfields(fieldsModel fieldsModel) {
        
        fields fields = modelMapper.map(fieldsModel, fields.class);
        fields = fieldsRepository.save(fields);
        fieldsModel.setId(fields.getId());
        return modelMapper.map(fields, fieldsModel.class);
    }

    @Transactional
    @Override
    public fieldsModel updatefields(Long id, fieldsModel fieldsModel) {

        if (fieldsRepository.existsById(id)) {
            fields fieldsActualizado = modelMapper.map(fieldsModel, fields.class);
            fieldsRepository.save(fieldsActualizado);
            return fieldsModel;
        }
        throw new ResponseStatusException(
            HttpStatus.NOT_FOUND,
            "fields no encontrado para actualizar."
        );
    }

    @Override
    public fieldsModel getfieldsById(Long id) {

        fields fields = fieldsRepository.findById(id).orElse(null);
        if (fields == null) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "fields no encontrado."
            );
        }
        return modelMapper.map(fields, fieldsModel.class);
    }

    @Override
    public List<fieldsModel> getAllfields() {

        List<fields> entity = fieldsRepository.findAll();
        return entity.stream()
            .map(aux -> modelMapper.map(aux, fieldsModel.class))
            .collect(Collectors.toList());
    }

    @Override
    public void deletefields(Long id) {
        if (fieldsRepository.existsById(id)) {
            fieldsRepository.deleteById(id);
        } else {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "fields no encontrada para eliminar."
            );
        }
    }
}
