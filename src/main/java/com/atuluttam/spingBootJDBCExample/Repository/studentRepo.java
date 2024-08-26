package com.atuluttam.spingBootJDBCExample.Repository;


import com.atuluttam.spingBootJDBCExample.Model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

/*
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
              //  s.setRoll(rs.getInt(1));
                s.setName(rs.getString("Name"));
                //s.setName(rs.getString(2));
               s.setRoll(rs.getInt("marks"));

                //s.setRoll(rs.getInt(3));
                return s;
            }
        });
       //return new ArrayList<Student>();
    }

    public void deleteStudent(int r) {
        String sql = "delete from Student where roll = ?";
        int a =  JT.update(sql, r);
        System.out.println(a+" Student record deleted");
    }

    public void updateStudent(Student s)
    {
        String sql = "update Student SET name = ?, marks = ? where roll = ?";
       int a =  JT.update(sql, s.getRoll(),s.getName(), s.getMarks());
        System.out.println(a+" Student record updated");
    }


}
*/
@Repository
public class studentRepo {
    @Autowired
    private JdbcTemplate JT;

    public void save(Student s) {
        String sql = "insert into Student(roll, Name, marks) values(?,?,?)";
        int a = JT.update(sql, s.getRoll(), s.getName(), s.getMarks());
        System.out.println(a + " Student saved in Database");
    }

    public List<Student> findAll() {
        String sql = "select * from Student";
        return JT.query(sql, new RowMapper<Student>() {
            @Override
            public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
                Student s = new Student();
                s.setRoll(rs.getInt("roll"));
                s.setName(rs.getString("Name"));
                s.setMarks(rs.getInt("marks"));
                return s;
            }
        });
    }

    public void deleteStudent(int r) {
        String sql = "delete from Student where roll = ?";
        int a = JT.update(sql, r);
        System.out.println(a + " Student record deleted");
    }

    public void updateStudent(Student s) {
        String sql = "update Student SET Name = ?, marks = ? where roll = ?";
        int a = JT.update(sql, s.getName(), s.getMarks(), s.getRoll());
        System.out.println(a + " Student record updated");
    }
}
