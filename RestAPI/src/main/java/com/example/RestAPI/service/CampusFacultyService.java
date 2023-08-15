package com.example.RestAPI.service;

import com.example.RestAPI.dao.CampusFaculty;
import com.example.RestAPI.dao.Response;
import org.springframework.stereotype.Service;

@Service
public interface CampusFacultyService {
    Response insertCampusFaculty(CampusFaculty campusFaculty);
    Response updateCampusFaculty(CampusFaculty campusFaculty);
    Response lookupFacultyCampuses(long faculty_id);
    Response lookupCampusFaculties(long campus_id);
    Response lookFacultiesNotInCampus(long campus_id);
    Response lookupAllCampusFaculty();
    Response deleteCampusFaculty(long campus_faculty_id);
}
