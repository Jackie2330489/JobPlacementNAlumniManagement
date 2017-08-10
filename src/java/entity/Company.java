/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonSerialize;

/**
 *
 * @author Justin
 */
@Entity
@JsonIgnoreProperties(value={"jobs","vacancies","studentsOnDuty"})
public class Company {
    @Id
    @GeneratedValue
    private long companyId;
    
    @Column(unique=true,nullable=false)
    private String companyName;
    
    //双向 主控方
    @ManyToMany(cascade={CascadeType.MERGE},fetch=FetchType.EAGER)
    @JoinTable(
            name="job_company",
            joinColumns={@JoinColumn(name="companyId")},
            inverseJoinColumns={@JoinColumn(name="jobId")}
    )
    private List<Job> jobs=new ArrayList<Job>();
    
    //双向
    @OneToMany(cascade={CascadeType.MERGE},fetch=FetchType.EAGER)
    @JoinColumn(name="companyId")
    private List<Vacancy> vacancies=new ArrayList<Vacancy>();
    
    //双向
    @OneToMany(cascade={CascadeType.MERGE},fetch=FetchType.EAGER)
    @JoinColumn(name="companyId")
    private List<Student> studentsOnDuty=new ArrayList<Student>();

    public Company() {
    }

    public Company(String companyName) {
        this.companyName = companyName;
    }

    public long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(long companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public List<Job> getJobs() {
        return jobs;
    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }

    public List<Vacancy> getVacancies() {
        return vacancies;
    }

    public void setVacancies(List<Vacancy> vacancies) {
        this.vacancies = vacancies;
    }

    public List<Student> getStudentsOnDuty() {
        return studentsOnDuty;
    }

    public void setStudentsOnDuty(List<Student> studentsOnDuty) {
        this.studentsOnDuty = studentsOnDuty;
    }

}
