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
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

package com.atuluttam.spingBootJDBCExample.Model;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Student {
    private int roll;
    private String Name;
    private int marks;


    public int getRoll() {
        return roll;
    }

    public void setRoll(int roll) {
        this.roll = roll;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "Student{" +
                "roll=" + roll +
                ", Name='" + Name + '\'' +
                ", marks=" + marks +
                '}';
    }
}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////

package com.atuluttam.spingBootJDBCExample.Service;

import com.atuluttam.spingBootJDBCExample.Model.Student;
import com.atuluttam.spingBootJDBCExample.Repository.studentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

   @Autowired
   private studentRepo SR;

    public void addStudent(Student s)
    {
        SR.save(s);
    }

    public List<Student> getAllStudents(){
       return SR.findAll();
    }

    public void removeStudent(int r)
    {
       SR.deleteStudent(r);
    }

    public void updateinfo(Student s)
    {
        SR.updateStudent(s);
    }


}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

package com.atuluttam.spingBootJDBCExample;

import com.atuluttam.spingBootJDBCExample.Model.Student;
import com.atuluttam.spingBootJDBCExample.Service.StudentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class SpingBootJdbcExampleApplication {
	public static void main(String[] args) {
	ApplicationContext ctx = 	SpringApplication.run(SpingBootJdbcExampleApplication.class, args);
		Student st = ctx.getBean(Student.class);
		st.setName("James");
		st.setMarks(70);
		st.setRoll(101);
        //Call the service method to add student object
		StudentService ss = ctx.getBean(StudentService.class);
		ss.addStudent(st);

		List<Student> LS = ss.getAllStudents();
		System.out.println(LS);


		ss.removeStudent(st.getRoll());

		st.setName("James");
		st.setMarks(700);
		st.setRoll(101);
		 LS = ss.getAllStudents();
		System.out.println(LS);


		ss.addStudent(st);
		LS = ss.getAllStudents();
		System.out.println(LS);



		st.setName("James");
		st.setMarks(70);
		st.setRoll(101);
		ss.updateinfo(st);

		LS = ss.getAllStudents();
		System.out.println(LS);

	}
}
