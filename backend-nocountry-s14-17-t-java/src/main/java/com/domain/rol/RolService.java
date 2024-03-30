package com.domain.rol;

import java.util.List;
import com.dto.RolModel;

public interface RolService {

    RolModel createRol(RolModel rolModel);
    RolModel updateRol(Long rolId, RolModel rolModel);

    RolModel getRolById(Long id);
    List<RolModel> getAllRols();

    void deleteRol(Long rolId);
}
