/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.CompanyDao;
import entity.Company;
import entity.Job;
import java.util.List;
import org.junit.Test;

/**
 *
 * @author Justin
 */
public class CompanyDaoImplIT {
    
    private CompanyDao companyDao=new CompanyDaoImpl();

    @Test
    public void testAddCompany() {
        companyDao.addCompany("Apple");
        companyDao.addCompany("Banana");
        companyDao.addCompany("Cat");
        companyDao.addCompany("Dog");
    }

    @Test
    public void testDeleteCompanyById() {
        companyDao.deleteCompanyById((long)4);
    }

    @Test
    public void testUpdateCompany() {
        Company company=companyDao.getCompanyById((long)1);
        Job job=new JobDaoImpl().getJobById((long)1);
        company.getVacancies();
//        company.getJobs().add(job);
//        companyDao.updateCompany(company);
//        System.out.println("Expected:");
//        for(Job j:company.getJobs()){
//            System.out.println(j.getJobName());
//        }
//        System.out.println("Actual:");
//        for(Job j:companyDao.getCompanyById((long)1).getJobs()){
//            System.out.println(j.getJobName());
//        }
    }

    @Test
    public void testGetCompanyById() {
        Company company=companyDao.getCompanyById((long)5);
        if(company==null)System.out.println("nullnuul");
//        System.out.println(company.getCompanyName());
    }

    @Test
    public void testGetCompaniesByJob() {
        Job job=new JobDaoImpl().getJobById((long)1);
        List<Company> companies=companyDao.getCompaniesByJob(job);
        System.out.println("get companies By a job:");
        for(Company c:companies){
            System.out.println(c.getCompanyName());
        }
    }

    @Test
    public void testGetAllCompanies() {
        List<Company> companies=companyDao.getAllCompanies();
        System.out.println("All Companies:");
        for(Company c:companies){
            System.out.println(c.getCompanyName());
        }
    }
    
}
