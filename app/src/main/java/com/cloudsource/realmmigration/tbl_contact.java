package com.cloudsource.realmmigration;

import io.realm.RealmObject;
import io.realm.annotations.Required;

public class tbl_contact extends RealmObject {
    @Required
    private String idx;
    @Required
    private String uniq_idx;
    @Required
    private String title;
    @Required
    private String address;
    @Required
    private String website;
    @Required
    private String active;

    public String getIdx() { return idx; }

    public void setIdx(String idx) { this.idx = idx; } 

    public String getUniq_Idx() { return uniq_idx; }

    public void setUniq_Idx(String uniq_idx) { this.uniq_idx = uniq_idx; } 

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; } 

    public String getAddress() { return address; }

    public void setAddress(String address) { this.address = address; } 

    public String getWebsite() { return website; }

    public void setWebsite(String website) { this.website = website; } 

    public String getActive() { return active; }

    public void setActive(String active) { this.active = active; } 

}
