package io.quarkus.panache.json;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface NestledRelation {

    String name();

    Class<? extends SerializedView> type();

    /**
     * overrides the value in {@link ViewDescription#jpaIntegration()}
     */
    JpaIntegration jpaIntegration() default JpaIntegration.READ_ONLY;

    /**
     * If this is true then the relation will only be serialized, and will be ignored when deserializing.
     */
    boolean readOnly() default false;
}
