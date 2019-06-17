package io.quarkus.panache.json;

public enum JpaIntegration {
    /**
     * This object will always just be constructed via the default constructor as part of the deserialization process
     */
    NONE,

    /**
     * When this object is deserialized it will be loaded from the EntityManager based on the provided id. Even if
     * additional fields are present they will not be deserialized.
     * <p>
     * This allows you to set a relation to a non-detached entity, without accidently modifying the entity.
     */
    READ_ONLY,

    /**
     * When this object is deserialized it will be loaded from the EntityManager based on the provided id. It will then
     * be deserialized as normal, allowing this linked entity to be modified by the provided JSON.
     */
    READ_WRITE
}
