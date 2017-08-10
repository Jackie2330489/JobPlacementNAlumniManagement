/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.JobHistoryDao;
import entity.JobHistory;
import java.util.List;
import org.junit.Test;

/**
 *
 * @author Justin
 */
public class JobHistoryDaoImplIT {
    
    private JobHistoryDao jhDao=new JobHistoryDaoImpl();

    @Test
    public void testAddJobHistory() {
        jhDao.addJobHistory(null, null, "201440703690", (long)4);
        jhDao.addJobHistory(null, null, "201440703690", (long)5);
        jhDao.addJobHistory(null, null, "201440703211", (long)6);
    }

    @Test
    public void testDeleteJobHistoryById() {
        jhDao.deleteJobHistoryById((long)19);
//        jhDao.deleteJobHistoryById((long)5);
    }

    @Test
    public void testGetJobHistoriesByStudentId() {
        List<JobHistory> jhs=jhDao.getJobHistoriesByStudentId("201440703690");
        for(JobHistory jh:jhs){
            System.out.println(jh.getJhId()+jh.getStudent().getName()+jh.getVacancy().getVacancyId());
        }
    }
    
}
