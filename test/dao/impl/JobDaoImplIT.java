/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.JobDao;
import entity.Job;
import java.util.List;
import org.junit.Test;

/**
 *
 * @author Justin
 */
public class JobDaoImplIT {
    
    private JobDao jobDao=new JobDaoImpl();

    @Test
    public void testAddJob() {
        jobDao.addJob("Monenmmmm");
        jobDao.addJob("Helloer");
        jobDao.addJob("Wolrder");
    }

    @Test
    public void testDeleteJobById() {
        jobDao.deleteJobById((long)5);
    }

    @Test
    public void testUpdateJob() {
        Job job=jobDao.getJobById((long)2);
        job.setJobName("WTF");
        jobDao.updateJob(job);
    }

    @Test
    public void testGetJobById() {
        Job job=jobDao.getJobById((long)7);
        System.out.println(job.toString());
    }

    @Test
    public void testGetFirst10Jobs() {
        List<Job> jobs=jobDao.getFirst10Jobs();
        System.out.println("First 10 Jobs:");
        for(Job job:jobs){
            System.out.println(job.getJobName());
        }
    }

    @Test
    public void testGetAllJobs() {
        List<Job> jobs=jobDao.getAllJobs();
        System.out.println("All Jobs:");
        for(Job job:jobs){
            System.out.println(job.getJobName());
        }
    }
    
    @Test
    public void testGetJobsByContent(){
        String content="ball";
        List<Job> jobs=jobDao.getJobsByContent(content);
        for(Job job:jobs){
            System.out.println(job.getJobName());
        }
    }
}
