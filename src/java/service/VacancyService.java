/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.NotificationDao;
import dao.SkillDao;
import dao.StudentDao;
import dao.VacancyDao;
import dao.impl.CompanyDaoImpl;
import dao.impl.JobDaoImpl;
import dao.impl.NotificationDaoImpl;
import dao.impl.SkillCategoryDaoImpl;
import dao.impl.SkillDaoImpl;
import dao.impl.StudentDaoImpl;
import dao.impl.VacancyDaoImpl;
import dto.MsgExecution;
import dto.SuperDataExecution;
import entity.Company;
import entity.Job;
import entity.Skill;
import entity.SkillCategory;
import entity.Vacancy;
import java.util.ArrayList;
import java.util.List;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

/**
 *
 * @author Justin
 */
public class VacancyService {

    private VacancyDao vacancyDao = new VacancyDaoImpl();

    public MsgExecution sendnotis(long vacancyId){
        MsgExecution me=null;
        NotificationDao nDao=new NotificationDaoImpl();
        StudentDao sDao=new StudentDaoImpl();
        Vacancy vacancy=vacancyDao.getVacancyById(vacancyId);
        nDao.addNotification(vacancy.getCompany().getCompanyId(), "A new vacancy comes, vacancyId is <a href='vacancy.jsp?vacancyId="+vacancyId+"'>"+vacancyId+"</a>,Job is "+vacancy.getJob().getJobName()+".", sDao.getAllStudents());
        me=new MsgExecution(true,"Send Successly");
        return me;
    }
    
    public SuperDataExecution getVacancyByContent(String content) {
        SuperDataExecution sde = null;
        List<Vacancy> vacancies = vacancyDao.getVacanciesByContent(content);
        if (vacancies.size() == 0) {
            sde = new SuperDataExecution(false, "No Matched Vacancies");
        } else {
            List<List> lists = new ArrayList<List>();
            List<Job> list2 = new ArrayList<Job>();
            List<Company> list3 = new ArrayList<Company>();
            for (Vacancy vacancy : vacancies) {
                List<Skill> skills = vacancy.getRequiredSkills();
                lists.add(skills);
                list2.add(vacancy.getJob());
                list3.add(vacancy.getCompany());
            }
            sde = new SuperDataExecution(true, vacancies);
            sde.setList1(lists);
            sde.setList2(list2);
            sde.setList3(list3);
        }
        return sde;
    }

    public SuperDataExecution vacancyDetails(long vacancyId) {
        SuperDataExecution sde = null;
        Vacancy vacancy = vacancyDao.getVacancyById(vacancyId);
        sde = new SuperDataExecution(true, vacancy);
        sde.setData2(vacancy.getCompany());
        sde.setData3(vacancy.getJob());
        sde.setList1(vacancy.getRequiredSkills());
        sde.setList2(vacancy.getApplicants());
        sde.setList3(vacancy.getSelections());
        List<Company> companies = new CompanyDaoImpl().getAllCompanies();
        List<Job> jobs = new JobDaoImpl().getAllJobs();
//        List<Skill> skills=new SkillDaoImpl().getAllSkills();
        sde.setList4(companies);
        sde.setList5(jobs);
//        sde.setList6(skills);

        List<SkillCategory> skillCategorys = new SkillCategoryDaoImpl().getSkillCategorys();
        List<List<Skill>> listsOfSkills = new ArrayList();
        for (SkillCategory sc : skillCategorys) {
            listsOfSkills.add(sc.getScSons());
        }
        sde.setList6(skillCategorys);
        sde.setList7(listsOfSkills);

        return sde;
    }

    private List<Vacancy> getIntersection(List<Vacancy> list1, List<Vacancy> list2) {
        List<Vacancy> vacancies = new ArrayList<Vacancy>();
        for (Vacancy v : list2) {
            if (list1.contains(v)) {
                vacancies.add(v);
            }
        }
        return vacancies;
    }

    public SuperDataExecution filter(String[] arr) {
        SuperDataExecution sde = null;
        List<Vacancy> vacancies = null;
        int flag = 0;
        for (String content : arr) {
            if (flag == 0) {
                flag = 1;
                vacancies = vacancyDao.getVacanciesByContent(content);
            } else {
                vacancies = getIntersection(vacancies, vacancyDao.getVacanciesByContent(content));
            }
        }
        if (vacancies.isEmpty()) {
            sde = new SuperDataExecution(false, "No Matched Vacancies");
        } else {
            sde = new SuperDataExecution(true, vacancies);
            List<Company> companies = new ArrayList<Company>();
            List<Job> jobs = new ArrayList<Job>();
            List<List<Skill>> listsOfSkills = new ArrayList<List<Skill>>();
            for (Vacancy v : vacancies) {
                companies.add(v.getCompany());
                jobs.add(v.getJob());
                listsOfSkills.add(v.getRequiredSkills());
            }
            sde.setList1(companies);
            sde.setList2(jobs);
            sde.setList3(listsOfSkills);
        }
        return sde;
    }

    public SuperDataExecution allVacancies() {
        SuperDataExecution sde = null;
        List<Vacancy> vacancies = vacancyDao.getAllVacancies();
        sde = new SuperDataExecution(true, vacancies);
        List<Company> companies = new ArrayList();
        List<Job> jobs = new ArrayList();
        List<List<Skill>> listsOfSkills = new ArrayList();
        for (Vacancy v : vacancies) {
            companies.add(v.getCompany());
            jobs.add(v.getJob());
            listsOfSkills.add(v.getRequiredSkills());
        }
        sde.setList1(companies);
        sde.setList2(jobs);
        sde.setList3(listsOfSkills);
        return sde;
    }

    public MsgExecution saveOrUpdate(Vacancy vacancy, long companyId, long jobId, long[] skillIds) {
        MsgExecution me = null;
        Vacancy v = vacancyDao.getVacancyById(vacancy.getVacancyId());
        Company company = new CompanyDaoImpl().getCompanyById(companyId);
        Job job = new JobDaoImpl().getJobById(jobId);
        List<Skill> skills = new ArrayList();
        SkillDao sDao = new SkillDaoImpl();
        if(skillIds!=null)for (long s : skillIds) {
            skills.add(sDao.getSkillById(s));
        }
        vacancy.setCompany(company);
        vacancy.setJob(job);
        vacancy.setRequiredSkills(skills);
        if (v == null) {
//            vacancy.setCreateTime(new Date());
//            vacancy.setVacancyId(null);
            vacancyDao.addVacancy(companyId, vacancy.getType(), jobId, vacancy.getLastDate(),vacancy.getVacancyStatus(),skills);
            me = new MsgExecution(true, "Add Successly");
        } else {
            v.setCompany(company);
            v.setJob(job);
            v.setRequiredSkills(skills);
            v.setType(vacancy.getType());
            v.setLastDate(vacancy.getLastDate());
            v.setRequiredSkills(vacancy.getRequiredSkills());
            v.setVacancyStatus(vacancy.getVacancyStatus());
            vacancyDao.updateVacancy(v);
            me = new MsgExecution(true, "Update Successly");
        }
        return me;
    }
}
