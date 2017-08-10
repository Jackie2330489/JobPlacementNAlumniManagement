/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.NotificationDao;
import org.junit.Test;

/**
 *
 * @author Justin
 */
public class NotificationDaoImplIT {
    
    private NotificationDao notiDao=new NotificationDaoImpl();

    @Test
    public void testAddNotification() {
        notiDao.addNotification((long)1, "Hello My friend", null);
    }

    @Test
    public void testDeleteNotificationById() {
    }

    @Test
    public void testGetNotificationsByStudentId() {
    }
    
}
