package io.quarkus.panache.json;

public @interface Relation {

    String name();

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
    JpaIntegration jpaIntegration() default JpaIntegration.READ_ONLY;


    /**
     * Any fields of relations that should be renamed in the resulting JSON
     */
    Rename[] renames() default {};

    /**
     * Relations are considered read only by default. This means that the id can be changed to reference a new entity,
     * however the entity itself that is referenced cannot be changed.
     *
     * This only
     */
    boolean allowEntityModification() default false;

    /**
     * If this is true then the corresponding view must only have a single property to be serialized.
     *
     * Setting this to true will result in the property being serialized directly in the parent object without
     * an enclosing JSON object.
     *
     */
    boolean simpleValue() default false;

    /**
     * If this is true then the relation will only be serialized, and will be ignored when deserializing.
     */
    boolean readOnly() default false;

}
