package com.example.RestAPI.controller;

import com.example.RestAPI.dao.Campus;
import com.example.RestAPI.dao.Faculty;
import com.example.RestAPI.dao.Response;
import com.example.RestAPI.service.CampusService;
import com.example.RestAPI.service.FacultyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class CampusController {
    private static final Logger logger = LoggerFactory.getLogger(RestController.class);

    @Autowired
    CampusService campusService;

    @RequestMapping(value = "insert/campus", method = RequestMethod.POST)
    @ResponseBody
    @CrossOrigin(origins = "*")
    public Response insertCampus(@RequestBody Campus campus) {
        return campusService.insertCampus(campus);
    }

    @RequestMapping(value = "update/campus", method = RequestMethod.PUT)
    @ResponseBody
    @CrossOrigin(origins = "*")
    public Response updateCampus(@RequestBody Campus campus) {
        return campusService.updateCampus(campus);
    }

    @RequestMapping(value = "lookup/campus", method = RequestMethod.GET)
    @ResponseBody
    @CrossOrigin(origins = "*")
    public Response lookupCampus(@RequestParam long campus_id) {
        return campusService.lookupCampus(campus_id);
    }

    @RequestMapping(value = "lookup/all/campus", method = RequestMethod.GET)
    @ResponseBody
    @CrossOrigin(origins = "*")
    public Response lookupAllCampus() {
        return campusService.lookupAllCampus();
    }

    @RequestMapping(value = "delete/campus", method = RequestMethod.DELETE)
    @ResponseBody
    @CrossOrigin(origins = "*")
    public Response deleteCampus(@RequestParam long campus_id) {
        return campusService.deleteCampus(campus_id);
    }
}
