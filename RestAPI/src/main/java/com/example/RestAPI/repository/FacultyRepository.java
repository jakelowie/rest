package com.example.RestAPI.repository;

import com.example.RestAPI.controller.RestController;
import com.example.RestAPI.dao.Faculty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class FacultyRepository {
    private static final Logger logger = LoggerFactory.getLogger(FacultyRepository.class);
    @Autowired
    JdbcTemplate jdbcTemplate;

    private Faculty mapRowToFaculty(ResultSet resultSet, int rowNum) throws SQLException {
        return Faculty.builder()
                .faculty_id(resultSet.getLong("faculty_id"))
                .faculty_name(resultSet.getString("faculty_name"))
                .faculty_phone_number(resultSet.getString("faculty_phone_number"))
                .faculty_address(resultSet.getString("faculty_address"))
                .faculty_email(resultSet.getString("faculty_email"))
                .build();
    }

    public int insertFacultyInDB(Faculty faculty) {
        logger.info("Saving faculty with values {}, {}, {} ,{}", faculty.getFaculty_name(),faculty.getFaculty_address(),faculty.getFaculty_email(),faculty.getFaculty_phone_number());

        String sqlQuery = "INSERT INTO public.faculty(faculty_name, faculty_address, faculty_phone_number, faculty_email) VALUES (?, ?, ?, ?)";
        return jdbcTemplate.update(sqlQuery,
                faculty.getFaculty_name(),
                faculty.getFaculty_address(),
                faculty.getFaculty_phone_number(),
                faculty.getFaculty_email());
    }

    public int updateFacultyInDB(Faculty faculty) {
        logger.info("Saving faculty with values {}, {}, {}, {} ,{}", faculty.getFaculty_id(), faculty.getFaculty_name(),faculty.getFaculty_address(),faculty.getFaculty_email(),faculty.getFaculty_phone_number());

        String sqlQuery = "UPDATE public.faculty " +
                "SET faculty_name=?, faculty_address=?, faculty_phone_number=?, faculty_email=? " +
                "WHERE faculty_id=?";
        return jdbcTemplate.update(sqlQuery,
                faculty.getFaculty_name(),
                faculty.getFaculty_address(),
                faculty.getFaculty_phone_number(),
                faculty.getFaculty_email(),
                faculty.getFaculty_id());
    }

    public Faculty findOne(long faculty_id) {
        logger.info("Running lookup with id {}", faculty_id);
        String sqlQuery = "select * from public.faculty where faculty_id = ?";
        return jdbcTemplate.queryForObject(sqlQuery, this::mapRowToFaculty, faculty_id);
    }

    public List<Faculty> findAll() {
        String sqlQuery = "select * from public.faculty";
        return jdbcTemplate.query(sqlQuery, this::mapRowToFaculty);
    }

    public boolean deleteFacultyInDB(long faculty_id) {
        logger.info("Delete faculty with id {}", faculty_id);
        String sqlQuery = "delete from public.faculty where faculty_id = ?";
        return jdbcTemplate.update(sqlQuery, faculty_id) > 0;
    }
}
