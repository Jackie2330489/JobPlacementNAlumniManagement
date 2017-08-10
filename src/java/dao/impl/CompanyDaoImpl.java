/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.CompanyDao;
import entity.Company;
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
public class CompanyDaoImpl implements CompanyDao{

    @Override
    public void addCompany(String companyName) {
        Company company=new Company(companyName);
        Transaction tx=null;
        try{
            Session session=HibernateUtil.getSessionFactory().getCurrentSession();
            tx=session.beginTransaction();
            session.save(company);
            tx.commit();
        }catch(Exception e){
            e.printStackTrace();
            tx.rollback();
        }
    }

    @Override
    public void deleteCompanyById(long companyId) {
        Transaction tx=null;
        try{
            Session session=HibernateUtil.getSessionFactory().getCurrentSession();
            tx=session.beginTransaction();
            session.delete((Company)session.get(Company.class, companyId));
            tx.commit();
        }catch(Exception e){
            e.printStackTrace();
            tx.rollback();
        }
    }

    @Override
    public void updateCompany(Company company) {
        Transaction tx=null;
        try{
            Session session=HibernateUtil.getSessionFactory().getCurrentSession();
            tx=session.beginTransaction();
            session.update(company);
            tx.commit();
        }catch(Exception e){
            e.printStackTrace();
            tx.rollback();
        }
    }

    @Override
    public Company getCompanyById(long companyId) {
        Company company=null;
        Transaction tx=null;
        try{
            Session session=HibernateUtil.getSessionFactory().getCurrentSession();
            tx=session.beginTransaction();
            company=(Company) session.get(Company.class, companyId);
            tx.commit();
        }catch(Exception e){
            e.printStackTrace();
            tx.rollback();
        }
        return company;
    }

    @Override
    public List<Company> getCompaniesByJob(Job job) {
        List<Company> companies=null;
        Transaction tx=null;
        companies=job.getFromCompanies();
        return companies;
    }

    @Override
    public List<Company> getAllCompanies() {
        List<Company> companies=null;
        Transaction tx=null;
        try{
            Session session=HibernateUtil.getSessionFactory().getCurrentSession();
            tx=session.beginTransaction();
            String hql="from Company";
            Query q=session.createQuery(hql);
            companies=q.list();
            tx.commit();
        }catch(Exception e){
            e.printStackTrace();
            tx.rollback();
        }
        return companies;
    }

    @Override
    public List<Company> getCompaniesByContent(String content) {
        List<Company> companies=null;
        Transaction tx=null;
        try{
            Session session=HibernateUtil.getSessionFactory().getCurrentSession();
            tx=session.beginTransaction();
            String hql="from Company where companyName like '%"+content+"%'";
            Query q=session.createQuery(hql);
            companies=q.list();
            tx.commit();
        }catch(Exception e){
            e.printStackTrace();
            tx.rollback();
        }
        return companies;
    }
    
}
