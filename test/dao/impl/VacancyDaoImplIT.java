/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.VacancyDao;
import entity.Student;
import entity.Vacancy;
import java.util.List;
import org.junit.Test;
import service.VacancyService;

/**
 *
 * @author Justin
 */
public class VacancyDaoImplIT {
    
    private VacancyDao vacancyDao=new VacancyDaoImpl();
    private VacancyService vacancyService=new VacancyService();
    
    @Test
    public void testAddVacancy() {
        Vacancy vacancy=new Vacancy();
        vacancy.setType("ssssss");
        vacancyService.saveOrUpdate(vacancy, (long)0, (long)0, null);
    }

    @Test
    public void testDeleteVacancyById() {
        vacancyDao.deleteVacancyById((long)1);
    }

    @Test
    public void testUpdateVacancy() {
    }

    @Test
    public void testGetVacancyById() {
//        Vacancy vacancy=vacancyDao.getVacancyById((long)4);
//        Skill skill=new SkillDaoImpl().getSkillById((long)1);
//        vacancy.getRequiredSkills().add(skill);
//        vacancyDao.updateVacancy(vacancy);
        Vacancy vacancy=vacancyDao.getVacancyById((long)4);
        vacancy.getRequiredSkills().add(new SkillDaoImpl().getSkillById((long)1));
        vacancyDao.updateVacancy(vacancy);
    }

    @Test
    public void testGetVacanciesByCompanyId() {
        List<Vacancy> vacancies=vacancyDao.getVacanciesByCompanyId((long)2);
        for(Vacancy v:vacancies){
            System.out.println(v.getVacancyId());
        }
    }

    @Test
    public void testGetVacanciesByStudentId() {
        Student student=new StudentDaoImpl().getStudentById("201440703690");
        Vacancy vacancy=vacancyDao.getVacancyById((long)3);
        vacancy.getApplicants().add(student);
        vacancyDao.updateVacancy(vacancy);
        
        List<Vacancy> vacancies=vacancyDao.getVacanciesByStudentId("201440703690");
        for(Vacancy v:vacancies){
            System.out.println(v.getVacancyId());
        }
    }
    
}
