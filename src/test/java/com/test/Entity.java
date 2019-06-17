package com.test;

import java.util.List;

public class Entity {
    public Long id;
    public int keepMe;
    public String removeMe;
    public List<Entity> renameMe;
    public List<Entity> relation;
    public Entity2 otherRelation;
    public Entity2 idOnlyRelation;
}