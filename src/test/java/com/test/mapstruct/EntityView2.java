package com.test.mapstruct;

import java.util.List;

import com.test.Entity2;

public class EntityView2 {

    public Long id;
    public int keepMe;
    public List<EntityView2> betterName;
    public List<IdAndKeepMe> relation;
    public long idOnlyRelation;
    public int newProperty;
    public OtherRelationView otherRelation;
    public List<Entity2> selectionBoxList;

    public String getNewProperty2() {
        return "foo";
    }
}
