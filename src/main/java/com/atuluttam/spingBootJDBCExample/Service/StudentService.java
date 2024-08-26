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
