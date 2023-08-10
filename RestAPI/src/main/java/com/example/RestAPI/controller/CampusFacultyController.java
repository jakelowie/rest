package com.example.RestAPI.controller;

import com.example.RestAPI.dao.Campus;
import com.example.RestAPI.dao.CampusFaculty;
import com.example.RestAPI.dao.Response;
import com.example.RestAPI.service.CampusFacultyService;
import com.example.RestAPI.service.CampusService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class CampusFacultyController {
    private static final Logger logger = LoggerFactory.getLogger(RestController.class);

    @Autowired
    CampusFacultyService campusFacultyService;

    @RequestMapping(value = "insert/campus/faculty", method = RequestMethod.POST)
    @ResponseBody
    @CrossOrigin(origins = "*")
    public Response insertCampusFaculty(@RequestBody CampusFaculty campusFaculty) {
        return campusFacultyService.insertCampusFaculty(campusFaculty);
    }

    @RequestMapping(value = "update/campus/faculty", method = RequestMethod.PUT)
    @ResponseBody
    @CrossOrigin(origins = "*")
    public Response updateCampusFaculty(@RequestBody CampusFaculty campusFaculty) {
        return campusFacultyService.updateCampusFaculty(campusFaculty);
    }

    @RequestMapping(value = "lookup/faculty/campuses", method = RequestMethod.GET)
    @ResponseBody
    @CrossOrigin(origins = "*")
    public Response lookupFacultyCampuses(@RequestParam long faculty_id) {
        return campusFacultyService.lookupFacultyCampuses(faculty_id);
    }

    @RequestMapping(value = "lookup/campus/faculties", method = RequestMethod.GET)
    @ResponseBody
    @CrossOrigin(origins = "*")
    public Response lookupCampusFaculties(@RequestParam long campus_id) {
        return campusFacultyService.lookupCampusFaculties(campus_id);
    }

    @RequestMapping(value = "lookup/all/campus/faculty", method = RequestMethod.GET)
    @ResponseBody
    @CrossOrigin(origins = "*")
    public Response lookupAllCampusFaculty() {
        return campusFacultyService.lookupAllCampusFaculty();
    }

    @RequestMapping(value = "delete/campus/faculty", method = RequestMethod.DELETE)
    @ResponseBody
    @CrossOrigin(origins = "*")
    public Response deleteCampusFaculty(@RequestParam long campus_faculty_id) {
        return campusFacultyService.deleteCampusFaculty(campus_faculty_id);
    }
}
