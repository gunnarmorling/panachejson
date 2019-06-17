package io.quarkus.panache.json;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface ViewDescription {

    Relation[] relations() default {};

    NestledRelation[] nestledRelations() default {};

    /**
     * Simple fields to include. By default all fields are included. Must not be combined with {@link #exclude()}
     */
    String[] include() default {};

    /**
     * Simple fields to exclude. By default all fields are included. Must not be combined with {@link #include()} ()}
     */
    String[] exclude() default {};

    /**
     * If this is true and the relation target is an entity then the entity will be retrieved via EntityManager.find()
     * during deserialization. This means the end result will be a managed entity, and any fields that are not explicitly
     * set during deserialization will be set to the value retrieved from the database.
     *
     */
    JpaIntegration jpaIntegration() default JpaIntegration.READ_WRITE;


    /**
     * Any fields of relations that should be renamed in the resulting JSON
     */
    Rename[] renames() default {};

    /**
     * Relations are considered read only by default. This means that the id can be changed to reference a new entity,
     * however the entity itself that is referenced cannot be changed.
     *
     * If {@link #jpaIntegration()} is false then nothing can be changed
     */
    boolean readOnly() default true;

    /**
     * If this is true then the corresponding view must only have a single property to be serialized.
     *
     * Setting this to true will result in the property being serialized directly in the parent object without
     * an enclosing JSON object.
     *
     */
    boolean simpleValue() default false;

}
