package com.example.RestAPI.serviceImpl;

import com.example.RestAPI.dao.Campus;
import com.example.RestAPI.dao.Faculty;
import com.example.RestAPI.dao.Response;
import com.example.RestAPI.repository.CampusRepository;
import com.example.RestAPI.service.CampusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
@Service
public class CampusServiceImpl implements CampusService {
    @Autowired
    CampusRepository campusRepository;
    @Override
    public Response insertCampus(Campus campus) {
        Response response = new Response();
        Map data = new LinkedHashMap();
        int repositoryResponse = 0;
        repositoryResponse = campusRepository.insertCampusInDB(campus);
        if(repositoryResponse == 1){
            data.put("campus",campus);
            response.setData(data);
            response.setCode(200);
            response.setStatus("success");
        } else {
            data.put("campus",campus);
            response.setData(data);
            response.setCode(404);
            response.setStatus("error");
        }
        return response;
    }

    @Override
    public Response updateCampus(Campus campus) {
        Response response = new Response();
        Map data = new LinkedHashMap();
        int repositoryResponse = 0;
        repositoryResponse = campusRepository.updateCampusInDB(campus);
        if(repositoryResponse == 1){
            data.put("campus",campus);
            response.setData(data);
            response.setCode(200);
            response.setStatus("success");
        } else {
            data.put("campus",campus);
            response.setData(data);
            response.setCode(404);
            response.setStatus("error");
        }
        return response;
    }

    @Override
    public Response lookupCampus(long campus_id) {
        Response response = new Response();
        Map data = new LinkedHashMap();
        Campus repositoryResponse;
        repositoryResponse = campusRepository.findOne(campus_id);
        if(repositoryResponse.getCampus_name() != null){
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
    public Response lookupAllCampus() {
        Response response = new Response();
        Map data = new LinkedHashMap();
        List<Campus> repositoryResponse;
        repositoryResponse = campusRepository.findAll();
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
    public Response deleteCampus(long campus_id) {
        Response response = new Response();
        Map data = new LinkedHashMap();
        Boolean repositoryResponse;
        repositoryResponse = campusRepository.deleteCampusInDB(campus_id);
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
