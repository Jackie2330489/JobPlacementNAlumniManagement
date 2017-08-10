/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.StudentDao;
import entity.Student;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author Justin
 */
public class StudentDaoImpl implements StudentDao{

    @Override
    public void addStudent(String studentId, String name, String sex, String region, int grade, String institute, String specialize, String phone, String email, String qqOrWechat, String others) {
        Student student=new Student(studentId,name,sex,region,grade,institute,specialize,phone,email,qqOrWechat,others);        
        Transaction tx=null;
        try{
            Session session=HibernateUtil.getSessionFactory().getCurrentSession();
            tx=session.beginTransaction();
            session.save(student);
            tx.commit();
        }catch(Exception e){
            e.printStackTrace();
            tx.rollback();
        }
    }

    @Override
    public void deleteStudentById(String studentId) {
        Transaction tx=null;
        try{
            Session session=HibernateUtil.getSessionFactory().getCurrentSession();
            tx=session.beginTransaction();
            session.delete((Student)session.get(Student.class, studentId));
            tx.commit();
        }catch(Exception e){
            e.printStackTrace();
            tx.rollback();
        }
    }

    @Override
    public void updateStudent(Student student) {
        Transaction tx=null;
        try{
            Session session=HibernateUtil.getSessionFactory().getCurrentSession();
            tx=session.beginTransaction();
            session.update(student);
            tx.commit();
        }catch(Exception e){
            e.printStackTrace();
            tx.rollback();
        }
    }

    @Override
    public Student getStudentById(String studentId) {
        Student student=null;
        Transaction tx=null;
        try{
            Session session=HibernateUtil.getSessionFactory().getCurrentSession();
            tx=session.beginTransaction();
            student=(Student) session.get(Student.class, studentId);            
            tx.commit();
        }catch(Exception e){
            e.printStackTrace();
            tx.rollback();
        }
        return student;
    }

    @Override
    public List<Student> getAllStudents() {
        List<Student> students=null;
        Transaction tx=null;
        try{
            Session session=HibernateUtil.getSessionFactory().getCurrentSession();
            tx=session.beginTransaction();
            String hql="from Student";
            Query q=session.createQuery(hql);
            students=q.list();
            tx.commit();
        }catch(Exception e){
            e.printStackTrace();
            tx.rollback();
        }
        return students;
    }

    @Override
    public List<Student> getStudentsByCompanyId(long companyId) {
        List<Student> students=new CompanyDaoImpl().getCompanyById(companyId).getStudentsOnDuty();
        return students;
    }

    @Override
    public void saveStudent(Student student) {
        Transaction tx=null;
        try{
            Session session=HibernateUtil.getSessionFactory().getCurrentSession();
            tx=session.beginTransaction();
            session.save(student);
            tx.commit();
        }catch(Exception e){
            e.printStackTrace();
            tx.rollback();
        }
    }
    
}
