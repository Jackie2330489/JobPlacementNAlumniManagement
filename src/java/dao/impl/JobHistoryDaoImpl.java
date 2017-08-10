/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.JobHistoryDao;
import dao.StudentDao;
import entity.JobHistory;
import entity.Student;
import entity.Vacancy;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author Justin
 */
public class JobHistoryDaoImpl implements JobHistoryDao{

    @Override
    public void addJobHistory(Date wantTime, Date workTime, String studentId, long vacancyId) {
        Transaction tx=null;
        try{
            Session session=HibernateUtil.getSessionFactory().getCurrentSession();
            tx=session.beginTransaction();
            Student student=(Student) session.get(Student.class, studentId);
            Vacancy vacancy=(Vacancy) session.get(Vacancy.class, vacancyId);
            JobHistory jobHistory=new JobHistory(wantTime,workTime,student,vacancy);
            session.save(jobHistory);
            tx.commit();
        }catch(Exception e){
            e.printStackTrace();
            tx.rollback();
        }
    }

    @Override
    public void deleteJobHistoryById(long jhId) {
        Transaction tx=null;
        try{
            Session session=HibernateUtil.getSessionFactory().getCurrentSession();
            tx=session.beginTransaction();
            session.delete((JobHistory)session.get(JobHistory.class, jhId));
            tx.commit();
        }catch(Exception e){
            e.printStackTrace();
            tx.rollback();
        }
    }

    @Override
    public List<JobHistory> getJobHistoriesByStudentId(String studentId) {
        List<JobHistory> jobHistories=null;
        StudentDao studentDao=new StudentDaoImpl();
        Student student=studentDao.getStudentById(studentId);
        jobHistories=student.getJobHistories();
        return jobHistories;
    }
    
}
