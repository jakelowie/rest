package com.example.RestAPI.repository;

import com.example.RestAPI.dao.Campus;
import com.example.RestAPI.dao.CampusFaculty;
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
public class CampusFacultyRepository {
    private static final Logger logger = LoggerFactory.getLogger(FacultyRepository.class);
    @Autowired
    JdbcTemplate jdbcTemplate;

    private CampusFaculty mapRowToCampusFaculty(ResultSet resultSet, int rowNum) throws SQLException {
        return CampusFaculty.builder()
                .cf_id(resultSet.getLong("cf_id"))
                .campus_id(resultSet.getInt("campus_id"))
                .faculty_id(resultSet.getInt("faculty_id"))
                .added_date(resultSet.getString("added_date"))
                .update_date(resultSet.getString("update_date"))
                .is_active(resultSet.getBoolean("is_active"))
                .build();
    }

    private Campus mapRowToCampus(ResultSet resultSet, int rowNum) throws SQLException {
        return Campus.builder()
                .campus_id(resultSet.getLong("campus_id"))
                .campus_name(resultSet.getString("campus_name"))
                .campus_phone_number(resultSet.getString("campus_phone_number"))
                .campus_address(resultSet.getString("campus_address"))
                .campus_email(resultSet.getString("campus_email"))
                .build();
    }

    private Faculty mapRowToFaculty(ResultSet resultSet, int rowNum) throws SQLException {
        return Faculty.builder()
                .faculty_id(resultSet.getLong("faculty_id"))
                .faculty_name(resultSet.getString("faculty_name"))
                .faculty_phone_number(resultSet.getString("faculty_phone_number"))
                .faculty_address(resultSet.getString("faculty_address"))
                .faculty_email(resultSet.getString("faculty_email"))
                .build();
    }

    public int insertCampusFacultyInDB(CampusFaculty campusFaculty) {
        String sqlQuery = "INSERT INTO public.campus_faculty(\n" +
                "\tcampus_id, faculty_id, added_date, is_active)\n" +
                "\tVALUES (?, ?, ?, ?);";
        return jdbcTemplate.update(sqlQuery,
                campusFaculty.getCampus_id(),
                campusFaculty.getFaculty_id(),
                campusFaculty.getAdded_date(),
                campusFaculty.isIs_active());
    }

    public int updateCampusFacultyInDB(CampusFaculty campusFaculty) {
        String sqlQuery = "UPDATE public.campus_faculty\n" +
                "\tSET campus_id=?, faculty_id=?, update_date=?, is_active=?\n" +
                "\tWHERE cf_id=?";
        return jdbcTemplate.update(sqlQuery,
                campusFaculty.getCampus_id(),
                campusFaculty.getFaculty_id(),
                campusFaculty.getUpdate_date(),
                campusFaculty.isIs_active(),
                campusFaculty.getCf_id());
    }

    public List<Campus> findFacultyCampuses(long faculty_id) {
        String sqlQuery = "select c.campus_id,c.campus_name,c.campus_address,c.campus_phone_number,c.campus_email \n" +
                "from campus_faculty cf \n" +
                "join campus c on c.campus_id = cf.campus_id \n" +
                "join faculty f on f.faculty_id = cf.faculty_id\n" +
                "where f.faculty_id = ?";
        return jdbcTemplate.query(sqlQuery, this::mapRowToCampus, faculty_id);
    }

    public List<Faculty> findCampusFaculties(long campus_id) {
        String sqlQuery = "select f.faculty_id,f.faculty_name,f.faculty_address\n" +
                ",f.faculty_phone_number,f.faculty_email\n" +
                "from faculty f \n" +
                "where f.faculty_id in (select faculty_id from campus_faculty where campus_id = ?)";
        return jdbcTemplate.query(sqlQuery, this::mapRowToFaculty, campus_id);
    }

    public List<Faculty> findFacultiesNotInCampus(long campus_id) {
        String sqlQuery = "select f.faculty_id,f.faculty_name,f.faculty_address\n" +
                ",f.faculty_phone_number,f.faculty_email\n" +
                "from faculty f \n" +
                "where f.faculty_id not in (select faculty_id from campus_faculty where campus_id = ?)";
        return jdbcTemplate.query(sqlQuery, this::mapRowToFaculty, campus_id);
    }

    public List<CampusFaculty> findAll() {
        String sqlQuery = "select * from public.campus_faculty";
        return jdbcTemplate.query(sqlQuery, this::mapRowToCampusFaculty);
    }

    public boolean deleteCampusFacultyInDB(long campus_faculty_id) {
        String sqlQuery = "delete from public.campus_faculty where cf_id = ?";
        return jdbcTemplate.update(sqlQuery, campus_faculty_id) > 0;
    }
}
