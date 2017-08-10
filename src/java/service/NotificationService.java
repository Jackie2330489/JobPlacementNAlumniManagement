/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.NotificationDao;
import dao.impl.MemberDaoImpl;
import dao.impl.NotificationDaoImpl;
import dto.SuperDataExecution;
import entity.Company;
import entity.Notification;
import entity.Student;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Justin
 */
public class NotificationService {
    private NotificationDao nDao=new NotificationDaoImpl();
    public SuperDataExecution noti(String uid){
        Student student=new MemberDaoImpl().getMemberById(uid).getStudent();
        List<Notification> notis=nDao.getNotificationsByStudentId(student.getStudentId());
        List<Company> companies=new ArrayList();
        for(Notification n:notis){
            companies.add(n.getFromWho());
        }
        SuperDataExecution sde=new SuperDataExecution(true,notis);
        sde.setList1(companies);
        return sde;
    }
}
