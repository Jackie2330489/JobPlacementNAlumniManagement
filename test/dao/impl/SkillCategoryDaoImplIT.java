/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.SkillCategoryDao;
import dao.SkillDao;
import entity.Skill;
import entity.SkillCategory;
import java.util.List;
import org.junit.Test;

/**
 *
 * @author Justin
 */
public class SkillCategoryDaoImplIT {
    
    private SkillCategoryDao scDao=new SkillCategoryDaoImpl();
    private SkillDao skillDao=new SkillDaoImpl();
    
    @Test
    public void testAddSkillCategory() {
//        skillDao.addSkill("ECMAScript 6");
//        skillDao.addSkill("ReactJS");
//        skillDao.addSkill("VueJS");
//        skillDao.addSkill("BackboneJS");
//        skillDao.addSkill("EmberJS");
//        skillDao.addSkill("RequireJS");
//        
//        skillDao.addSkill("iOS");
//        skillDao.addSkill("Swift");
//        skillDao.addSkill("React Native");
//        skillDao.addSkill("Ionic");
//        skillDao.addSkill("JQuery Mobile");
//        
//        skillDao.addSkill("PHP");
//        skillDao.addSkill("NodeJS");
//        skillDao.addSkill("Python");
//        skillDao.addSkill("Django");
//        skillDao.addSkill("Ruby");
//        skillDao.addSkill("Perl");
//        
//        skillDao.addSkill("MSSQL");
//        skillDao.addSkill("MySQL");
//        skillDao.addSkill("Derby");
//        skillDao.addSkill("SQLite");
//        skillDao.addSkill("MongoDB");
//        skillDao.addSkill("Redis");
//        SkillCategory sc1=scDao.getSkillCategoryById(1);
//        sc1.getScSons().add(skillDao.getSkillById((long)1));
//        sc1.getScSons().add(skillDao.getSkillById((long)2));
//        sc1.getScSons().add(skillDao.getSkillById((long)101));
//        sc1.getScSons().add(skillDao.getSkillById((long)102));
//        sc1.getScSons().add(skillDao.getSkillById((long)103));
//        sc1.getScSons().add(skillDao.getSkillById((long)104));
//        sc1.getScSons().add(skillDao.getSkillById((long)105));
//        sc1.getScSons().add(skillDao.getSkillById((long)106));
//        scDao.updateSkillCategory(sc1);
//        SkillCategory sc1=scDao.getSkillCategoryById(2);
//        sc1.getScSons().add(skillDao.getSkillById((long)107));
//        sc1.getScSons().add(skillDao.getSkillById((long)108));
//        sc1.getScSons().add(skillDao.getSkillById((long)109));
//        sc1.getScSons().add(skillDao.getSkillById((long)110));
//        sc1.getScSons().add(skillDao.getSkillById((long)111));
//        scDao.updateSkillCategory(sc1);
        SkillCategory sc1=scDao.getSkillCategoryById(4);
        sc1.getScSons().add(skillDao.getSkillById((long)118));
        sc1.getScSons().add(skillDao.getSkillById((long)119));
        sc1.getScSons().add(skillDao.getSkillById((long)120));
        sc1.getScSons().add(skillDao.getSkillById((long)121));
        sc1.getScSons().add(skillDao.getSkillById((long)122));
        sc1.getScSons().add(skillDao.getSkillById((long)123));
        scDao.updateSkillCategory(sc1);
    }

    @Test
    public void testUpdateSkillCategory() {
        SkillCategory sc=scDao.getSkillCategoryById(1);
        SkillDao sd=new SkillDaoImpl();
        Skill s=sd.getSkillById((long)4);
        sc.getScSons().add(s);
        scDao.updateSkillCategory(sc);
    }

    @Test
    public void testGetSkillCategoryById() {
        SkillCategory sc=scDao.getSkillCategoryById(1);
        System.out.println(sc.getScName());
        List<Skill> skills=sc.getScSons();
        for(Skill s:skills){
            System.out.println(s.getSkillName());
        }
    }
    
}
