package com.example.RestAPI.dao;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIgnoreType;
import lombok.*;

@Builder
@Getter
@Setter
public class Faculty {
    private long faculty_id;
    private String faculty_name;
    private String faculty_address;
    private String faculty_phone_number;
    private String faculty_email;

    public long getFaculty_id() {
        return faculty_id;
    }

    public void setFaculty_id(long faculty_id) {
        this.faculty_id = faculty_id;
    }

    public String getFaculty_name() {
        return faculty_name;
    }

    public void setFaculty_name(String faculty_name) {
        this.faculty_name = faculty_name;
    }

    public String getFaculty_address() {
        return faculty_address;
    }

    public void setFaculty_address(String faculty_address) {
        this.faculty_address = faculty_address;
    }

    public String getFaculty_phone_number() {
        return faculty_phone_number;
    }

    public void setFaculty_phone_number(String faculty_phone_number) {
        this.faculty_phone_number = faculty_phone_number;
    }

    public String getFaculty_email() {
        return faculty_email;
    }

    public void setFaculty_email(String faculty_email) {
        this.faculty_email = faculty_email;
    }
}
