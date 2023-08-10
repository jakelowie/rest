package com.example.RestAPI.controller;

import com.example.RestAPI.dao.Faculty;
import com.example.RestAPI.dao.Response;
import com.example.RestAPI.service.FacultyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin
public class FacultyController {
    private static final Logger logger = LoggerFactory.getLogger(RestController.class);

    @Autowired
    FacultyService facultyService;

    @RequestMapping(value = "insert/faculty", method = RequestMethod.POST)
    @ResponseBody
    @CrossOrigin(origins = "*")
    public Response insertFaculty(@RequestBody Faculty faculty) {
        return facultyService.insertFaculty(faculty);
    }

    @RequestMapping(value = "update/faculty", method = RequestMethod.PUT)
    @ResponseBody
    @CrossOrigin(origins = "*")
    public Response updateFaculty(@RequestBody Faculty faculty) {
        return facultyService.updateFaculty(faculty);
    }

    @RequestMapping(value = "lookup/faculty", method = RequestMethod.GET)
    @ResponseBody
    @CrossOrigin(origins = "*")
    public Response lookupFaculty(@RequestParam long faculty_id) {
        return facultyService.lookupFaculty(faculty_id);
    }

    @RequestMapping(value = "lookup/all/faculty", method = RequestMethod.GET)
    @ResponseBody
    @CrossOrigin(origins = "*")
    public Response lookupAllFaculty() {
        return facultyService.lookupAllFaculty();
    }

    @RequestMapping(value = "delete/faculty", method = RequestMethod.DELETE)
    @ResponseBody
    @CrossOrigin(origins = "*")
    public Response deleteFaculty(@RequestParam long faculty_id) {
        return facultyService.deleteFaculty(faculty_id);
    }
}
