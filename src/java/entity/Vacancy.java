/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import enums.VacancyStatusEnum;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 *
 * @author Justin
 */
@Entity
@JsonIgnoreProperties(value={"company","job","requiredSkills","applicants","selections"})
public class Vacancy {
    @Id
    @GeneratedValue
    private long vacancyId;
    
    private VacancyStatusEnum vacancyStatus;
    
    private String type;
    
    //双向
    @ManyToOne(cascade={CascadeType.MERGE},fetch=FetchType.EAGER)
    @JoinColumn(name="companyId")
    private Company company;
    
    //双向
    @ManyToOne(cascade={CascadeType.MERGE},fetch=FetchType.EAGER)
    @JoinColumn(name="jobId")
    private Job job;
    
    //双向
    @ManyToMany(cascade={CascadeType.MERGE},fetch=FetchType.EAGER)
    @JoinTable(
            name="skill_vacancy",
            joinColumns={@JoinColumn(name="vacancyId")},
            inverseJoinColumns={@JoinColumn(name="skillId")}
    )
    private List<Skill> requiredSkills=new ArrayList<Skill>();;
    
    private Date createTime;
    
    private Date lastDate;
    
    //双向
    @ManyToMany(cascade={CascadeType.MERGE},fetch=FetchType.EAGER)
    @JoinTable(
            name="students_vacancies",
            joinColumns={@JoinColumn(name="vacancyId")},
            inverseJoinColumns={@JoinColumn(name="studentId")}
    )
    private List<Student> applicants=new ArrayList<Student>();
    
    //双向
    @ManyToMany(cascade={CascadeType.MERGE},fetch=FetchType.EAGER)
    @JoinTable(
            name="vacancy_selections",
            joinColumns={@JoinColumn(name="vacancyId")},
            inverseJoinColumns={@JoinColumn(name="studentId")}
    )
    private List<Student> selections=new ArrayList<Student>();

    public Vacancy() {
    }

    public Vacancy(String type, Company company, Job job, Date lastDate) {
        this.vacancyStatus = VacancyStatusEnum.RECRUITING;
        this.type = type;
        this.company = company;
        this.job = job;
        this.createTime = new Date();
        this.lastDate = lastDate;
    }

    public long getVacancyId() {
        return vacancyId;
    }

    public void setVacancyId(long vacancyId) {
        this.vacancyId = vacancyId;
    }

    public VacancyStatusEnum getVacancyStatus() {
        return vacancyStatus;
    }

    public void setVacancyStatus(VacancyStatusEnum vacancyStatus) {
        this.vacancyStatus = vacancyStatus;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public List<Skill> getRequiredSkills() {
        return requiredSkills;
    }

    public void setRequiredSkills(List<Skill> requiredSkills) {
        this.requiredSkills = requiredSkills;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastDate() {
        return lastDate;
    }

    public void setLastDate(Date lastDate) {
        this.lastDate = lastDate;
    }

    public List<Student> getApplicants() {
        return applicants;
    }

    public void setApplicants(List<Student> applicants) {
        this.applicants = applicants;
    }

    public List<Student> getSelections() {
        return selections;
    }

    public void setSelections(List<Student> selections) {
        this.selections = selections;
    }
 
}
