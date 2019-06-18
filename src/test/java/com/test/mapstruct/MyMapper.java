package com.test.mapstruct;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.TargetType;

import com.test.Entity;
import com.test.Entity2;

@Mapper
public interface MyMapper {

    default long entityToLong(Entity entity) {
        return entity.id;
    }

    default int entity2ToLong(Entity2 entity) {
        return entity.id;
    }

    @Mapping(target="betterName", source="entity.renameMe")
    @Mapping(target="newProperty", expression="java(entity.keepMe + 2)")
    EntityView2 entityToView2(Entity entity, List<Entity2> selectionBoxList);

    IdAndKeepMe entityToIdAndKeepMe(Entity entity);

    @Mapping(target="label", expression="java(\"LABEL: \" + entity.name)")
    OtherRelationView entity2ToOtherRelationView(Entity2 entity);

    @Mapping(target="renameMe", source="betterName")
    Entity view2ToEntity(EntityView2 view);

    default Entity idAndKeepMeToEntity(IdAndKeepMe idAndKeepMe, @TargetType Class<?> targetType) {
        return null;
    }

    default Entity2 longToEntity2(long id, @TargetType Class<?> targetType) {
        return null;
    }
}
