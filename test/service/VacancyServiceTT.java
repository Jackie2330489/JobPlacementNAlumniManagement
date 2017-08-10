/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dto.SuperDataExecution;
import entity.Skill;
import entity.Vacancy;
import java.util.List;
import org.junit.Test;

/**
 *
 * @author Justin
 */
public class VacancyServiceTT {
    private VacancyService vacancyService=new VacancyService();
    
    @Test
    public void test(){
        SuperDataExecution sde=vacancyService.getVacancyByContent("oo");
        List<Vacancy> vacancies=(List<Vacancy>) sde.getData();
        List<List> lists=sde.getList1();
        for(Vacancy vacancy:vacancies){
            System.out.println(vacancy.getVacancyId());
        }
        for(List<Skill> skills:lists){
            for(Skill skill:skills){
                System.out.println(skill.getSkillName());
            }
        }
    }
}
