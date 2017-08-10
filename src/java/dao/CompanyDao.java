/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Company;
import entity.Job;
import java.util.List;

/**
 *
 * @author Justin
 */
public interface CompanyDao {
    public void addCompany(String companyName);
    public void deleteCompanyById(long companyId);
    public void updateCompany(Company company);
    public Company getCompanyById(long companyId);
    public List<Company> getCompaniesByJob(Job job);
    public List<Company> getAllCompanies();
    public List<Company> getCompaniesByContent(String content);
}
