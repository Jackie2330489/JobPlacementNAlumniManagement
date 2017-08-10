/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.SkillCategoryDao;
import dao.impl.SkillCategoryDaoImpl;
import dto.SuperDataExecution;
import entity.Skill;
import entity.SkillCategory;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Justin
 */
public class SkillCategoryService {
    private SkillCategoryDao scDao=new SkillCategoryDaoImpl();
    
    public SuperDataExecution skillcategorys(){
        SuperDataExecution sde=null;
        List<SkillCategory> skillCategorys=scDao.getSkillCategorys();
        sde=new SuperDataExecution(true,skillCategorys);
        List<List<Skill>> listsOfSkills=new ArrayList();
        for(SkillCategory sc:skillCategorys){
            listsOfSkills.add(sc.getScSons());
        }
        sde.setList1(listsOfSkills);
        return sde;
    }
}
