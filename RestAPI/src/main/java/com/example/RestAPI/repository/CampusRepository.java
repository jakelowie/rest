package com.example.RestAPI.repository;

import com.example.RestAPI.dao.Campus;
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
public class CampusRepository {
    private static final Logger logger = LoggerFactory.getLogger(FacultyRepository.class);
    @Autowired
    JdbcTemplate jdbcTemplate;

    private Campus mapRowToCampus(ResultSet resultSet, int rowNum) throws SQLException {
        return Campus.builder()
                .campus_id(resultSet.getLong("campus_id"))
                .campus_name(resultSet.getString("campus_name"))
                .campus_phone_number(resultSet.getString("campus_phone_number"))
                .campus_address(resultSet.getString("campus_address"))
                .campus_email(resultSet.getString("campus_email"))
                .build();
    }

    public int insertCampusInDB(Campus campus) {
        String sqlQuery = "INSERT INTO public.campus(\n" +
                "\tcampus_name, campus_address, campus_phone_number, campus_email)\n" +
                "\tVALUES (?, ?, ?, ?);";
        return jdbcTemplate.update(sqlQuery,
                campus.getCampus_name(),
                campus.getCampus_address(),
                campus.getCampus_phone_number(),
                campus.getCampus_email());
    }

    public int updateCampusInDB(Campus campus) {
        String sqlQuery = "UPDATE public.campus\n" +
                "\tSET campus_name=?, campus_address=?, campus_phone_number=?, campus_email=?\n" +
                "\tWHERE campus_id=?";
        return jdbcTemplate.update(sqlQuery,
                campus.getCampus_name(),
                campus.getCampus_address(),
                campus.getCampus_phone_number(),
                campus.getCampus_email(),
                campus.getCampus_id());
    }

    public Campus findOne(long campus_id) {
        String sqlQuery = "select * from public.campus where campus_id = ?";
        return jdbcTemplate.queryForObject(sqlQuery, this::mapRowToCampus, campus_id);
    }

    public List<Campus> findAll() {
        String sqlQuery = "select * from public.campus";
        return jdbcTemplate.query(sqlQuery, this::mapRowToCampus);
    }

    public boolean deleteCampusInDB(long campus_id) {
        logger.info("Delete faculty with id {}", campus_id);
        String sqlQuery = "delete from public.campus where campus_id = ?";
        return jdbcTemplate.update(sqlQuery, campus_id) > 0;
    }
}
