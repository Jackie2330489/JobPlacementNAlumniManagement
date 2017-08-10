/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Notification;
import entity.Student;
import java.util.List;

/**
 *
 * @author Justin
 */
public interface NotificationDao {
    public void addNotification(long companyId,String content,List<Student> students);
    public void deleteNotificationById(long notiId);
    public List<Notification> getNotificationsByStudentId(String studentId);
}
