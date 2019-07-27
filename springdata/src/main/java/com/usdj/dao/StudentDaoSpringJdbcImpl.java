package com.usdj.dao;

import com.usdj.domain.Student;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author gerrydeng
 * @date 2019-07-25 13:56
 * @Description: 通过spring jdbc方式实现
 */
public class StudentDaoSpringJdbcImpl implements StudentDao {

    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Student> query() {
        List<Student> students = new ArrayList<>();
        String sql = "select * from spring_data.student";
        jdbcTemplate.query(sql, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet resultSet) throws SQLException {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                Student student = new Student();
                student.setId(id);
                student.setName(name);
                student.setAge(age);
                students.add(student);
            }
        });
        return students;
    }

    @Override
    public void save(Student student) {

        String sql = "insert into spring_data.student(name,age) values(?, ?)";
        jdbcTemplate.update(sql,new Object[]{student.getName(),student.getAge()});

    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
