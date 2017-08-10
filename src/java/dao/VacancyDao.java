/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Skill;
import entity.Vacancy;
import enums.VacancyStatusEnum;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Justin
 */
public interface VacancyDao {
    public void addVacancy(long companyId,String type,long jobId,Date lastDate,VacancyStatusEnum vse,List<Skill> skills);
    public void deleteVacancyById(long vacancyId);
    public void updateVacancy(Vacancy vacancy);
    public Vacancy getVacancyById(long vacancyId);
    public List<Vacancy> getVacanciesByCompanyId(long companyId);
    public List<Vacancy> getVacanciesByStudentId(String studentId);
    public List<Vacancy> getVacanciesByContent(String content);
    public List<Vacancy> getAllVacancies();
    public void saveVacancy(Vacancy vacancy);
}
