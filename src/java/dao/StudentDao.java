/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Student;
import java.util.List;

/**
 *
 * @author Justin
 */
public interface StudentDao {
    public void saveStudent(Student student);
    public void addStudent(String studentId, String name, String sex, String region, int grade, String institute, String specialize, String phone, String email, String qqOrWechat, String others);
    public void deleteStudentById(String studentId);
    public void updateStudent(Student student);
    public Student getStudentById(String studentId);
    public List<Student> getAllStudents();
    public List<Student> getStudentsByCompanyId(long companyId);
}
