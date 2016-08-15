package com.cloudsource.realmmigration;

import io.realm.RealmObject;
import io.realm.annotations.Required;

public class tbl_constitution extends RealmObject {
    @Required
    private String idx;
    @Required
    private String chapter;
    @Required
    private String detail;
    @Required
    private String active;

    public String getIdx() { return idx; }

    public void setIdx(String idx) { this.idx = idx; } 

    public String getChapter() { return chapter; }

    public void setChapter(String chapter) { this.chapter = chapter; } 

    public String getDetail() { return detail; }

    public void setDetail(String detail) { this.detail = detail; } 

    public String getActive() { return active; }

    public void setActive(String active) { this.active = active; } 

}
