package com.cloudsource.realmmigration;

import io.realm.RealmObject;
import io.realm.annotations.Required;

public class  test_chapter extends RealmObject {
    @Required
    private String idx;
    @Required
    private String name;
    @Required
    private String active;

    public String getIdx() { return idx; }

    public void setIdx(String idx) { this.idx = idx; } 

    public String getName() { return name; }

    public void setName(String name) { this.name = name; } 

    public String getActive() { return active; }

    public void setActive(String active) { this.active = active; } 

}
