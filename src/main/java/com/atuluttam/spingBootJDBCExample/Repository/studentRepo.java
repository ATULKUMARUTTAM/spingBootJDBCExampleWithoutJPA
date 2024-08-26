package com.atuluttam.spingBootJDBCExample.Repository;


import com.atuluttam.spingBootJDBCExample.Model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class studentRepo {
    @Autowired
    private Student s;
    @Autowired
    private JdbcTemplate JT;

    String sql = "insert into Student(roll, Name, marks) values(?,?,?)";
    public void save(Student s)
    {
       int a =  JT.update(sql,s.getRoll(),s.getName(), s.getMarks());
       System.out.println(a+ " Student saved in Database");
    }
    public List<Student> findAll()
    {
        String sql = "select * from Student";

        return JT.query(sql, new RowMapper<Student>() {
            @Override
            public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
                Student s = new Student();
                s.setRoll(rs.getInt("roll"));
                //s.setRoll(rs.getInt(1));
                s.setName(rs.getString("Name"));
                //s.setName(rs.getString(2));
                s.setRoll(rs.getInt("marks"));
                return s;
            }
        });
       //return new ArrayList<Student>();
    }
}
