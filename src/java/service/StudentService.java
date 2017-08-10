/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.StudentDao;
import dao.impl.StudentDaoImpl;
import dto.MsgExecution;
import dto.SuperDataExecution;
import entity.Student;
import java.util.List;

/**
 *
 * @author Justin
 */
public class StudentService {
    private StudentDao studentDao=new StudentDaoImpl();
    
    public SuperDataExecution<Student> studentDetails(String studentId){
        SuperDataExecution sde=null;
        Student student=studentDao.getStudentById(studentId);
        sde=new SuperDataExecution(true,student);
        sde.setData2(student.getCompany());
        sde.setList1(student.getSkills());
        sde.setList2(student.getVacancies());
        sde.setList3(student.getNotifications());
        sde.setList4(student.getJobHistories());
        return sde;
    }
    
    public SuperDataExecution allStudents(){
        SuperDataExecution sde=null;
        List<Student> students=studentDao.getAllStudents();
        sde=new SuperDataExecution(true,students);
        return sde;
    }
    
    public MsgExecution saveOrUpdate(Student student){
        MsgExecution me=null;
        Student s=studentDao.getStudentById(student.getStudentId());
        if(s==null){
            if(student.getGrade()==null)student.setGrade(0);
            studentDao.saveStudent(student);
            me=new MsgExecution(true,"Add Successly"+student.getStudentId());
        }else{
            s.setName(student.getName());
            s.setSex(student.getSex());
            s.setRegion(student.getRegion());
            s.setGrade(student.getGrade());
            s.setInstitute(student.getInstitute());
            s.setSpecialize(student.getSpecialize());
            s.setPhone(student.getPhone());
            s.setEmail(student.getEmail());
            s.setQqOrWechat(student.getQqOrWechat());
            s.setOthers(student.getOthers());
            studentDao.updateStudent(s);
            me=new MsgExecution(true,"Update Successly");
        }
        return me;
    }
}
