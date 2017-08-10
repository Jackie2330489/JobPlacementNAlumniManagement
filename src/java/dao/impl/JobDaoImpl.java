/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.JobDao;
import entity.Job;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author Justin
 */
public class JobDaoImpl implements JobDao{

    @Override
    public void addJob(String jobName) {
        Job job=new Job(jobName);
        Transaction tx=null;
        try{
            Session session=HibernateUtil.getSessionFactory().getCurrentSession();
            tx=session.beginTransaction();
            session.save(job);
            tx.commit();
        }catch(Exception e){
            e.printStackTrace();
            tx.rollback();
        }
    }

    @Override
    public void deleteJobById(long jobId) {
        Transaction tx=null;
        try{
            Session session=HibernateUtil.getSessionFactory().getCurrentSession();
            tx=session.beginTransaction();
            session.delete((Job)session.get(Job.class, jobId));
            tx.commit();
        }catch(Exception e){
            e.printStackTrace();
            tx.rollback();
        }
    }

    @Override
    public void updateJob(Job job) {
        Transaction tx=null;
        try{
            Session session=HibernateUtil.getSessionFactory().getCurrentSession();
            tx=session.beginTransaction();
            session.update(job);
            tx.commit();
        }catch(Exception e){
            e.printStackTrace();
            tx.rollback();
        }
    }

    @Override
    public Job getJobById(long jobId) {
        Job job=null;
        Transaction tx=null;
        try{
            Session session=HibernateUtil.getSessionFactory().getCurrentSession();
            tx=session.beginTransaction();
            job=(Job) session.get(Job.class, jobId);
            tx.commit();
        }catch(Exception e){
            e.printStackTrace();
            tx.rollback();
        }
        return job;
    }

    @Override
    public List<Job> getFirst10Jobs() {
        List<Job> jobs=null;
        Transaction tx=null;
        try{
            Session session=HibernateUtil.getSessionFactory().getCurrentSession();
            tx=session.beginTransaction();
            String hql="from Job order by nowRating asc";
            Query q=session.createQuery(hql);
            q.setFirstResult(0);
            q.setMaxResults(10);
            jobs=q.list();
            tx.commit();
        }catch(Exception e){
            e.printStackTrace();
            tx.rollback();
        }
        return jobs;
    }

    @Override
    public List<Job> getAllJobs() {
        List<Job> jobs=null;
        Transaction tx=null;
        try{
            Session session=HibernateUtil.getSessionFactory().getCurrentSession();
            tx=session.beginTransaction();
            String hql="from Job";
            Query q=session.createQuery(hql);
            jobs=q.list();
            tx.commit();
        }catch(Exception e){
            e.printStackTrace();
            tx.rollback();
        }
        return jobs;
    }

    @Override
    public List<Job> getJobsByContent(String content) {
        List<Job> jobs=null;
        Transaction tx=null;
        try{
            Session session=HibernateUtil.getSessionFactory().getCurrentSession();
            tx=session.beginTransaction();
            String hql="from Job where jobName like '%"+content+"%'";
            Query q=session.createQuery(hql);
            jobs=q.list();
            tx.commit();
        }catch(Exception e){
            e.printStackTrace();
            tx.rollback();
        }
        return jobs;
    }
    
}
