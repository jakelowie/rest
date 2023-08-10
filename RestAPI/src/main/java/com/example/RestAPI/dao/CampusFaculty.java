package com.example.RestAPI.dao;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class CampusFaculty {
    private long cf_id;
    private int campus_id;
    private int faculty_id;
    private String added_date;
    private String update_date;
    private boolean is_active;

    public long getCf_id() {
        return cf_id;
    }

    public void setCf_id(long cf_id) {
        this.cf_id = cf_id;
    }

    public int getCampus_id() {
        return campus_id;
    }

    public void setCampus_id(int campus_id) {
        this.campus_id = campus_id;
    }

    public int getFaculty_id() {
        return faculty_id;
    }

    public void setFaculty_id(int faculty_id) {
        this.faculty_id = faculty_id;
    }

    public String getAdded_date() {
        return added_date;
    }

    public void setAdded_date(String added_date) {
        this.added_date = added_date;
    }

    public String getUpdate_date() {
        return update_date;
    }

    public void setUpdate_date(String update_date) {
        this.update_date = update_date;
    }

    public boolean isIs_active() {
        return is_active;
    }

    public void setIs_active(boolean is_active) {
        this.is_active = is_active;
    }
}
