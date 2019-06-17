package com.test;

import io.quarkus.panache.json.SerializedView;
import io.quarkus.panache.json.ViewDescription;

@ViewDescription(include = {"id"}, simpleValue = true)
public class EntityView extends SerializedView<Entity> {
    public EntityView(Entity value) {
        super(value);
    }
}
