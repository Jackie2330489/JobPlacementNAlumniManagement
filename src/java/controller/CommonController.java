/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.impl.VacancyDaoImpl;
import dto.DataExecution;
import dto.MsgExecution;
import entity.Company;
import entity.Member;
import java.io.File;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Justin
 */
@Controller
public class CommonController {
    @RequestMapping(value="/index",method=RequestMethod.GET)
    public String goIndex(){
        return "index";
    }
    
    @ResponseBody
    @RequestMapping(value="/test",method=RequestMethod.GET,produces={"application/json;charset=UTF-8"})
    public DataExecution<List<Company>> test(){
        DataExecution de=new DataExecution(true,new VacancyDaoImpl().getVacancyById((long)4));
        return de;
    }
    
    @ResponseBody
    @RequestMapping(value="/test2",method=RequestMethod.POST,produces={"application/json;charset=UTF-8"})
    public MsgExecution test2(@ModelAttribute Member member){
        System.out.println("userid:"+member.getMemberId());
        System.out.println("password:"+member.getPassword());
        return null;
    }
    
    @ResponseBody
    @RequestMapping(value="/test3",method=RequestMethod.POST,produces={"application/json;charset=UTF-8"})
    public String test3(@RequestParam("file")MultipartFile file){
        String filename=file.getOriginalFilename();
        File targetFile=new File("../photo/",filename);
        if(!targetFile.exists()){
            targetFile.mkdirs();
        }
        try{
            file.transferTo(targetFile);
        }catch(Exception e){
            e.printStackTrace();
        }
        return "hhhhh";
    }
}
