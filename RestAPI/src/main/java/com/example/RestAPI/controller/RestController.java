package com.example.RestAPI.controller;

import com.example.RestAPI.dao.Response;
import com.example.RestAPI.service.FacultyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class RestController {
    private static final Logger logger = LoggerFactory.getLogger(RestController.class);

    @RequestMapping(value = "health", method = RequestMethod.GET)
    @ResponseBody
    @CrossOrigin(origins = "*")
    public String healthCheck() {
        logger.info("Entering Health Check ... ");
        return "Running in local";
    }
}
