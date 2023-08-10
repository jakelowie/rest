package com.example.RestAPI.serviceImpl;

import com.example.RestAPI.dao.Faculty;
import com.example.RestAPI.dao.Response;
import com.example.RestAPI.repository.FacultyRepository;
import com.example.RestAPI.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class FacultyServiceImpl implements FacultyService {
    @Autowired
    FacultyRepository facultyRepository;

    @Override
    public Response insertFaculty(Faculty faculty) {
        Response response = new Response();
        Map data = new LinkedHashMap();
        int repositoryResponse = 0;
        repositoryResponse = facultyRepository.insertFacultyInDB(faculty);
        if(repositoryResponse == 1){
            data.put("faculty",faculty);
            response.setData(data);
            response.setCode(200);
            response.setStatus("success");
        } else {
            data.put("faculty",faculty);
            response.setData(data);
            response.setCode(404);
            response.setStatus("error");
        }
        return response;
    }

    @Override
    public Response updateFaculty(Faculty faculty) {
        Response response = new Response();
        Map data = new LinkedHashMap();
        int repositoryResponse = 0;
        repositoryResponse = facultyRepository.updateFacultyInDB(faculty);
        if(repositoryResponse == 1){
            data.put("faculty",faculty);
            response.setData(data);
            response.setCode(200);
            response.setStatus("success");
        } else {
            data.put("faculty",faculty);
            response.setData(data);
            response.setCode(404);
            response.setStatus("error");
        }
        return response;
    }

    @Override
    public Response lookupFaculty(long faculty_id) {
        Response response = new Response();
        Map data = new LinkedHashMap();
        Faculty repositoryResponse;
        repositoryResponse = facultyRepository.findOne(faculty_id);
        if(repositoryResponse.getFaculty_name() != null){
            data.put("faculty",repositoryResponse);
            response.setData(data);
            response.setCode(200);
            response.setStatus("success");
        } else {
            data.put("faculty",null);
            response.setData(data);
            response.setCode(404);
            response.setStatus("error");
        }
        return response;
    }

    @Override
    public Response lookupAllFaculty() {
        Response response = new Response();
        Map data = new LinkedHashMap();
        List<Faculty> repositoryResponse;
        repositoryResponse = facultyRepository.findAll();
        if(!repositoryResponse.isEmpty()){
            data.put("faculty",repositoryResponse);
            response.setData(data);
            response.setCode(200);
            response.setStatus("success");
        } else {
            data.put("faculty",null);
            response.setData(data);
            response.setCode(404);
            response.setStatus("error");
        }
        return response;
    }

    @Override
    public Response deleteFaculty(long faculty_id) {
        Response response = new Response();
        Map data = new LinkedHashMap();
        Boolean repositoryResponse;
        repositoryResponse = facultyRepository.deleteFacultyInDB(faculty_id);
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
