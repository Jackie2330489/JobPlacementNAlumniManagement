/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.MemberDao;
import entity.Member;
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
public class MemberDaoImpl implements MemberDao{

    @Override
    public void addStudentMember(String memberId, String password, Student student){
        Member member=new Member(memberId,password,student);
        Transaction tx=null;
        try{
            Session session=HibernateUtil.getSessionFactory().getCurrentSession();
            tx=session.beginTransaction();
            session.save(member);
            tx.commit();
        }catch(Exception e){
            e.printStackTrace();
            tx.rollback();
        }
    }

    @Override
    public void addManagerMember(String memberId, String password){
        Member member=new Member(memberId,password);
        Transaction tx=null;
        try{
            Session session=HibernateUtil.getSessionFactory().getCurrentSession();
            tx=session.beginTransaction();
            session.save(member);
        }catch(Exception e){
            e.printStackTrace();
            tx.rollback();
        }
        tx.commit();
    }

    @Override
    public void deleteMemberById(String memberId) {
        Transaction tx=null;
        try{
            Session session=HibernateUtil.getSessionFactory().getCurrentSession();
            tx=session.beginTransaction();
            String hql="delete from Member where memberId=?";
            Query q=session.createQuery(hql);
            q.setString(0, memberId);
            q.executeUpdate();
            tx.commit();
        }catch(Exception e){
            e.printStackTrace();
            tx.rollback();
        }
        
    }

    @Override
    public void updateMember(Member member) {
        Transaction tx=null;
        try{
            Session session=HibernateUtil.getSessionFactory().getCurrentSession();
            tx=session.beginTransaction();
            session.update(member);
        }catch(Exception e){
            e.printStackTrace();
            tx.rollback();
        }
        tx.commit();
    }

    @Override
    public List<Member> getAllMembers() {
        List<Member> members=null;
        Transaction tx=null;
        try{
            Session session=HibernateUtil.getSessionFactory().getCurrentSession();
            tx=session.beginTransaction();
            String hql="from Member";
            Query q=session.createQuery(hql);
            members=q.list();
            tx.commit();
        }catch(Exception e){
            e.printStackTrace();
            tx.rollback();
        }
        return members;
    }

    @Override
    public Member getMemberById(String memberId) {
        Member member=null;
        Transaction tx=null;
        try{
            Session session=HibernateUtil.getSessionFactory().getCurrentSession();
            tx=session.beginTransaction();
            String hql="from Member where memberId=?";
            Query q=session.createQuery(hql);
            q.setString(0, memberId);
            member=(Member) q.uniqueResult();
            tx.commit();
        }catch(Exception e){
            e.printStackTrace();
            tx.rollback();
        }
        return member;
    }

    @Override
    public void saveMember(Member member) {
        Transaction tx=null;
        try{
            Session session=HibernateUtil.getSessionFactory().getCurrentSession();
            tx=session.beginTransaction();
            session.save(member);
            tx.commit();
        }catch(Exception e){
            e.printStackTrace();
            tx.rollback();
        }
    }
    
}
