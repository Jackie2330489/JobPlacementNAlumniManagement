/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dto.SuperDataExecution;
import entity.Company;
import entity.Job;
import java.util.List;
import org.junit.Test;

/**
 *
 * @author Justin
 */
public class JobServiceTT {
    private JobService jobService=new JobService();
    @Test
    public void test1(){
        SuperDataExecution sde=jobService.searchJob("ball");
        List<Job> jobs=(List<Job>) sde.getData();
        List<Company> companies=sde.getList1();
        System.out.println("Jobs:");
        for(Job job:jobs){
            System.out.println(job.getJobName());
        }
        System.out.println("Companies:");
        for(Company company:companies){
            System.out.println(company.getCompanyName());
        }
    }
}
