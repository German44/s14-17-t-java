package com.domain.groups;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import com.dto.GroupsModel;
import com.domain.groups.Groups;
import com.domain.groups.GroupsRepository;
import com.domain.groups.GroupsService;

@Service
public class GroupsServiceImpl implements GroupsService{

    private final ModelMapper modelMapper;
    private final GroupsRepository groupsRepository;

    public GroupsServiceImpl(
        ModelMapper modelMapper,
        GroupsRepository groupsRepository
    ) {
        this.modelMapper = modelMapper;
        this.groupsRepository = groupsRepository;
    }

    @Transactional
    @Override
    public GroupsModel createGroups(GroupsModel groupsModel) {
        
        Groups groups = modelMapper.map(groupsModel, Groups.class);
        groups = groupsRepository.save(groups);
        groupsModel.setId(groups.getId());
        return modelMapper.map(groups, GroupsModel.class);
    }

    @Transactional
    @Override
    public GroupsModel updateGroups(Long id, GroupsModel groupsModel) {

        if (groupsRepository.existsById(id)) {
            Groups groupsActualizado = modelMapper.map(groupsModel, Groups.class);
            groupsRepository.save(groupsActualizado);
            return groupsModel;
        }
        throw new ResponseStatusException(
            HttpStatus.NOT_FOUND,
            "Groups no encontrado para actualizar."
        );
    }

    @Override
    public GroupsModel getGroupsById(Long id) {

        Groups groups = groupsRepository.findById(id).orElse(null);
        if (groups == null) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "Groups no encontrado."
            );
        }
        return modelMapper.map(groups, GroupsModel.class);
    }

    @Override
    public List<GroupsModel> getAllGroups() {

        List<Groups> entity = groupsRepository.findAll();
        return entity.stream()
            .map(aux -> modelMapper.map(aux, GroupsModel.class))
            .collect(Collectors.toList());
    }

    @Override
    public void deleteGroups(Long id) {
        if (groupsRepository.existsById(id)) {
            groupsRepository.deleteById(id);
        } else {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "Groups no encontrada para eliminar."
            );
        }
    }
}
