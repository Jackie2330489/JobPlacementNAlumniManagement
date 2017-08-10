/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.JobDao;
import dao.impl.JobDaoImpl;
import dto.SuperDataExecution;
import entity.Company;
import entity.Job;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Justin
 */
public class JobService {

    private JobDao jobDao = new JobDaoImpl();

    public SuperDataExecution allJobs(){
        SuperDataExecution sde = null;
        List<Job> jobs=jobDao.getAllJobs();
        sde=new SuperDataExecution(true,jobs);
        return sde;
    }
    public SuperDataExecution searchJob(String content) {
        SuperDataExecution sde = null;
        List<Job> jobs = jobDao.getJobsByContent(content);
        if (jobs.size() == 0) {
            sde = new SuperDataExecution(false, "No Matched Jobs");
        } else {
            List<Company> companies = new ArrayList<Company>();
            for (Job job : jobs) {
                companies.add(job.getFromCompanies().get(0));
            }
            sde=new SuperDataExecution(true,jobs);
            sde.setList1(companies);
        }
        return sde;
    }
    public SuperDataExecution jobDetails(long jobId){
        SuperDataExecution sde=null;
        Job job=jobDao.getJobById(jobId);
        sde=new SuperDataExecution(true,job);
        sde.setList1(job.getFromCompanies());
        return sde;
    }
    
    public SuperDataExecution first10(){
        SuperDataExecution sde=null;
        List<Job> jobs=jobDao.getFirst10Jobs();
        sde=new SuperDataExecution(true,jobs);
        List<List<Company>> listsOfCompanies=new ArrayList();
        for(Job j:jobs){
            listsOfCompanies.add(j.getFromCompanies());
        }
        sde.setList1(listsOfCompanies);
        return sde;
    }
}
