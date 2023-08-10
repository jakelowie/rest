package com.example.RestAPI.service;

import com.example.RestAPI.dao.Campus;
import com.example.RestAPI.dao.Response;
import org.springframework.stereotype.Service;

@Service
public interface CampusService {
    Response insertCampus(Campus campus);
    Response updateCampus(Campus campus);
    Response lookupCampus(long campus_id);
    Response lookupAllCampus();
    Response deleteCampus(long campus_id);
}
