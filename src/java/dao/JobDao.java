/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Job;
import java.util.List;

/**
 *
 * @author Justin
 */
public interface JobDao {
    public void addJob(String jobName);       
    public void deleteJobById(long jobId);
    public void updateJob(Job job);
    public Job getJobById(long jobId);
    public List<Job> getFirst10Jobs();
    public List<Job> getAllJobs();
    public List<Job> getJobsByContent(String content);
}
