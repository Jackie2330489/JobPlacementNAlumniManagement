/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.SkillDao;
import entity.Skill;
import java.util.List;
import java.util.Set;
import org.junit.Test;

/**
 *
 * @author Justin
 */
public class SkillDaoImplIT {
    
    private SkillDao skillDao=new SkillDaoImpl();

    @Test
    public void testAddSkill() {
        skillDao.addSkill("Bootstrap");
        skillDao.addSkill("AngularJS");
        skillDao.addSkill("HappyJS");
    }

    @Test
    public void testDeleteSkillById() {
        skillDao.deleteSkillById((long)2);
    }

    @Test
    public void testUpdateSkillId() {
        Skill skill=skillDao.getSkillById((long)3);
        skill.setSkillName("JJJJjjssssJ");
        skillDao.updateSkillId(skill);
    }

    @Test
    public void testGetSkillById() {
        Skill skill=skillDao.getSkillById((long)4);
        System.out.println("SkillId:"+skill.getSkillId());
        System.out.println("SkillName:"+skill.getSkillName());
    }
    
    @Test
    public void testGetSkillsByscId(){
        List<Skill> skillSet=skillDao.getSkillsByscId(1);
        System.out.print("List<Skill>:");
        for(Skill sk:skillSet){
            System.out.print(sk.getSkillName());
        }
    }
}
