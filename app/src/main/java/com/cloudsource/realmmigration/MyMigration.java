package com.cloudsource.realmmigration;

import io.realm.DynamicRealm;
import io.realm.FieldAttribute;
import io.realm.RealmMigration;
import io.realm.RealmSchema;

/**
 * Created by ayemyathu on 8/15/16.
 */
public class MyMigration implements RealmMigration {
    @Override
    public void migrate(DynamicRealm realm, long oldVersion, long newVersion) {
        RealmSchema schema = realm.getSchema();

        if (oldVersion == 0) {
            schema.create("constitution")
                    .addField("id", String.class)
                    .addField("chapter", String.class)
                    .addField("detail", String.class)
                    .addField("active", String.class);
            oldVersion++;
        }
        if (oldVersion == 1) {
            schema.create("contact")
                    .addField("id", String.class)
                    .addField("title", String.class)
                    .addField("address", String.class)
                    .addField("website", String.class)
                    .addField("active", String.class);
            oldVersion++;
        }

        if (oldVersion == 2){

                schema.get("Join")
                        .addField("id", long.class, FieldAttribute.PRIMARY_KEY)
                        .addRealmObjectField("constitution", schema.get("constitution"))
                        .addRealmListField("dogs", schema.get("Dog"));
                oldVersion++;

        }
    }
}
