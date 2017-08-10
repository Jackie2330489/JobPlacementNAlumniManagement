/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dto.DataExecution;
import dto.MsgExecution;
import dto.SuperDataExecution;
import entity.Company;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import service.CompanyService;

/**
 *
 * @author Justin
 */
@Controller
@RequestMapping("/company")
public class CompanyController {
    
    private CompanyService companyService=new CompanyService();
    
    @ResponseBody
    @RequestMapping(value="/search",method=RequestMethod.GET,produces={"application/json;charset=UTF-8"})
    public DataExecution searchCompany(@RequestParam("content")String content){
        return companyService.searchCompany(content);
    }
    
    @ResponseBody
    @RequestMapping(value="/id",method=RequestMethod.GET,produces={"application/json;charset=UTF-8"})
    public SuperDataExecution companyDetails(@RequestParam("companyId")long companyId){
        return companyService.companyDetails(companyId);
    }
    
    @ResponseBody
    @RequestMapping(value="/all",method=RequestMethod.GET,produces={"application/json;charset=UTF-8"})
    public DataExecution allCompanies(){
        return companyService.showAllCompanies();
    }
    
    @ResponseBody
    @RequestMapping(value="/saveOrUpdate",method=RequestMethod.POST,produces={"application/json;charset=UTF-8"})
    public MsgExecution saveOrUpdateCompany(@ModelAttribute Company company){
        return companyService.saveOrUpdate(company);
    }
}
