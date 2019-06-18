package com.test.mapstruct;

import java.util.List;

import com.test.Entity;
import com.test.Entity2;

public class MyService {

    @Inject
    MyMapper mapper;

    public EntityView2 getEntity(long id) {
        Entity entity = loadEntity(id);
        List<Entity2> selectionBoxList;
        return mapper.entityToView2(entity, selectionBoxList);
    }

    private Entity loadEntity(long id) {
        // TODO implement
        return null;
    }
}
