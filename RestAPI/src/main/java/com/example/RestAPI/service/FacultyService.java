package com.example.RestAPI.service;

import com.example.RestAPI.dao.Faculty;
import com.example.RestAPI.dao.Response;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public interface FacultyService {
    Response insertFaculty(Faculty faculty);
    Response updateFaculty(Faculty faculty);
    Response lookupFaculty(long faculty_id);
    Response lookupAllFaculty();
    Response deleteFaculty(long faculty_id);

}
