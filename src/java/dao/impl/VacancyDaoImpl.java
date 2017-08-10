/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.SkillDao;
import dao.VacancyDao;
import entity.Company;
import entity.Job;
import entity.Skill;
import entity.Student;
import entity.Vacancy;
import enums.VacancyStatusEnum;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author Justin
 */
public class VacancyDaoImpl implements VacancyDao{

    @Override
    public void addVacancy(long companyId, String type, long jobId, Date lastDate,VacancyStatusEnum vse,List<Skill> skills) {
        Transaction tx=null;
        try{
            Session session=HibernateUtil.getSessionFactory().getCurrentSession();
            tx=session.beginTransaction();
            Vacancy vacancy=new Vacancy(type,(Company)session.get(Company.class, companyId),(Job)session.get(Job.class, jobId),lastDate);
            vacancy.setVacancyStatus(vse);
            vacancy.setRequiredSkills(skills);
            session.save(vacancy);
            tx.commit();
        }catch(Exception e){
            e.printStackTrace();
            tx.rollback();
        }
    }

    @Override
    public void deleteVacancyById(long vacancyId) {
        Transaction tx=null;
        try{
            Session session=HibernateUtil.getSessionFactory().getCurrentSession();
            tx=session.beginTransaction();
            session.delete((Vacancy)session.get(Vacancy.class, vacancyId));
            tx.commit();
        }catch(Exception e){
            e.printStackTrace();
            tx.rollback();
        }
    }

    @Override
    public void updateVacancy(Vacancy vacancy) {
        Transaction tx=null;
        try{
            Session session=HibernateUtil.getSessionFactory().getCurrentSession();
            tx=session.beginTransaction();
            session.update(vacancy);
            tx.commit();
        }catch(Exception e){
            e.printStackTrace();
            tx.rollback();
        }
    }

    @Override
    public Vacancy getVacancyById(long vacancyId) {
        Vacancy vacancy=null;
        Transaction tx=null;
        try{
            Session session=HibernateUtil.getSessionFactory().getCurrentSession();
            tx=session.beginTransaction();
            vacancy=(Vacancy) session.get(Vacancy.class, vacancyId);
            tx.commit();
        }catch(Exception e){
            e.printStackTrace();
            tx.rollback();
        }
        return vacancy;
    }

    @Override
    public List<Vacancy> getVacanciesByCompanyId(long companyId) {
        List<Vacancy> vacancies=null;
        Transaction tx=null;
        try{
            Session session=HibernateUtil.getSessionFactory().getCurrentSession();
            tx=session.beginTransaction();
            Company company=(Company) session.get(Company.class, companyId);
            vacancies=company.getVacancies();
            tx.commit();
        }catch(Exception e){
            e.printStackTrace();
            tx.rollback();
        }
        return vacancies;
    }

    @Override
    public List<Vacancy> getVacanciesByStudentId(String studentId) {
        List<Vacancy> vacancies=null;
        Transaction tx=null;
        try{
            Session session=HibernateUtil.getSessionFactory().getCurrentSession();
            tx=session.beginTransaction();
            Student student=(Student) session.get(Student.class, studentId);
            vacancies=student.getVacancies();
            tx.commit();
        }catch(Exception e){
            e.printStackTrace();
            tx.rollback();
        }
        return vacancies;
    }

    private SkillDao skillDao=new SkillDaoImpl();
    @Override
    public List<Vacancy> getVacanciesByContent(String content) {
        List<Vacancy> vacancies=new ArrayList<Vacancy>();
        Transaction tx=null;
        try{
            Session session=HibernateUtil.getSessionFactory().getCurrentSession();
            tx=session.beginTransaction();
            String hql="from Skill where skillName like '%"+content+"%'";
            Query q=session.createQuery(hql);
            List<Skill> skills=q.list();
            for(Skill skill:skills){
                List<Vacancy> vans=skill.getVacancies();
                vacancies.removeAll(vans);
                vacancies.addAll(vans);
            }
            tx.commit();
        }catch(Exception e){
            e.printStackTrace();
            tx.rollback();
        }
        return vacancies;
    }

    @Override
    public List<Vacancy> getAllVacancies() {
        List<Vacancy> vacancies=null;
        Transaction tx=null;
        try{
            Session session=HibernateUtil.getSessionFactory().getCurrentSession();
            tx=session.beginTransaction();
            String hql="from Vacancy";
            Query q=session.createQuery(hql);
            vacancies=q.list();
            tx.commit();
        }catch(Exception e){
            e.printStackTrace();
            tx.rollback();
        }
        return vacancies;
    }

    @Override
    public void saveVacancy(Vacancy vacancy) {
        Transaction tx=null;
        try{
            Session session=HibernateUtil.getSessionFactory().getCurrentSession();
            tx=session.beginTransaction();
            session.save(vacancy);
            tx.commit();
        }catch(Exception e){
            e.printStackTrace();
            tx.rollback();
        }
    }
    
}
