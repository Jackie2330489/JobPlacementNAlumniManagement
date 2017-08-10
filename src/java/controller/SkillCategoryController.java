/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dto.SuperDataExecution;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import service.SkillCategoryService;

/**
 *
 * @author Justin
 */
@Controller
@RequestMapping("/sc")
public class SkillCategoryController {
    private SkillCategoryService scService=new SkillCategoryService();
    
    @ResponseBody
    @RequestMapping(value="/all",method=RequestMethod.GET,produces={"application/json;charset=UTF-8"})
    public SuperDataExecution skillCategorys(){
        return scService.skillcategorys();
    }
}
