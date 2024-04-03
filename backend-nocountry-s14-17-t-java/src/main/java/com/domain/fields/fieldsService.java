package com.domain.fields;

import java.util.List;
import com.dto.fieldsModel;

public interface fieldsService {

    fieldsModel createfields(fieldsModel fieldsModel);
    fieldsModel updatefields(Long fieldsId, fieldsModel fieldsModel);

    fieldsModel getfieldsById(Long id);
    List<fieldsModel> getAllfields();

    void deletefields(Long fieldsId);
}
