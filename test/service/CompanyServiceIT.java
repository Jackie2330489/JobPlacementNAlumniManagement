/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dto.DataExecution;
import entity.Company;
import java.util.List;
import org.junit.Test;

/**
 *
 * @author Justin
 */
public class CompanyServiceIT {
    
    private CompanyService companyService=new CompanyService();

    
    
    @Test
    public void testAddCompany() {
        DataExecution de=companyService.searchCompany("at");
        List<Company> companies=(List<Company>) de.getData();
        for(Company company:companies){
            System.out.println(company.getCompanyName());
        }
    }

    @Test
    public void testShowCompanyById() {
    }

    @Test
    public void testShowAllCompanies(){
//        DataExecution de=companyService.showAllCompanies();
//        Company company=new CompanyDaoImpl().getCompanyById((long)3);
        
//        ObjectMapper mapper = new ObjectMapper();  
//        String json =  mapper.writeValueAsString(company);  
//        System.out.println(json);
//        List<Company> companies=(List<Company>)de.getData();
//        for(Company c:companies){
//            System.out.println(c.getCompanyName());
//        }
    }
    
}
