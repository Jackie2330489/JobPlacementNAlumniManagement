/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.CompanyDao;
import dao.impl.CompanyDaoImpl;
import dto.DataExecution;
import dto.MsgExecution;
import dto.SuperDataExecution;
import entity.Company;
import entity.Job;
import entity.Vacancy;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Justin
 */
public class CompanyService {
    
    private CompanyDao companyDao=new CompanyDaoImpl();
    
    public MsgExecution addCompany(String companyName){
        MsgExecution me=null;
        try{
            companyDao.addCompany(companyName);
        }catch(Exception e){
            e.printStackTrace();
            me=new MsgExecution(false,"System Exception Failed To Add Company");
        }
        if(me==null)me=new MsgExecution(true,"Add Company Successfully");
        return me;
    }
    
    public MsgExecution deleteCompany(long companyId){
        MsgExecution me=null;
        try{
            companyDao.deleteCompanyById(companyId);
        }catch(Exception e){
            e.printStackTrace();
            me=new MsgExecution(false,"System Exception Failed To Delete Company");
        }
        if(me==null)me=new MsgExecution(true,"Delete Company Successfully");
        return me;
    }
    
    public DataExecution showCompanyById(long companyId){
        DataExecution<Company> de=null;
        Company company=companyDao.getCompanyById(companyId);
        if(company==null){
            de=new DataExecution(false,"The Company Does Not Exist");
        }
        else{
            de=new DataExecution(true,company);
        }
        return de;
    }
    public DataExecution<List<Company>> showAllCompanies(){
        DataExecution<List<Company>> de=null;
        List<Company> companies=companyDao.getAllCompanies();
        if(companies==null){
            de=new DataExecution(false,"No Companies On Database");
        }
        else{
            de=new DataExecution(true,companies);
        }
        return de;
    }
    
    public DataExecution<List<Company>> searchCompany(String content){
        DataExecution<List<Company>> de=null;
        List<Company> companies=companyDao.getCompaniesByContent(content);
        if(companies==null){
            de=new DataExecution(false,"No Matched Companies");
        }
        else{
            de=new DataExecution(true,companies);
        }
        return de;
    }
    
    public SuperDataExecution<Company> companyDetails(long companyId){
        SuperDataExecution sde=null;
        Company company=companyDao.getCompanyById((long)companyId);
        sde=new SuperDataExecution(true,company);
        List<Vacancy> vacancies=company.getVacancies();
        List<Job> jobs=new ArrayList<Job>();
        for(Vacancy vacancy:vacancies){
            jobs.add(vacancy.getJob());
        }
        sde.setList1(company.getJobs());
        sde.setList2(vacancies);
        sde.setList3(jobs);
        sde.setList4(company.getStudentsOnDuty());
        return sde;
    }
    
     public MsgExecution saveOrUpdate(Company company){
        MsgExecution me=null;
        Company c=companyDao.getCompanyById(company.getCompanyId());
        if(c==null){
            companyDao.addCompany(company.getCompanyName());
            me=new MsgExecution(true,"Add Successly");
        }else{
            c.setCompanyName(company.getCompanyName());
            companyDao.updateCompany(c);
            me=new MsgExecution(true,"Update Successly");
        }
        return me;
    }
}
