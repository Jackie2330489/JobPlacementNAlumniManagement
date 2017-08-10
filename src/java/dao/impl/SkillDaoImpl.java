/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.SkillCategoryDao;
import dao.SkillDao;
import entity.Skill;
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
public class SkillDaoImpl implements SkillDao{
    
    @Override
    public void addSkill(String skillName) {
        Skill skill=new Skill(skillName);
        Transaction tx=null;
        try{
            Session session=HibernateUtil.getSessionFactory().getCurrentSession();
            tx=session.beginTransaction();
            session.save(skill);
        }catch(Exception e){
            e.printStackTrace();
            tx.rollback();
        }
        tx.commit();
    }

    @Override
    public void deleteSkillById(long skillId) {
        Transaction tx=null;
        try{
            Session session=HibernateUtil.getSessionFactory().getCurrentSession();
            tx=session.beginTransaction();
            session.delete((Skill)session.get(Skill.class, skillId));
        }catch(Exception e){
            e.printStackTrace();
            tx.rollback();
        }
        tx.commit();
    }

    @Override
    public void updateSkillId(Skill skill) {
        Transaction tx=null;
        try{
            Session session=HibernateUtil.getSessionFactory().getCurrentSession();
            tx=session.beginTransaction();
            session.update(skill);
        }catch(Exception e){
            e.printStackTrace();
            tx.rollback();
        }
        tx.commit();
    }

    @Override
    public Skill getSkillById(long skillId) {
        Skill skill=null;
        Transaction tx=null;
        try{
            Session session=HibernateUtil.getSessionFactory().getCurrentSession();
            tx=session.beginTransaction();
            skill=(Skill)session.get(Skill.class, skillId);
        }catch(Exception e){
            e.printStackTrace();
        }
        tx.commit();
        return skill;
    }

    
    
    @Override
    public List<Skill> getSkillsByscId(int scId) {
        SkillCategoryDao scDao=new SkillCategoryDaoImpl();
        SkillCategory sc=scDao.getSkillCategoryById(scId);
        return sc.getScSons();
    }

    @Override
    public List<Skill> getAllSkills() {
        List<Skill> skills=null;
        Transaction tx=null;
        try{
            Session session=HibernateUtil.getSessionFactory().getCurrentSession();
            tx=session.beginTransaction();
            String hql="from Skill";
            Query q=session.createQuery(hql);
            skills=q.list();
            tx.commit();
        }catch(Exception e){
            e.printStackTrace();
        }
        return skills;
    }
    
}
