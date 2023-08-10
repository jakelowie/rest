package com.example.RestAPI.serviceImpl;

import com.example.RestAPI.dao.Campus;
import com.example.RestAPI.dao.CampusFaculty;
import com.example.RestAPI.dao.Faculty;
import com.example.RestAPI.dao.Response;
import com.example.RestAPI.repository.CampusFacultyRepository;
import com.example.RestAPI.service.CampusFacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class CampusFacultyServiceImpl implements CampusFacultyService {
    @Autowired
    CampusFacultyRepository campusFacultyRepository;
    @Override
    public Response insertCampusFaculty(CampusFaculty campusFaculty) {
        Response response = new Response();
        Map data = new LinkedHashMap();
        int repositoryResponse = 0;
        repositoryResponse = campusFacultyRepository.insertCampusFacultyInDB(campusFaculty);
        if(repositoryResponse == 1){
            data.put("campusFaculty",campusFaculty);
            response.setData(data);
            response.setCode(200);
            response.setStatus("success");
        } else {
            data.put("campusFaculty",campusFaculty);
            response.setData(data);
            response.setCode(404);
            response.setStatus("error");
        }
        return response;
    }

    @Override
    public Response updateCampusFaculty(CampusFaculty campusFaculty) {
        Response response = new Response();
        Map data = new LinkedHashMap();
        int repositoryResponse = 0;
        repositoryResponse = campusFacultyRepository.updateCampusFacultyInDB(campusFaculty);
        if(repositoryResponse == 1){
            data.put("campusFaculty",campusFaculty);
            response.setData(data);
            response.setCode(200);
            response.setStatus("success");
        } else {
            data.put("campusFaculty",campusFaculty);
            response.setData(data);
            response.setCode(404);
            response.setStatus("error");
        }
        return response;
    }

    @Override
    public Response lookupFacultyCampuses(long faculty_id) {
        Response response = new Response();
        Map data = new LinkedHashMap();
        List<Campus> repositoryResponse;
        repositoryResponse = campusFacultyRepository.findFacultyCampuses(faculty_id);
        if(!repositoryResponse.isEmpty()){
            data.put("campuses",repositoryResponse);
            response.setData(data);
            response.setCode(200);
            response.setStatus("success");
        } else {
            data.put("campuses",null);
            response.setData(data);
            response.setCode(404);
            response.setStatus("error");
        }
        return response;
    }

    @Override
    public Response lookupCampusFaculties(long campus_id) {
        Response response = new Response();
        Map data = new LinkedHashMap();
        List<Faculty> repositoryResponse;
        repositoryResponse = campusFacultyRepository.findCampusFaculties(campus_id);
        if(!repositoryResponse.isEmpty()){
            data.put("faculties",repositoryResponse);
            response.setData(data);
            response.setCode(200);
            response.setStatus("success");
        } else {
            data.put("faculties",null);
            response.setData(data);
            response.setCode(404);
            response.setStatus("error");
        }
        return response;
    }

    @Override
    public Response lookupAllCampusFaculty() {
        Response response = new Response();
        Map data = new LinkedHashMap();
        List<CampusFaculty> repositoryResponse;
        repositoryResponse = campusFacultyRepository.findAll();
        if(!repositoryResponse.isEmpty()){
            data.put("campus",repositoryResponse);
            response.setData(data);
            response.setCode(200);
            response.setStatus("success");
        } else {
            data.put("campus",null);
            response.setData(data);
            response.setCode(404);
            response.setStatus("error");
        }
        return response;
    }

    @Override
    public Response deleteCampusFaculty(long campus_faculty_id) {
        Response response = new Response();
        Map data = new LinkedHashMap();
        Boolean repositoryResponse;
        repositoryResponse = campusFacultyRepository.deleteCampusFacultyInDB(campus_faculty_id);
        if(repositoryResponse){
            data.put("message","Successfully deleted record.");
            response.setData(data);
            response.setCode(200);
            response.setStatus("success");
        } else {
            data.put("message","Failed to delete record.");
            response.setData(data);
            response.setCode(404);
            response.setStatus("error");
        }
        return response;
    }
}
