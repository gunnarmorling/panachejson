package com.test;

import java.util.List;

import io.quarkus.panache.json.JpaIntegration;
import io.quarkus.panache.json.NestledRelation;
import io.quarkus.panache.json.Relation;
import io.quarkus.panache.json.Rename;
import io.quarkus.panache.json.SerializedView;
import io.quarkus.panache.json.ViewDescription;

@ViewDescription(exclude = {"removeMe"},
        //renames are a common use case, we support this directly
        renames = @Rename(oldName = "renameMe", newName = "betterName"),
        //if we are only going one relationship deep and don't need any advanced features then we can just use @Relation
        //this is also a very common use case
        relations = {
                //this just encoded the id and keepMe fields of relation
                //it does not matter that this is a collection type, it is handled automatically
                @Relation(name = "relation", include = {"id", "keepMe"}),
                //this will just encode the 'id' field without an enclosing object under the name 'idOnlyRelation'
                @Relation(name = "idOnlyRelation", include = "id", simpleValue = true),
                //this is an additional list that is specific to the view
                //this is basically 'extra data', e.g. to render a drop down list so that multiple HTTP requests
                //are not required
                //as this is readOnly it will never be deserialized, it is just a convenient way of providing extra data
                //to the view
                @Relation(name = "selectionBoxList", readOnly = true)
        },
        nestledRelations = {
                //self referential, we serialize this relation using the same rules allowing for tree like structures
                @NestledRelation(name = "renameMe", type = EntityView2.class, jpaIntegration = JpaIntegration.READ_WRITE),
                //we want to add an extra label field here, so we need a new view type
                //as the JPA integration is none this will not be a managed entity when it is deserialized
                @NestledRelation(name = "otherRelation", type = EntityView2.OtherRelationView.class, jpaIntegration = JpaIntegration.NONE)
        }
)
public class EntityView2 extends SerializedView<Entity> {

    // add a new property
    public int newProperty;

    //this is some extra data that we want to include in the GET request to reduce the number of HTTP
    //requests needed to load the page
    private List<Entity2> selectionBoxList;

    // required constructor
    public EntityView2(Entity entity) {
        super(entity);
        // only new properties need to be initialised
        newProperty = entity.keepMe + 2;
        this.selectionBoxList = selectionBoxList;
    }

    // new dynamic property
    public String getNewProperty2() {
        return "foo";
    }

    public List<Entity2> getSelectionBoxList() {
        return selectionBoxList;
    }

    public EntityView2 setSelectionBoxList(List<Entity2> selectionBoxList) {
        this.selectionBoxList = selectionBoxList;
        return this;
    }

    @ViewDescription
    public class OtherRelationView extends SerializedView<Entity2> {

        public OtherRelationView(Entity2 value) {
            super(value);
        }

        public String getLabel() {
            return "LABEL: " + get().name;
        }
    }
}