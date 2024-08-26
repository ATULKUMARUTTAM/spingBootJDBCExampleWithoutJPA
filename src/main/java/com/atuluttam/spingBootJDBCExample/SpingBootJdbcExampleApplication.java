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
