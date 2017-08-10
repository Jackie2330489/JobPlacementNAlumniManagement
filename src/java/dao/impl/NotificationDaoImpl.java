/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.NotificationDao;
import entity.Company;
import entity.Notification;
import entity.Student;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author Justin
 */
public class NotificationDaoImpl implements NotificationDao {

    @Override
    public void addNotification(long companyId, String content, List<Student> students) {
        Notification noti = null;
        Transaction tx = null;
        try {
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            tx = session.beginTransaction();
            noti = new Notification((Company) session.get(Company.class, companyId), content);
            for (Student student : students) {
                noti.getToWho().add(student);
            }
            session.save(noti);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        }
    }

    @Override
    public void deleteNotificationById(long notiId) {
        Transaction tx = null;
        try {
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            tx = session.beginTransaction();
            session.delete((Notification) session.get(Notification.class, notiId));
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        }
    }

    @Override
    public List<Notification> getNotificationsByStudentId(String studentId) {
        List<Notification> notis = null;
        Transaction tx = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        tx = session.beginTransaction();
        Student student = (Student) session.get(Student.class, studentId);
        notis = student.getNotifications();
        tx.commit();
        return notis;
    }

}
