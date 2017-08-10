/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.CompanyDao;
import dao.StudentDao;
import entity.Company;
import entity.Student;
import java.util.List;
import org.junit.Test;

/**
 *
 * @author Justin
 */
public class StudentDaoImplIT {
    
    private StudentDao studentDao=new StudentDaoImpl();

    @Test
    public void testAddStudent() {
        
//        studentDao.addStudent("201440703690", "Justin", "Male", "GuangDong Foshan", 2014, "数软", "java", "17854230489", "jiumam123@qq.com", "704855911", "Handsome");
//        studentDao.addStudent("201440703211", "Banana", "Male", "GuangDong Foshan", 2014, "数软", "java", "17854230489", "jiumam123@qq.com", "704855911", "Handsome");
//        studentDao.addStudent("201420618230", "Orange", "Male", "GuangDong Foshan", 2014, "数软", "java", "17854230489", "jiumam123@qq.com", "704855911", "Handsome");
    }

    @Test
    public void testDeleteStudentById() {
        studentDao.deleteStudentById("201440703211");
    }

    @Test
    public void testUpdateStudent() {
        Student student=studentDao.getStudentById("201440703690");
        CompanyDao companyDao=new CompanyDaoImpl();
        Company company=companyDao.getCompanyById((long)1);
        student.setCompany(company);
        studentDao.updateStudent(student);
    }

    @Test
    public void testGetStudentById() {
        Student student=studentDao.getStudentById("201440703690");
//        if(student==null)System.out.println("nullllllllll");
        System.out.println("Student Details:");
        System.out.println(student.getStudentId());
        System.out.println(student.getName());
        System.out.println(student.getPhone());
    }

    @Test
    public void testGetAllStudents() {
        List <Student> students=studentDao.getAllStudents();
        System.out.println("get all students:");
        for(Student s:students){
            System.out.println(s.getStudentId()+s.getName());
        }
    }

    @Test
    public void testGetStudentsByCompanyId() {
        Company company=new CompanyDaoImpl().getCompanyById((long)1);
        List<Student> students=company.getStudentsOnDuty();
        for(Student s:students){
            System.out.println(s.getName());
        }
    }
    
}
