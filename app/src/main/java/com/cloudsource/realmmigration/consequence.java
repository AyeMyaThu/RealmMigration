package com.cloudsource.realmmigration;

import io.realm.RealmObject;
import io.realm.annotations.Required;

public class consequence extends RealmObject {
    @Required
    private String name;
    @Required
    private String seq;

    public String getName() { return name; }

    public void setName(String name) { this.name = name; } 

    public String getSeq() { return seq; }

    public void setSeq(String seq) { this.seq = seq; } 

}
