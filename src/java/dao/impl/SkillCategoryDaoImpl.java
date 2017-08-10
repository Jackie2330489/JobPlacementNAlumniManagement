/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.SkillCategoryDao;
import entity.SkillCategory;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author Justin
 */
public class SkillCategoryDaoImpl implements SkillCategoryDao{

    @Override
    public void addSkillCategory(String scName) {
        SkillCategory sc=new SkillCategory(scName);
        Transaction tx=null;
        try{
            Session session=HibernateUtil.getSessionFactory().getCurrentSession();
            tx=session.beginTransaction();
            session.save(sc);
        }catch(Exception e){
            e.printStackTrace();
            tx.rollback();
        }
        tx.commit();
    }

    @Override
    public void updateSkillCategory(SkillCategory sc) {
        Transaction tx=null;
        try{
            Session session=HibernateUtil.getSessionFactory().getCurrentSession();
            tx=session.beginTransaction();
            session.update(sc);
        }catch(Exception e){
            e.printStackTrace();
            tx.rollback();
        }
        tx.commit();
    }

    @Override
    public SkillCategory getSkillCategoryById(int scId) {
        SkillCategory sc=null;
        Transaction tx=null;
        try{
            Session session=HibernateUtil.getSessionFactory().getCurrentSession();
            tx=session.beginTransaction();
            sc=(SkillCategory)session.get(SkillCategory.class, scId);
        }catch(Exception e){
            e.printStackTrace();
        }
        tx.commit();
        return sc;
    }

    @Override
    public List<SkillCategory> getSkillCategorys() {
        List<SkillCategory> skillCategorys=null;
        Transaction tx=null;
        try{
            Session session=HibernateUtil.getSessionFactory().getCurrentSession();
            tx=session.beginTransaction();
            String hql="from SkillCategory";
            Query q=session.createQuery(hql);
            skillCategorys=q.list();
            tx.commit();
        }catch(Exception e){
            e.printStackTrace();
            tx.rollback();
        }
        return skillCategorys;
    }
}
