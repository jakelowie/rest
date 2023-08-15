package com.example.RestAPI.dao;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class Campus {
    private long campus_id;
    private String campus_name;
    private String campus_address;
    private String campus_phone_number;
    private String campus_email;

    public long getCampus_id() {
        return campus_id;
    }

    public void setCampus_id(long campus_id) {
        this.campus_id = campus_id;
    }

    public String getCampus_name() {
        return campus_name;
    }

    public void setCampus_name(String campus_name) {
        this.campus_name = campus_name;
    }

    public String getCampus_address() {
        return campus_address;
    }

    public void setCampus_address(String campus_address) {
        this.campus_address = campus_address;
    }

    public String getCampus_phone_number() {
        return campus_phone_number;
    }

    public void setCampus_phone_number(String campus_phone_number) {
        this.campus_phone_number = campus_phone_number;
    }

    public String getCampus_email() {
        return campus_email;
    }

    public void setCampus_email(String campus_email) {
        this.campus_email = campus_email;
    }
}
